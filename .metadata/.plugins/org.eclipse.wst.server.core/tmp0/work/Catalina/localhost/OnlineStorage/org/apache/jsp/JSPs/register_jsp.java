/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.28
 * Generated at: 2016-03-13 05:07:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.JSPs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import com.fog.computing.pojo.Question;
import java.util.List;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.Iterator");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.fog.computing.pojo.Question");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head></head>\r\n");
      out.write("<body style=\"background: E4D1D1\">\r\n");
      out.write("\t<!-- ALL JAVA CODE HERE -->\r\n");
      out.write("\t");

		List<Question> questions = null;
		String passwordDontMatch = "display:none";
		String invalidEmail = "display:none";
		String invalidMobileNumber = "display:none";
		String startGreaterThanEnd = "display:none";
		String securityQuestionRepeated = "display:none";
		String stateHasNonAlphabets = "display:none";
		String cityHasNonAlphabets = "display:none";
		String zipHasNonNumbers = "display:none";
		if (request.getAttribute("passwordDontMatch") != null) {
			passwordDontMatch = "";
		}
		if (request.getAttribute("invalidEmail") != null) {
			invalidEmail = "";
		}
		if (request.getAttribute("invalidMobileNumber") != null) {
			invalidMobileNumber = "";
		}
		if (request.getAttribute("startGreaterThanEnd") != null) {
			startGreaterThanEnd = "";
		}
		if (request.getAttribute("securityQuestionRepeated") != null) {
			securityQuestionRepeated = "";
		}
		if (request.getAttribute("stateHasNonAlphabets") != null) {
			stateHasNonAlphabets = "";
		}
		if (request.getAttribute("cityHasNonAlphabets") != null) {
			cityHasNonAlphabets = "";
		}
		if (request.getAttribute("zipHasNonNumbers") != null) {
			zipHasNonNumbers = "";
		}
		if (session.getAttribute("questions") != null) {
			questions = (List<Question>) session.getAttribute("questions");
		}
	
      out.write("\r\n");
      out.write("\t<title>Registration</title>\r\n");
      out.write("\t<div\r\n");
      out.write("\t\tstyle=\"width: 70%; top: 0px; height: 80px; left: 230px; position: absolute\">\r\n");
      out.write("\t\t<h1 align=\"center\">Fog Computing : Mitigating Insider Data Theft\r\n");
      out.write("\t\t\tAttacks In the Cloud</h1>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<table\r\n");
      out.write("\t\tstyle=\"width: 9%; position: absolute; top: 100px; height: 80x; left: 1060px; text-align: right\"\r\n");
      out.write("\t\talign=\"center\">\r\n");
      out.write("\t\t<th><a\r\n");
      out.write("\t\t\thref=\"");
      out.print(request.getContextPath());
      out.write("/Dispatcher?pageid=register&actionid=doShowLogin\">Go\r\n");
      out.write("\t\t\t\tBack</a></th> \r\n");
      out.write("\t\t<table>\r\n");
      out.write("\t\t\t<div\r\n");
      out.write("\t\t\t\tstyle=\"width: 70%; top: 140px; height: 50px; left: 230px; position: absolute;\">\r\n");
      out.write("\t\t\t\t<h3 align=\"center\">\r\n");
      out.write("\t\t\t\t\tEnter Registration Details\r\n");
      out.write("\t\t\t\t\t</h4>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div\r\n");
      out.write("\t\t\t\tstyle=\"width: 70%; top: 197px; height: 50px; border-style: solid; left: 230px; position: absolute; display: none\">\r\n");
      out.write("\t\t\t\t<h4 align=\"center\">Some Message Abount Content Shown</h4>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div\r\n");
      out.write("\t\t\t\tstyle=\"width: 34%; top: 250px; height: 580px; left: 470px; position: absolute\">\r\n");
      out.write("\t\t\t\t<form\r\n");
      out.write("\t\t\t\t\taction=\"");
      out.print(request.getContextPath());
      out.write("/Dispatcher?pageid=register&actionid=doRegister\"\r\n");
      out.write("\t\t\t\t\tmethod=\"POST\">\r\n");
      out.write("\t\t\t\t\t<table\r\n");
      out.write("\t\t\t\t\t\tstyle=\"width: 70%; top: 260px; left: 270px; position: absolute\">\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>FirstName</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td colspan=\"2\"><input type=\"text\" name=\"firstname\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tsize=\"36\" required /></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>LastName</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td colspan=\"2\"><input type=\"text\" name=\"lastname\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tsize=\"36\" required /></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>Password</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td colspan=\"2\"><input type=\"password\" name=\"password\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tsize=\"36\" required /></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>Confirm Password</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td colspan=\"2\"><input type=\"password\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tname=\"confirm_password\" size=\"36\" required /></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr style=\"");
      out.print(passwordDontMatch);
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td><font color=\"Red\">Error</font></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td colspan=\"2\"><font color=\"Red\">Password Dont\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tMatch</font></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>Email ID</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td colspan=\"2\"><input type=\"text\" name=\"email_id\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tsize=\"36\" required /></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr style=\"");
      out.print(invalidEmail);
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td><font color=\"Red\">Error</font></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td colspan=\"2\"><font color=\"Red\">Invalid Email or\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tEmail Already Exists</font></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>Mobile Number</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td colspan=\"2\"><input type=\"text\" name=\"mobile_number\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tsize=\"36\" required /></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr style=\"");
      out.print(invalidMobileNumber);
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td><font color=\"Red\">Error</font></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td colspan=\"2\"><font color=\"Red\">Invalid Mobile\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tNumber Format Or Already Exists</font></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>Address</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td colspan=\"2\"><input type=\"text\" name=\"address\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tsize=\"36\" required /></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>City</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td colspan=\"2\"><input type=\"text\" name=\"city\" size=\"36\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\trequired /></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr style=\"");
      out.print(cityHasNonAlphabets);
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td><font color=\"Red\">Error</font></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td colspan=\"2\"><font color=\"Red\">City Has Non-Alphabets</font></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>State</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td colspan=\"2\"><input type=\"text\" name=\"state\" size=\"36\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\trequired /></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr style=\"");
      out.print(stateHasNonAlphabets);
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td><font color=\"Red\">Error</font></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td colspan=\"2\"><font color=\"Red\">State Has Non-Alphabets</font></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>Zipcode</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td colspan=\"2\"><input type=\"text\" name=\"zipcode\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tsize=\"36\" required /></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr style=\"");
      out.print(zipHasNonNumbers);
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td><font color=\"Red\">Error</font></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td colspan=\"2\"><font color=\"Red\">Zipcode Has Non-Numbers</font></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>Download Time</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>Start Hr</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>End Hr</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr style=\"");
      out.print(startGreaterThanEnd);
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td><font color=\"Red\">Error</font></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td colspan=\"2\"><font color=\"Red\">Start Time\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tGreater Than End Time</font></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td><input name=\"startHH\" type=\"number\" min=\"0\" max=\"23\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tvalue=\"00\" required></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td><input name=\"endHH\" type=\"number\" min=\"0\" max=\"23\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tvalue=\"00\" required></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td />\r\n");
      out.write("\t\t\t\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t\t\t\t");

									Iterator<Question> iter = questions.iterator();
									Question[] qstns = new Question[5];
									int number = 0;
									while (iter.hasNext()) {
										qstns[number++] = iter.next();
									}
									for (int i = 1; i <= 5; i++) {
								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>Security Question ");
      out.print(i);
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td colspan=\"2\"><select name=\"seq");
      out.print(i);
      out.write("\" required>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option selected>Select your security question</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"");
      out.print(qstns[0].getSecurityQuestion());
      out.write('"');
      out.write('>');
      out.print(qstns[0].getSecurityQuestion());
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"");
      out.print(qstns[1].getSecurityQuestion());
      out.write('"');
      out.write('>');
      out.print(qstns[1].getSecurityQuestion());
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"");
      out.print(qstns[2].getSecurityQuestion());
      out.write('"');
      out.write('>');
      out.print(qstns[2].getSecurityQuestion());
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"");
      out.print(qstns[3].getSecurityQuestion());
      out.write('"');
      out.write('>');
      out.print(qstns[3].getSecurityQuestion());
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"");
      out.print(qstns[4].getSecurityQuestion());
      out.write('"');
      out.write('>');
      out.print(qstns[4].getSecurityQuestion());
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</select></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>Answer</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td colspan=\"2\"><input type=\"text\" name=\"ans");
      out.print(i);
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tsize=\"36\" required /></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t");

									}
								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr style=\"");
      out.print(securityQuestionRepeated);
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td><font color=\"Red\">Error</font></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td colspan=\"2\"><font color=\"Red\">Security\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tQuestions Repeated</font></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td colspan=\"3\" align=\"center\"><input type=\"submit\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tvalue=\"Register\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}