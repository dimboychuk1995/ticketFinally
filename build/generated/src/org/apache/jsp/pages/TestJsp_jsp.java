package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class TestJsp_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("         <script src=\"http://code.jquery.com/jquery-1.9.1.js\"></script>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        \n");
      out.write("                \n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <div>\n");
      out.write("            <input id = numb1 name =\"n1\" type=\"text\" value = \"\"/>\n");
      out.write("            <input id = numb2 name =\"n2\" type=\"text\" value = \"\" onclick=\"dateOut();\"/>\n");
      out.write("        </div>\n");
      out.write("        <input id ='summ' name =\"s1\"  type=\"text\" value=\"нажми мене\" />\n");
      out.write("        \n");
      out.write("        <script>\n");
      out.write("            function dateOut(){\n");
      out.write("                \n");
      out.write("                var string1 = \"01.05.2015\";\n");
      out.write("                var string2 = \"01.07.2016\";\n");
      out.write("                var date =  new Date(\"01.05.2016\");\n");
      out.write("                var date1 = new Date();\n");
      out.write("                \n");
      out.write("                if (date <= date1){\n");
      out.write("                    \n");
      out.write("                    alert(1);\n");
      out.write("                }else{\n");
      out.write("                    alert(date);\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <script>\n");
      out.write("            $(\"input[name = 's1']\").click(function () {\n");
      out.write("            var numb1 = $(\"input[name = 'n1']\").val();\n");
      out.write("            var numb2 = $(\"input[name = 'n2']\").val();\n");
      out.write("            var summ = numb1*numb2/1.2;\n");
      out.write("            $(\"input[name = 's1']\").val(summ);\n");
      out.write("            });\n");
      out.write("            \n");
      out.write("         </script>   \n");
      out.write("\n");
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
