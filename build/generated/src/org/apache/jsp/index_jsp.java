package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/index.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.min.css\">\n");
      out.write("        \n");
      out.write("        <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n");
      out.write("        <script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      ua.ticket.web.controllers.LoginController masageError = null;
      synchronized (_jspx_page_context) {
        masageError = (ua.ticket.web.controllers.LoginController) _jspx_page_context.getAttribute("masageError", PageContext.PAGE_SCOPE);
        if (masageError == null){
          masageError = new ua.ticket.web.controllers.LoginController();
          _jspx_page_context.setAttribute("masageError", masageError, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("       <div class=\"container\">\n");
      out.write("         <h2>Сторінка входу</h2>\n");
      out.write("         <p id = \"texstLog\">Будь ласка введіть Ваш логін та пароль</p>\n");
      out.write("         <form class=\"form-inline\" role=\"form\" action=\"LoginController\" method=\"POST\">\n");
      out.write("           <div class=\"form-group\">\n");
      out.write("             <label for=\"email\">Login:</label>\n");
      out.write("             <input type=\"email\" class=\"form-control\" id=\"email\" name = login placeholder=\"введіть Ваш Login\">\n");
      out.write("           </div>\n");
      out.write("           <div class=\"form-group\">\n");
      out.write("             <label for=\"pwd\">Password:</label>\n");
      out.write("             <input type=\"password\" class=\"form-control\" id=\"pwd\"  name = password placeholder=\"введіть Ваш пароль\">\n");
      out.write("           </div>\n");
      out.write("           <button type=\"submit\" class=\"btn_Send\">Відправити</button>\n");
      out.write("           ");
 if(session.getAttribute("login") != null && session.getAttribute("login").equals("loginFailed")){
      out.write("\n");
      out.write("                <p id = \"error_masage\">Введені дані хибні! Перевірте введену інформацію!</p>               \n");
      out.write("           ");
 session.invalidate(); }
      out.write("\n");
      out.write("         </form>\n");
      out.write("       </div>   \n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
