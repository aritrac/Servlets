package com.fog.computing.page.handler;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fog.computing.dao.QuestionsDAO;
import com.fog.computing.dao.UserDAO;
import com.fog.computing.pojo.User;

public class RegistrationPageHandler {
	// REQUEST AND RESPONSE OBJECTS
	private HttpServletRequest request;
	private HttpServletResponse response;

	// PAGE PARAMETERS
	String pageId = null;
	String actionId = null;
	String username = null;
	String firstname = null;
	String lastname = null;
	String password = null;
	String confirmPassword = null;
	String emailId = null;
	String mobileNumber = null;
	String address = null;
	String state = null;
	String city = null;
	String zipcode = null;
	String startHH = null;
	String endHH = null;
	String seq1 = null;
	String ans1 = null;
	String seq2 = null;
	String ans2 = null;
	String seq3 = null;
	String ans3 = null;
	String seq4 = null;
	String ans4 = null;
	String seq5 = null;
	String ans5 = null;

	// SESSION ATTRIBUTES

	// ERROR ATTRIBUTES
	String passwordDontMatch = null;
	String invalidEmail = null;
	String invalidMobileNumber = null;
	String startGreaterThanEnd = null;
	String securityQuestionRepeated = null;
	String stateHasNonAlphabets = null;
	String cityHasNonAlphabets = null;
	String zipHasNonNumbers = null;
	
	// PAGE ATTRIBUTES
	String uniqueCode = null;
	
