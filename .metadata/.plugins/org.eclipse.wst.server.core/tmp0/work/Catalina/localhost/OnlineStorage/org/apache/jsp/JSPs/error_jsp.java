/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.28
 * Generated at: 2016-02-21 07:50:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.JSPs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class error_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = null;
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

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<!-- errorType -->\n");
      out.write("<!-- errorMessage -->\n");
      out.write("<head>\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\t<title>Fog Computing</title>\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/flat-ui/2.2.2/css/flat-ui.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/flat-ui/2.2.2/css/flat-ui.css.map\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css\">\n");
      out.write("    <!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"../css/style.css\"> -->\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<!-- navbar here -->\n");
      out.write("\t<nav class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">\n");
      out.write("\t\t<div class=\"container\">\n");
      out.write("\t\t\t<div class=\"navbar-header\">\n");
      out.write("                <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar\" aria-expanded=\"false\" aria-controls=\"navbar\">\n");
      out.write("                    <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                </button>\n");
      out.write("                <a class=\"navbar-brand\" href=\"#\">Fog Computing Encountered An Error</a>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"navbar\" class=\"navbar-collapse collapse\">\n");
      out.write("                              \n");
      out.write("            </div>\n");
      out.write("\t\t</div><!-- container div ends here -->\n");
      out.write("\t</nav><!-- navbar ends here -->\n");
      out.write("</body>\n");
String errorType = (String)request.getAttribute("errorType");
  String showLogin = ""; 
  String showRegistration = "";
  if(errorType.equalsIgnoreCase("login_error")){
	  showLogin = "";
	  showRegistration = "display:none";
  }
  if(errorType.equalsIgnoreCase("registration_error")){
	  showLogin = "display:none";
	  showRegistration = "";
  }
      out.write("\n");
      out.write("\t<!-- LOGIN ERROR DIV -->\n");
      out.write("\t<div class=\"container\" style=\"margin-top:150px;");
      out.print(showLogin );
      out.write("\">\n");
      out.write("\t\t<div class=\"row row-content\">\n");
      out.write("\t\t\t<div class=\"col-xs-12 col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4\">\n");
      out.write("\t\t\t\t<div class=\"panel panel-default\">\n");
      out.write("\t\t\t\t\t<div class=\"panel-body\">\n");
      out.write("\t\t\t\t\t\t<h4 class=\"text-center\">");
      out.print(request.getAttribute("errorMessage"));
      out.write("</h4>\n");
      out.write("\t\t\t\t\t\t<h4 class=\"text-center\">Please login again</h4>\n");
      out.write("\t\t\t\t\t\t<form action=\"Dispatcher?pageid=showLoginPage\" method=\"POST\">\n");
      out.write("\t\t\t\t\t\t\t<!-- user name input -->\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<!-- login button -->\n");
      out.write("\t\t\t\t\t\t\t<input type=\"submit\" class=\"btn btn-lg btn-block btn-inverse\" value=\"Login\">\n");
      out.write("\t\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<!-- REGISTRATION ERROR DIV -->\n");
      out.write("\t<div class=\"container\" style=\"margin-top:150px;");
      out.print(showRegistration );
      out.write("\">\n");
      out.write("\t\t<div class=\"row row-content\">\n");
      out.write("\t\t\t<div class=\"col-xs-12 col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4\">\n");
      out.write("\t\t\t\t<div class=\"panel panel-default\">\n");
      out.write("\t\t\t\t\t<div class=\"panel-body\">\n");
      out.write("\t\t\t\t\t\t<h4 class=\"text-center\">");
      out.print(request.getAttribute("errorMessage"));
      out.write("</h4>\n");
      out.write("\t\t\t\t\t\t<h4 class=\"text-center\">Please register again</h4>\n");
      out.write("\t\t\t\t\t\t<form action=\"Dispatcher?pageid=showRegistrationPage\" method=\"POST\">\n");
      out.write("\t\t\t\t\t\t\t<!-- user name input -->\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<!-- login button -->\n");
      out.write("\t\t\t\t\t\t\t<input type=\"submit\" class=\"btn btn-lg btn-block btn-inverse\" value=\"Register\">\n");
      out.write("\t\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>\n");
      out.write("\t<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js\">\n");
      out.write("\t</script>\n");
      out.write("\t<script src=\"https://cdnjs.cloudflare.com/ajax/libs/flat-ui/2.2.2/js/flat-ui.min.js\"></script>\n");
      out.write("</html>");
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