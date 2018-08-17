package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<!--\n");
      out.write("To change this license header, choose License Headers in Project Properties.\n");
      out.write("To change this template file, choose Tools | Templates\n");
      out.write("and open the template in the editor.\n");
      out.write("-->\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Login</title>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css\" integrity=\"sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ\" crossorigin=\"anonymous\">\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.2.1.min.js\" integrity=\"sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js\" integrity=\"sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js\" integrity=\"sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"js/sendRegister.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/main.css\" >\n");
      out.write("        <script src=\"https://apis.google.com/js/platform.js\" async defer></script>\n");
      out.write("        <meta name=\"google-signin-client_id\" content=\"1035551989612-lf0aapld67ejeicji91nod6q27lpgmgm.apps.googleusercontent.com\">\n");
      out.write("    </head>\n");
      out.write("    <body class=\"register\">\n");
      out.write("        <center>\n");
      out.write("            <div class=\"jumbotron text-center\">\n");
      out.write("                <form id=\"form1\" action=\"LoginServlet\" method=\"post\">\n");
      out.write("                    <div class=\"input_fields\" style=\"width:50%; padding-bottom: 30px;\">\n");
      out.write("                        <img src=\"pics/logo.png\" style=\"width:70px; margin-bottom: 2px\"><br>\n");
      out.write("                        <label for = \"num2\">Username</label><br>\n");
      out.write("                        <input id=\"username\" type=\"text\" name =\"username\"><br><br>\n");
      out.write("                        <label for = \"num2\">Email</label><br>\n");
      out.write("                        <input id=\"email\" type=\"text\" name=\"email\"><br><br>\n");
      out.write("                        <input style=\"padding: 1rem ;background: #256F5B;\" id=\"submit\" type=\"submit\" value=\"Login\" class=\"btn btn-primary\"><br>\n");
      out.write("                        <div class=\"g-signin2\" data-onsuccess=\"onSignIn\" id=\"myP\" ></div><br>\n");
      out.write("                        <a href=\"index.jsp\" style=\"padding: 1rem 7rem; border-radius:.25rem; background: #256F5B; text-align: center; color: white; text-decoration: none; width: 30%;\">Register</a>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("       <script>   \n");
      out.write("         function onSignIn(googleUser) {\n");
      out.write("      // window.location.href='success.jsp';\n");
      out.write("        var profile = googleUser.getBasicProfile();\n");
      out.write("        var imagurl=profile.getImageUrl();\n");
      out.write("        var name=profile.getName();\n");
      out.write("        var email=profile.getEmail();  \n");
      out.write("          var form = $('<form action=\"RegisterGoogle \" method=\"post\">' +\n");
      out.write("                          '<input type=\"text\" name=\"name\" value=\"' +\n");
      out.write("                           name + '\" />' + '<input type=\"text\" name=\"email\" value=\"' +\n");
      out.write("                           email + '\" />' +\n");
      out.write("                                            \n");
      out.write("                                                                '</form>');\n");
      out.write("         $('body').append(form);\n");
      out.write("         form.submit();\n");
      out.write("   }\n");
      out.write("   </script>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
