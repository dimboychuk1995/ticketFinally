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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("    <CENTER>\r\n");
      out.write("        <div class=\"main\">\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"header\"></div>\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"content\">\r\n");
      out.write("                \r\n");
      out.write("                <div class=\"login\">\r\n");
      out.write("                    <br><h2>Сторінка входу</h2>\r\n");
      out.write("                        <br  id = \"login_table\">\r\n");
      out.write("                        <h6>Будь ласка введіть Ваш логін та пароль</h6>\r\n");
      out.write("                            <br>\r\n");
      out.write("                               <form class=\"login_form\" action=\"LoginController\" method=\"POST\">\r\n");
      out.write("                                   <table>\r\n");
      out.write("                                       <tr>\r\n");
      out.write("                                           <td><font> логін </font></td>\r\n");
      out.write("                                           <td><input type = text name = login></td>\r\n");
      out.write("                                       </tr>\r\n");
      out.write("                                       <tr>\r\n");
      out.write("                                           <td><font> пароль </font></td>\r\n");
      out.write("                                           <td><input type = password name = password> </td>\r\n");
      out.write("                                       </tr>\r\n");
      out.write("                                       <tr>\r\n");
      out.write("                                           <td align = right><input type=\"submit\" value=\"ok\" ></td>\r\n");
      out.write("                                       </tr>\r\n");
      out.write("                                   </table>\r\n");
      out.write("                               </form>  \r\n");
      out.write("                                \r\n");
      out.write("                            </br>\r\n");
      out.write("                         </br>\r\n");
      out.write("                    </br>\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("        </div>\r\n");
      out.write("    </CENTER>    \r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
