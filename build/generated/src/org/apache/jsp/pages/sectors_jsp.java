package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ua.ticket.web.controllers.SectorController;
import ua.ticket.web.beans.Sector;

public final class sectors_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <title>Довідник секторів</title>\n");
      out.write("\n");
      out.write("    <!-- Bootstrap -->\n");
      out.write("    <link href=\"../css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->\n");
      out.write("    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n");
      out.write("    <!--[if lt IE 9]>\n");
      out.write("      <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\n");
      out.write("      <script src=\"https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js\"></script>\n");
      out.write("    <![endif]-->\n");
      out.write("  </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        ");
      ua.ticket.web.controllers.SectorController sectorList = null;
      synchronized (_jspx_page_context) {
        sectorList = (ua.ticket.web.controllers.SectorController) _jspx_page_context.getAttribute("sectorList", PageContext.PAGE_SCOPE);
        if (sectorList == null){
          sectorList = new ua.ticket.web.controllers.SectorController();
          _jspx_page_context.setAttribute("sectorList", sectorList, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"header\">\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"content\">\n");
      out.write("            <div class=\"forms\">\n");
      out.write("                ");

                    for(Sector sector : sectorList.getSectorAll()){
                
      out.write("\n");
      out.write("                <form action=\"../SectorController\" method=\"POST\">\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <input id=\"id\" type=\"text\" name=\"id\" value=\"");
      out.print(sector.getId());
      out.write("\" size=\"20\" />\n");
      out.write("                        <input id=\"name\" type=\"text\" name=\"name\" value=\"");
      out.print(sector.getName());
      out.write("\" size=\"20\" />\n");
      out.write("                        <input id=\"price\" type=\"text\" name=\"price\" value=\"");
      out.print(sector.getPrice());
      out.write("\" size=\"20\" />\n");
      out.write("                    </div>\n");
      out.write("                    <button id=\"btn_update\" value=\"update\" type=\"submit\" class=\"btn btn-warning\">Оновити</button>\n");
      out.write("                </form>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("                \n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("                \n");
      out.write("                \n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js\"></script>\n");
      out.write("    \n");
      out.write("        <script src=\"../js/bootstrap.min.js\"></script>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("\n");
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
