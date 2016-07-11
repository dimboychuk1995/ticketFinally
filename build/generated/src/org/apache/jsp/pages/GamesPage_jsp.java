package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import ua.ticket.web.controllers.GamesController;
import ua.ticket.web.beans.GameOfTeam;

public final class GamesPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <style>\n");
      out.write("            body    {\n");
      out.write("                    background: #FDF5E6;\n");
      out.write("                    }\n");
      out.write("                    \n");
      out.write("            #liniya { \n");
      out.write("                    \n");
      out.write("                    float: left;\n");
      out.write("                    height:10px; \n");
      out.write("                    margin-left: 210px; \n");
      out.write("                    margin-top: 4px;\n");
      out.write("                    }\n");
      out.write("            input   { \n");
      out.write("                \n");
      out.write("                    background: #F8F8FF;  \n");
      out.write("                    }\n");
      out.write("    \n");
      out.write("      \n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        ");
      ua.ticket.web.controllers.GamesController gamesList = null;
      synchronized (_jspx_page_context) {
        gamesList = (ua.ticket.web.controllers.GamesController) _jspx_page_context.getAttribute("gamesList", PageContext.PAGE_SCOPE);
        if (gamesList == null){
          gamesList = new ua.ticket.web.controllers.GamesController();
          _jspx_page_context.setAttribute("gamesList", gamesList, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("        ");
      ua.ticket.web.controllers.GamesController gamesInfo = null;
      synchronized (_jspx_page_context) {
        gamesInfo = (ua.ticket.web.controllers.GamesController) _jspx_page_context.getAttribute("gamesInfo", PageContext.PAGE_SCOPE);
        if (gamesInfo == null){
          gamesInfo = new ua.ticket.web.controllers.GamesController();
          _jspx_page_context.setAttribute("gamesInfo", gamesInfo, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("        ");
      ua.ticket.web.beans.GameOfTeam gamesTeam = null;
      synchronized (_jspx_page_context) {
        gamesTeam = (ua.ticket.web.beans.GameOfTeam) _jspx_page_context.getAttribute("gamesTeam", PageContext.PAGE_SCOPE);
        if (gamesTeam == null){
          gamesTeam = new ua.ticket.web.beans.GameOfTeam();
          _jspx_page_context.setAttribute("gamesTeam", gamesTeam, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("        <h2 align =\"center\">Розклад матчів НФК Урагану</h2>\n");
      out.write("        \n");
      out.write("        <form  action=\"../GamesController\" method=\"POST\" >\n");
      out.write("            <select name = \"sortGames\">\n");
      out.write("                <option value = \"showAllGame\"> всі матчі</option>\n");
      out.write("                <option value = \"showCurrentGame\"> поточний матч</option>\n");
      out.write("                <option value = \"showFutureGame\"> майбутні матчі</option>\n");
      out.write("            </select>\n");
      out.write("            <p><input type=\"submit\" value=\"показати матчі\"></p>\n");
      out.write("            </form>\n");
      out.write("        <!--\n");
      out.write("        <div id = \"liniya\">\n");
      out.write("            <form  action=\"../GamesController\" method=\"POST\" >\n");
      out.write("                <p><input id=\"allGame\" type=\"hidden\" name=\"allGame\" value=\"showAllGame\" /></p>      \n");
      out.write("                <p><button id=\"btn1\" type=\"submit\" class=\"btn btn-default\">всі матчі</button></p>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <div id = \"liniya\">\n");
      out.write("            <form  action=\"../GamesController\" method=\"POST\" >\n");
      out.write("                <p><input id=\"currentGame\" type=\"hidden\" name=\"currentGame\" value=\"showCurrentGame\" /></p>\n");
      out.write("                <p><button id=\"btn2\" type=\"submit\">сьогоднішній матч</button></p>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <div id = \"liniya\">\n");
      out.write("            <form  action=\"../GamesController\" method=\"POST\" >\n");
      out.write("                <p><input id=\"futureGame\" type=\"hidden\" name=\"futureGame\" value=\"showFutureGame\" />\n");
      out.write("                <button id=\"btn2\" type=\"submit\">майбутні матчі</button></p>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        -->\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("         \n");
      out.write("        <CENTER>\n");
      out.write("        <div>\n");
      out.write("        ");

            for (GameOfTeam game : gamesList.futureGame()){
        
      out.write("\n");
      out.write("                 <div class=\"form-game\"> \n");
      out.write("                    <input id=\"timeGame1\" type=\"text\" name=\" time \" value=\"");
      out.print(game.getTimeGame() );
      out.write("\" size=\"20\" readonly/>\n");
      out.write("                    <input id=\"timeGame\" type=\"text\" name=\" date \" value=\"");
      out.print(game.getDateGame());
      out.write("\" size=\"20\" readonly />\n");
      out.write("                    <input id=\"team1\" type=\"text\" name= \" owner \" value=\"");
      out.print(game.getNameTeam1());
      out.write("\" size=\"20\" readonly/>\n");
      out.write("                    <input id=\"team2\" type=\"text\" name=\" guest \" value=\"");
      out.print(game.getNameTeam2() );
      out.write("\" size=\"20\" readonly />\n");
      out.write("                    <input id=\"place\" type=\"text\" name=\" place \" value=\"");
      out.print(game.getPlaceGame());
      out.write("\" size=\"20\" readonly/>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("        ");
}
      out.write("\n");
      out.write("       </div>\n");
      out.write("    </CENTER>    \n");
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
