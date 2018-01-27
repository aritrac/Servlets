<%@page import="java.util.Iterator"%>
<%@page import="com.fog.computing.pojo.Question"%>
<%@page import="java.util.List"%>
<html>
<head></head>
<body style="background: E4D1D1">
	<!-- ALL JAVA CODE HERE -->
	<%
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
	%>
	<title>Registration</title>
	<div
		style="width: 70%; top: 0px; height: 80px; left: 230px; position: absolute">
		<h1 align="center">Fog Computing : Mitigating Insider Data Theft
			Attacks In the Cloud</h1>
	</div>
	<table
		style="width: 9%; position: absolute; top: 100px; height: 80x; left: 1060px; text-align: right"
		align="center">
		<th><a
			href="<%=request.getContextPath()%>/Dispatcher?pageid=register&actionid=doShowLogin">Go
				Back</a></th> 
		<table>
			<div
				style="width: 70%; top: 140px; height: 50px; left: 230px; position: absolute;">
				<h3 align="center">
					Enter Registration Details
					</h4>
			</div>
			<div
				style="width: 70%; top: 197px; height: 50px; border-style: solid; left: 230px; position: absolute; display: none">
				<h4 align="center">Some Message Abount Content Shown</h4>
			</div>
			<div
				style="width: 34%; top: 250px; height: 580px; left: 470px; position: absolute">
				<form
					action="<%=request.getContextPath()%>/Dispatcher?pageid=register&actionid=doRegister"
					method="POST">
					<table
						style="width: 70%; top: 260px; left: 270px; position: absolute">
						<tr>
							<td>
								<table>
									<tr>
										<td>FirstName</td>
										<td colspan="2"><input type="text" name="firstname"
											size="36" required /></td>
									</tr>
									<tr>
										<td>LastName</td>
										<td colspan="2"><input type="text" name="lastname"
											size="36" required /></td>
									</tr>
									<tr>
										<td>Password</td>
										<td colspan="2"><input type="password" name="password"
											size="36" required /></td>
									</tr>
									<tr>
										<td>Confirm Password</td>
										<td colspan="2"><input type="password"
											name="confirm_password" size="36" required /></td>
									</tr>
									<tr style="<%=passwordDontMatch%>">
										<td><font color="Red">Error</font></td>
										<td colspan="2"><font color="Red">Password Dont
												Match</font></td>
									</tr>
									<tr>
										<td>Email ID</td>
										<td colspan="2"><input type="text" name="email_id"
											size="36" required /></td>
									</tr>
									<tr style="<%=invalidEmail%>">
										<td><font color="Red">Error</font></td>
										<td colspan="2"><font color="Red">Invalid Email or
												Email Already Exists</font></td>
									</tr>
									<tr>
										<td>Mobile Number</td>
										<td colspan="2"><input type="text" name="mobile_number"
											size="36" required /></td>
									</tr>
									<tr style="<%=invalidMobileNumber%>">
										<td><font color="Red">Error</font></td>
										<td colspan="2"><font color="Red">Invalid Mobile
												Number Format Or Already Exists</font></td>
									</tr>
									<tr>
										<td>Address</td>
										<td colspan="2"><input type="text" name="address"
											size="36" required /></td>
									</tr>
									<tr>
										<td>City</td>
										<td colspan="2"><input type="text" name="city" size="36"
											required /></td>
									</tr>
									<tr style="<%=cityHasNonAlphabets%>">
										<td><font color="Red">Error</font></td>
										<td colspan="2"><font color="Red">City Has Non-Alphabets</font></td>
									</tr>
									<tr>
										<td>State</td>
										<td colspan="2"><input type="text" name="state" size="36"
											required /></td>
									</tr>
									<tr style="<%=stateHasNonAlphabets%>">
										<td><font color="Red">Error</font></td>
										<td colspan="2"><font color="Red">State Has Non-Alphabets</font></td>
									</tr>
									<tr>
										<td>Zipcode</td>
										<td colspan="2"><input type="text" name="zipcode"
											size="36" required /></td>
									</tr>
									<tr style="<%=zipHasNonNumbers%>">
										<td><font color="Red">Error</font></td>
										<td colspan="2"><font color="Red">Zipcode Has Non-Numbers</font></td>
									</tr>
									<tr>
										<td>Download Time</td>
										<td>Start Hr</td>
										<td>End Hr</td>
									</tr>
									<tr style="<%=startGreaterThanEnd%>">
										<td><font color="Red">Error</font></td>
										<td colspan="2"><font color="Red">Start Time
												Greater Than End Time</font></td>
									</tr>
									<tr>
										<td></td>
										<td><input name="startHH" type="number" min="0" max="23"
											value="00" required></td>
										<td><input name="endHH" type="number" min="0" max="23"
											value="00" required></td>
									</tr>
								</table>
							</td>
							<td />
							<table>
								<%
									Iterator<Question> iter = questions.iterator();
									Question[] qstns = new Question[5];
									int number = 0;
									while (iter.hasNext()) {
										qstns[number++] = iter.next();
									}
									for (int i = 1; i <= 5; i++) {
								%>
								<tr>
									<td>Security Question <%=i%></td>
									<td colspan="2"><select name="seq<%=i%>" required>
											<option selected>Select your security question</option>
											<option value="<%=qstns[0].getSecurityQuestion()%>"><%=qstns[0].getSecurityQuestion()%></option>
											<option value="<%=qstns[1].getSecurityQuestion()%>"><%=qstns[1].getSecurityQuestion()%></option>
											<option value="<%=qstns[2].getSecurityQuestion()%>"><%=qstns[2].getSecurityQuestion()%></option>
											<option value="<%=qstns[3].getSecurityQuestion()%>"><%=qstns[3].getSecurityQuestion()%></option>
											<option value="<%=qstns[4].getSecurityQuestion()%>"><%=qstns[4].getSecurityQuestion()%></option>
									</select></td>
								</tr>
								<tr>
									<td>Answer</td>
									<td colspan="2"><input type="text" name="ans<%=i%>"
										size="36" required /></td>
								</tr>
								<%
									}
								%>
								<tr style="<%=securityQuestionRepeated%>">
									<td><font color="Red">Error</font></td>
									<td colspan="2"><font color="Red">Security
											Questions Repeated</font></td>
								</tr>
								<tr>
									<td colspan="3" align="center"><input type="submit"
										value="Register"></td>
								</tr>
							</table>
							</td>
						</tr>
					</table>
				</form>
			</div>
</body>
</html>