	// PAGE HANDLER CONSTRUCTOR
	public RegistrationPageHandler(HttpServletRequest request,
			HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	// GET ALL PARAMS FROM PAGE
	private void initParams() {
		pageId = request.getParameter("pageid");
		actionId = request.getParameter("actionid");
		firstname = request.getParameter("firstname");
		lastname = request.getParameter("lastname");
		username = firstname + " " + lastname;
		password = request.getParameter("password");
		confirmPassword = request.getParameter("confirm_password");
		emailId = request.getParameter("email_id");
		mobileNumber = request.getParameter("mobile_number");
		address = request.getParameter("address");
		state = request.getParameter("state");
		city = request.getParameter("city");
		zipcode = request.getParameter("zipcode");
		startHH = request.getParameter("startHH");
		endHH = request.getParameter("endHH");
		seq1 = request.getParameter("seq1");
		ans1 = request.getParameter("ans1");
		seq2 = request.getParameter("seq2");
		ans2 = request.getParameter("ans2");
		seq3 = request.getParameter("seq3");
		ans3 = request.getParameter("ans3");
		seq4 = request.getParameter("seq4");
		ans4 = request.getParameter("ans4");
		seq5 = request.getParameter("seq5");
		ans5 = request.getParameter("ans5");
	}

	// SET SESSION ATTRIBUTES FOR THE PAGE
	private void setSessionAttributes() {
		QuestionsDAO qDao = new QuestionsDAO(request.getServletContext());
		request.getSession().setAttribute("questions", qDao.getQuestions());
	}

	// SET ERROR ATTRIBUTES FOR PAGE
	private void setErrorAttributes() {
		request.setAttribute("passwordDontMatch", passwordDontMatch);
		request.setAttribute("invalidEmail", invalidEmail);
		request.setAttribute("invalidMobileNumber", invalidMobileNumber);
		request.setAttribute("startGreaterThanEnd", startGreaterThanEnd);
		request.setAttribute("securityQuestionRepeated", securityQuestionRepeated);
		request.setAttribute("stateHasNonAlphabets", stateHasNonAlphabets);
		request.setAttribute("cityHasNonAlphabets", cityHasNonAlphabets);
		request.setAttribute("zipHasNonNumbers", zipHasNonNumbers);
	}
	
	// SET PAGE ATTRIBUTES
	private void setPageAttributes(){
		request.setAttribute("uniqueCode", uniqueCode);
	}

	// CONTROLS THE LOGIC FOR THE RESOURCE
	public void handle() throws IOException, ServletException {
		initParams();

		if (actionId.equalsIgnoreCase("doRegister")) {
			doRegister();
		}

		if (actionId.equalsIgnoreCase("doShowLogin")) {
			doShowLogin();
		}
	}

	// ACTION ID -> doRegister
	public void doRegister() throws IOException, ServletException {
		//Validating All Fields
		validatePassword();
		validateEmail();
		validateMobileNumber();
		validateStartEnd();
		validateSecurityQuestions();
		validateCity();
		validateState();
		validateZip();
		
		//ONE OF THE ERRORS IS TRUE
		if(passwordDontMatch != null || invalidEmail != null || invalidMobileNumber != null || startGreaterThanEnd != null || securityQuestionRepeated != null || cityHasNonAlphabets != null || stateHasNonAlphabets != null || zipHasNonNumbers != null){
			//SHOW THE ERROR PAGE
			showError();
		}else{
			//PUT DETAILS IN DB
			User user = new User();
			user.setAddress(address);
			
			Calendar cal = Calendar.getInstance();
			
			user.setCreationDate(new java.sql.Date(cal.getTimeInMillis()));
			user.setEmailId(emailId);
			user.setEndHH(Integer.valueOf(endHH));
			user.setMobileNo(mobileNumber);
			user.setPassword(password);
			user.setSecurityAnswer(ans1);
			user.setSecurityAnswer2(ans2);
			user.setSecurityAnswer3(ans3);
			user.setSecurityAnswer4(ans4);
			user.setSecurityAnswer5(ans5);
			user.setSecurityQuestion(seq1);
			user.setSecurityQuestion2(seq2);
			user.setSecurityQuestion3(seq3);
			user.setSecurityQuestion4(seq4);
			user.setSecurityQuestion5(seq5);
			user.setStartHH(Integer.valueOf(startHH));
			user.setUserName(username);
			user.setUserType("REGISTERED");
			user.setState(state);
			user.setCity(city);
			user.setZipCode(zipcode);
			
			UserDAO userDAO = new UserDAO(request.getServletContext());
			uniqueCode = userDAO.createUser(user);
			if(uniqueCode != null){//USER SUCCESSFULLY CREATED
				//SHOW REGISTRATION SUCCESS PAGE WITH UNIQUE CODE FOR FILE DOWNLOAD
				setPageAttributes();
				request.getRequestDispatcher("JSPs/registration_done.jsp").forward(request, response);
			}else{
				//SHOW ERROR PAGE WITH ERROR MESSAGE
			}
		}
	}

	// ACTION ID -> doShowLogin
	public void doShowLogin() throws IOException {
		LoginPageHandler lpHandler = new LoginPageHandler(request, response);
		lpHandler.show();
	}

	// SHOW THE PAGE
	public void show() throws IOException {
		setSessionAttributes();
		response.sendRedirect("JSPs/register.jsp");
	}

	// SHOW PAGE WITH ERROR
	public void showError() throws IOException, ServletException {
		// ON UNSUCCESSFUL LOGIN SHOW ERROR
		setErrorAttributes();
		setSessionAttributes();
		request.getRequestDispatcher("JSPs/register.jsp").forward(request,
				response);
	}
	
	//VALIDATION METHOD FOR PASSWORD
	private void validatePassword(){
		if(!password.equals(confirmPassword)){
			passwordDontMatch = "true";
		}
	}
	
	//VALIDATION METHOD FOR EMAIL
	private void validateEmail(){
		String EMAIL_PATTERN = 
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(emailId);
		if(!matcher.matches()){
			invalidEmail = "true";
		}
		UserDAO userDao = new UserDAO(request.getServletContext());
		if(userDao.isEmailExisting(emailId)){
			invalidEmail = "true";
		}
	}
	
	//VALIDATION METHOD FOR MOBILE
	private void validateMobileNumber(){
		if(mobileNumber.length() != 10){
			invalidMobileNumber = "true";
		}
		int i ;
		for(i = 0; i < mobileNumber.length(); i++){
			if(mobileNumber.charAt(i) >= "0".charAt(0) && mobileNumber.charAt(i) <= "9".charAt(0)){
				continue;
			}else{
				break;
			}
		}
		if(i != mobileNumber.length()){
			invalidMobileNumber = "true";
		}
		
		UserDAO userDao = new UserDAO(request.getServletContext());
		if(userDao.isMobileNumberExisting(mobileNumber)){
			invalidMobileNumber = "true";
		}
	}
	
	//VALIDATE CITY
	private void validateCity(){
		for(int i = 0; i < city.length(); i++){
			if((city.charAt(i) >= "A".charAt(0) && city.charAt(i) <= "Z".charAt(0))||(city.charAt(i) >= "a".charAt(0) && city.charAt(i) <= "z".charAt(0))){
				continue;
			}else{
				cityHasNonAlphabets = "true";
			}
		}
	}
	
	//VALIDATE STATE
	private void validateState(){
		for(int i = 0; i < state.length(); i++){
			if((state.charAt(i) >= "A".charAt(0) && state.charAt(i) <= "Z".charAt(0))||(state.charAt(i) >= "a".charAt(0) && state.charAt(i) <= "z".charAt(0))){
				continue;
			}else{
				stateHasNonAlphabets = "true";
			}
		}
	}
	
	//VALIDATE ZIP
	private void validateZip(){
		for(int i = 0; i < zipcode.length(); i++){
			if(zipcode.charAt(i) >= "0".charAt(0) && zipcode.charAt(i) <= "9".charAt(0)){
				continue;
			}else{
				zipHasNonNumbers = "true";
			}
		}
	}
	
	//VALIDATION METHOD FOR TIME RANGE
	private void validateStartEnd(){
		int start = Integer.parseInt(startHH);
		int end = Integer.parseInt(endHH);
		
		if(start >= end){
			startGreaterThanEnd = "true";
		}
	}
	
	//VALIDATION METHOD FOR UNIQUENESS OF SECURITY QUESTIONS
	private void validateSecurityQuestions(){
		Set<String> questions = new HashSet<String>();
		questions.add(seq1);
		questions.add(seq2);
		questions.add(seq3);
		questions.add(seq4);
		questions.add(seq5);
		
		if(questions.size() != 5){
			securityQuestionRepeated = "true";
		}
		
	}
}
