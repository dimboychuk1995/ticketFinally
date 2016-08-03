package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addGame_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>addGame</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div>\n");
      out.write("        <br>\n");
      out.write("            <form  action=\"../GamesController\" method=\"POST\" >\n");
      out.write("                <div class=\"col-xs-1\">\n");
      out.write("                    <input id = \"inputAddTime\" class=\"form-control\" type=\"text\" name= \"time\"    value=\"\" size=\"3\" placeholder = \"час\"/>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-xs-2\">\n");
      out.write("                    <input class=\"form-control\" type=\"text\" name= \"date\"    value=\"\" size=\"20\" placeholder = \"дата матчу\"/>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-xs-2\">\n");
      out.write("                    <input class=\"form-control\" type=\"text\" name= \"owner\"   value=\"\" size=\"20\" placeholder = \"господар\"/>\n");
      out.write("                </div>\n");
      out.write("                    <div class=\"col-xs-2\">\n");
      out.write("                <input class=\"form-control\" type=\"text\" name= \"guest\"   value=\"\" size=\"20\" placeholder = \"гості\"/>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-xs-2\">\n");
      out.write("                    <input class=\"form-control\" type=\"text\" name= \"place\"   value=\"\" size=\"20\" placeholder = \"місце проведення\"/>                                            </div>\\n\\\n");
      out.write("                <input id=\"insertGame\" type=\"hidden\" name=\"insertGame\" value=\"insertGame\" />\n");
      out.write("                <button class = \"btn btn-success\" type=\"submit\">зберегти</button>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
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
