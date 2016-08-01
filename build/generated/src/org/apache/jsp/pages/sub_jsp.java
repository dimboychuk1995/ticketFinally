package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ua.ticket.web.controllers.SubscriptionController;
import ua.ticket.web.beans.Subscription;

public final class sub_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Абонементи</title>\n");
      out.write("        <link href=\"../css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"../css/sub.css\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");
      ua.ticket.web.controllers.SubscriptionController subscriptionList = null;
      synchronized (_jspx_page_context) {
        subscriptionList = (ua.ticket.web.controllers.SubscriptionController) _jspx_page_context.getAttribute("subscriptionList", PageContext.PAGE_SCOPE);
        if (subscriptionList == null){
          subscriptionList = new ua.ticket.web.controllers.SubscriptionController();
          _jspx_page_context.setAttribute("subscriptionList", subscriptionList, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"header\">\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"content\">\n");
      out.write("            \n");
      out.write("\n");
      out.write("            <div class=\"forms\">\n");
      out.write("                ");

                    for (Subscription subscription : subscriptionList.getSubscriptionAll()) {
                
      out.write("\n");
      out.write("                    <form  action=\"../SubscriptionController\" method=\"POST\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <input id=\"id\" type=\"text\" name=\"id\" value=\"");
      out.print(subscription.getId());
      out.write("\" size=\"20\" />\n");
      out.write("                            <input id=\"PIP\" type=\"text\" name=\"PIP\" value=\"");
      out.print(subscription.getPIP());
      out.write("\" size=\"20\" />\n");
      out.write("                            <input id=\"season\" type=\"text\" name=\"season\" value=\"");
      out.print(subscription.getSeason());
      out.write("\" size=\"20\" />\n");
      out.write("                            <input id=\"sector\" type=\"text\" name=\"sector\" value=\"");
      out.print(subscription.getSector());
      out.write("\" size=\"20\" />\n");
      out.write("                            <input id=\"row\" type=\"text\" name=\"row\" value=\"");
      out.print(subscription.getRow());
      out.write("\" size=\"20\" />\n");
      out.write("                            <input id=\"number\" type=\"text\" name=\"number\" value=\"");
      out.print(subscription.getNumber());
      out.write("\" size=\"20\" />\n");
      out.write("                        </div>\n");
      out.write("                        <button id=\"btn_update\" value=\"update\" type=\"submit\" class=\"btn btn-warning\">Оновити</button>  \n");
      out.write("                    </form>\n");
      out.write("                \n");
      out.write("                    <form  action=\"../SubscriptionController\" method=\"POST\">\n");
      out.write("                        <input class=\"delete_sub\" id=\"id\" type=\"text\" name=\"id\" value=\"");
      out.print(subscription.getId());
      out.write("\" size=\"20\" />\n");
      out.write("                        <button id=\"btn_delete\" value=\"delete\" type=\"submit\" class=\"btn btn-danger\">Видалити</button>  \n");
      out.write("                    </form>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </div> \n");
      out.write("            \n");
      out.write("            <div class=\"add_sub\">\n");
      out.write("                <form action=\"../SubscriptionController\" method=\"POST\">\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <input class=\"form-control\" type=\"text\" id=\"PIP\" name=\"PIP\" value=\"\" placeholder=\"ПІП\"/> \n");
      out.write("                        <select class=\"form-control\" name=\"season\">\n");
      out.write("                            <option id=\"season\">2015-2016</option>\n");
      out.write("                            <option id=\"season\">2016-2017</option>\n");
      out.write("                            <option id=\"season\">2017-2018</option>\n");
      out.write("                            <option id=\"season\">2018-2019</option>\n");
      out.write("                        </select>  \n");
      out.write("                        <input class=\"form-control\" type=\"text\" id=\"sector\" name=\"sector\" value=\"\" placeholder=\"sector\" />\n");
      out.write("                        <input class=\"form-control\" type=\"text\" id=\"row\" name=\"row\" value=\"\" placeholder=\"row\" />\n");
      out.write("                        <input class=\"form-control\" type=\"text\" id=\"number\" name=\"number\" value=\"\" placeholder=\"number\" />\n");
      out.write("                    </div>\n");
      out.write("                    <button id=\"btn_add\" value=\"delete\" type=\"submit\" class=\"btn btn-success\">Додати</button>  \n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("            <div>\n");
      out.write("                <form  action=\"../GamesController\" method=\"POST\">\n");
      out.write("                    <button type=\"submit\"> Показати матчі </button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        \n");
      out.write("        <div class=\"footer\"></div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js\"></script>\n");
      out.write("    \n");
      out.write("        <script src=\"../js/bootstrap.min.js\"></script>\n");
      out.write("       \n");
      out.write("        \n");
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
