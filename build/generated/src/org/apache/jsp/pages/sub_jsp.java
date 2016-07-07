package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
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

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("        <link href=\"../css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"../css/sub.css\" rel=\"stylesheet\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        \r\n");
      out.write("        ");
      ua.ticket.web.controllers.SubscriptionController subscriptionList = null;
      synchronized (_jspx_page_context) {
        subscriptionList = (ua.ticket.web.controllers.SubscriptionController) _jspx_page_context.getAttribute("subscriptionList", PageContext.PAGE_SCOPE);
        if (subscriptionList == null){
          subscriptionList = new ua.ticket.web.controllers.SubscriptionController();
          _jspx_page_context.setAttribute("subscriptionList", subscriptionList, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("        ");
      ua.ticket.web.controllers.SubscriptionController updateSubscription = null;
      synchronized (_jspx_page_context) {
        updateSubscription = (ua.ticket.web.controllers.SubscriptionController) _jspx_page_context.getAttribute("updateSubscription", PageContext.PAGE_SCOPE);
        if (updateSubscription == null){
          updateSubscription = new ua.ticket.web.controllers.SubscriptionController();
          _jspx_page_context.setAttribute("updateSubscription", updateSubscription, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("        <div class=\"header\">\r\n");
      out.write("            \r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"content\">\r\n");
      out.write("            \r\n");
      out.write("        ");

            for (Subscription subscription : subscriptionList.getSubscriptionAll()) {
        
      out.write("\r\n");
      out.write("          <form role=\"form\" action=\"../SubscriptionController\" method=\"POST\">\r\n");
      out.write("\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("\r\n");
      out.write("                    <input id=\"id\" type=\"text\" name=\"id\" value=\"");
      out.print(subscription.getId());
      out.write("\" size=\"20\" />\r\n");
      out.write("                    <input id=\"PIP\" type=\"text\" name=\"PIP\" value=\"");
      out.print(subscription.getPIP());
      out.write("\" size=\"20\" />\r\n");
      out.write("                    <input id=\"season\" type=\"text\" name=\"season\" value=\"");
      out.print(subscription.getSeason());
      out.write("\" size=\"20\" />\r\n");
      out.write("                    <input id=\"placeId\" type=\"text\" name=\"placeId\" value=\"");
      out.print(subscription.getPlaceId());
      out.write("\" size=\"20\" />\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("        \r\n");
      out.write("                <button id=\"btn1\" type=\"submit\" class=\"btn btn-default\">Оновити</button>\r\n");
      out.write("                \r\n");
      out.write("            </form>\r\n");
      out.write("                    \r\n");
      out.write("        ");
}
      out.write("\r\n");
      out.write("                    \r\n");
      out.write("        </div>\r\n");
      out.write("            <div>\r\n");
      out.write("                <form  action=\"../GamesController\" method=\"POST\">\r\n");
      out.write("                    <button type=\"submit\"> Показати матчі </button>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"footer\"></div>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js\"></script>\r\n");
      out.write("    \r\n");
      out.write("        <script src=\"../js/bootstrap.min.js\"></script>\r\n");
      out.write("        \r\n");
      out.write("<!--        <script lang=\"javascript\">\r\n");
      out.write("            $(function(){\r\n");
      out.write("                $(\"#btn1\").click(function(){\r\n");
      out.write("                   $.ajax({\r\n");
      out.write("                    type: \"GET\",\r\n");
      out.write("                    url: \"SubscriptionController?id=1\"\r\n");
      out.write("                }); \r\n");
      out.write("                });\r\n");
      out.write("            });\r\n");
      out.write("        </script>-->\r\n");
      out.write("        \r\n");
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
