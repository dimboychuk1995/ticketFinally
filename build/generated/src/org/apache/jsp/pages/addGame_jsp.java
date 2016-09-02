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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("      \r\n");
      out.write("        <link href=\"../css/datePicker/jquery-ui.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"../css/datePicker/jquery-ui.min.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"../css/datePicker/jquery-ui.structure.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"../css/datePicker/jquery-ui.structure.min.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"../css/datePicker/jquery-ui.theme.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"../css/datePicker/jquery-ui.theme.min.css\" rel=\"stylesheet\">\r\n");
      out.write("        \r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/timePicker/bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/timePicker/bootstrap-datetimepicker.min.css\">\r\n");
      out.write("\r\n");
      out.write("        <script src=\"../js/jquery.min.js\"></script> \r\n");
      out.write("        <script type=\"text/javascript\" src=\"../js/timePicker/moment-with-locales.min.js\"></script>\r\n");
      out.write("        <script src=\"../js/timePicker/bootstrap.min.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"../js/timePicker/bootstrap-datetimepicker.min.js\"></script>\r\n");
      out.write("        \r\n");
      out.write("        <script src=\"../js/timePicker/bootstrap.min.js\"></script>\r\n");
      out.write("          \r\n");
      out.write("        <script src=\"../js/datePicker/jquery-ui.js\"></script>\r\n");
      out.write("        <script src=\"../js/datePicker/jquery-ui.min.js\"></script>\r\n");
      out.write("        \r\n");
      out.write("        <script src=\"../js/timePicker/timePicker.js\"></script>\r\n");
      out.write("        <script src=\"../js/datePicker/datePicker.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\"></script>\r\n");
      out.write("      \r\n");
      out.write("        <title>addGame</title>\r\n");
      out.write("                \r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div>\r\n");
      out.write("        <br>\r\n");
      out.write("            <form  action=\"../GamesController\" method=\"POST\" >\r\n");
      out.write("                <div class =\"col-xs-2\">\r\n");
      out.write("                        <select class=\"form-control\" name=\"season\">\r\n");
      out.write("                            <option id=\"season\">2015-2016</option>\r\n");
      out.write("                            <option id=\"season\">2016-2017</option>\r\n");
      out.write("                            <option id=\"season\">2017-2018</option>\r\n");
      out.write("                            <option id=\"season\">2018-2019</option>\r\n");
      out.write("                        </select>\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("                <div class=\"col-xs-1\">\r\n");
      out.write("                    <input data-format=\"HH:mm:ss\" id=\"datetimepicker3\" class=\"form-control input-small\" type=\"text\" name= \"time\"    value=\"\" size=\"3\" placeholder = \"час\"/>\r\n");
      out.write("                    \r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-xs-2\">\r\n");
      out.write("                    <input class=\"form-control\" id = \"datepicker\" type=\"text\" name= \"date\"    value=\"\" size=\"20\" placeholder = \"дата матчу\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-xs-2\">\r\n");
      out.write("                    <input class=\"form-control\" type=\"text\" name= \"owner\"   value=\"Ураган\" size=\"20\" placeholder = \"господар\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("                    <div class=\"col-xs-2\">\r\n");
      out.write("                <input class=\"form-control\" type=\"text\" name= \"guest\"   value=\"\" size=\"20\" placeholder = \"гості\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-xs-2\">\r\n");
      out.write("                    <input class=\"form-control\" type=\"text\" name= \"place\"   value=\"Коледж фіичного виховання\" size=\"20\" placeholder = \"місце проведення\"/>                                            \r\n");
      out.write("                </div>\r\n");
      out.write("                <input id=\"insertGame\" type=\"hidden\" name=\"insertGame\" value=\"insertGame\" />\r\n");
      out.write("                <button class = \"btn btn-success\" type=\"submit\">зберегти</button>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("        <br>\r\n");
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
