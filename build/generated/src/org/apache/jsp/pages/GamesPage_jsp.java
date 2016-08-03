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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        \r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <script src= \"../js/manipulGame.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        \r\n");
      out.write("        <!-- Bootstrap -->\r\n");
      out.write("        <link href=\"../css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"../css/gamePage.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\">\r\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\r\n");
      out.write("        <script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\"></script>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css\">\r\n");
      out.write("        <script src=\"http://code.jquery.com/jquery-1.12.4.js\"></script>\r\n");
      out.write("        <script src=\"http://code.jquery.com/ui/1.12.0/jquery-ui.js\"></script> \r\n");
      out.write("        <script src=\"../js/datePicker.js\"></script>\r\n");
      out.write("        <title>Перегляд матчів</title>\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
      ua.ticket.web.controllers.GamesController gamesList = null;
      synchronized (_jspx_page_context) {
        gamesList = (ua.ticket.web.controllers.GamesController) _jspx_page_context.getAttribute("gamesList", PageContext.PAGE_SCOPE);
        if (gamesList == null){
          gamesList = new ua.ticket.web.controllers.GamesController();
          _jspx_page_context.setAttribute("gamesList", gamesList, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("        ");
      ua.ticket.web.controllers.GamesController gamesInfo = null;
      synchronized (_jspx_page_context) {
        gamesInfo = (ua.ticket.web.controllers.GamesController) _jspx_page_context.getAttribute("gamesInfo", PageContext.PAGE_SCOPE);
        if (gamesInfo == null){
          gamesInfo = new ua.ticket.web.controllers.GamesController();
          _jspx_page_context.setAttribute("gamesInfo", gamesInfo, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("        ");
      ua.ticket.web.beans.GameOfTeam gamesTeam = null;
      synchronized (_jspx_page_context) {
        gamesTeam = (ua.ticket.web.beans.GameOfTeam) _jspx_page_context.getAttribute("gamesTeam", PageContext.PAGE_SCOPE);
        if (gamesTeam == null){
          gamesTeam = new ua.ticket.web.beans.GameOfTeam();
          _jspx_page_context.setAttribute("gamesTeam", gamesTeam, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div class = \"form-group\">    \r\n");
      out.write("        <form  name=\"sortForm\" action=\"../GamesController\" method=\"POST\" >\r\n");
      out.write("         <div id = \"listMathes\" class=\"col-sm-2\">\r\n");
      out.write("            <select class=\"form-control\" name = \"sortGames\">\r\n");
      out.write("                <option class=\"special\" value = \"showAllGame\"> всі матчі</option>\r\n");
      out.write("                <option style=\"background: #5cb85c; color: #fff;\" value = \"showCurrentGame\"> поточний матч</option>\r\n");
      out.write("                <option value = \"showFutureGame\"> майбутні матчі</option>\r\n");
      out.write("            </select>\r\n");
      out.write("         </div>   \r\n");
      out.write("                <input id = \"button_ShowMathes\" class=\"btn btn-info\" type=\"submit\" value=\"показати матчі\">\r\n");
      out.write("        </form><br>\r\n");
      out.write("    </div>\r\n");
      out.write("        <button id =\"addG\" class=\"btn btn-warning\" type = \"button\" onclick = \"addGame();\">добавити матч</button> \r\n");
      out.write("          <input id=\"editGames\" type=\"hidden\" name=\"editGames\" value=\"editGames\" />\r\n");
      out.write("        <button id=\"editG\" class=\"btn btn-warning\" type = \"submit\" onclick = \"edit();\">редагувати матчі</button>  \r\n");
      out.write("          \r\n");
      out.write("        <form  action=\"../SubscriptionController\" method=\"POST\">\r\n");
      out.write("             <button id = 'button_AddGame' type=\"submit\" class=\"btn btn-primary\"> Добавити абоненмент </button> \r\n");
      out.write("        </form>\r\n");
      out.write("        \r\n");
      out.write("        <form  action=\"../SaleController\" method=\"POST\">\r\n");
      out.write("             <button id = 'button_SaleTickets' type=\"submit\" class=\"btn btn-primary\"> Замовити квиток </button> \r\n");
      out.write("        </form> \r\n");
      out.write("        <br><br>\r\n");
      out.write("        <div id = 'addGameJS'></div>\r\n");
      out.write("        \r\n");
      out.write("        <table id ='tableGame' class=\"table\">\r\n");
      out.write("            <thead>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <th id ='headTable' bgcolor=\"#BDBDBD\" style=\"width: 8%\">Час</th>\r\n");
      out.write("                    <th id ='headTable' bgcolor=\"#BDBDBD\" style=\"width: 10%\">Дата</th>\r\n");
      out.write("                    <th id ='headTable' bgcolor=\"#BDBDBD\" style=\"width: 25%\">Господарі</th>\r\n");
      out.write("                    <th id ='headTable' bgcolor=\"#BDBDBD\" style=\"width: 25%\">Гості</th>\r\n");
      out.write("                    <th id ='headTable' bgcolor=\"#BDBDBD\" style=\"width: 30%\">Місце проведення</th>\r\n");
      out.write("                    <th id ='headTable' bgcolor=\"#BDBDBD\" style=\"width: 0%\"></th>\r\n");
      out.write("                    <th id ='headTable' bgcolor=\"#BDBDBD\" style=\"width: 0%\"></th>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </thead>\r\n");
      out.write("            <tbody> \r\n");
      out.write("                <div id = \"form-game\">\r\n");
      out.write("                    \r\n");
      out.write("        ");

            for (GameOfTeam game : gamesList.getListGame()){
        
      out.write("\r\n");
      out.write("                <tr class=\"active\">\r\n");
      out.write("                <form id =\"form1\"  action=\"../GamesController\" method=\"POST\" >\r\n");
      out.write("                    \r\n");
      out.write("                        <input type=\"hidden\" name=\"id\" value=\"");
      out.print(game.getId());
      out.write("\" />     \r\n");
      out.write("                        <td id = 'columnTableGame'><input class=\"col-xs-12\" type=\"text\" name=\"time\" value=\"");
      out.print(game.getTimeGame() );
      out.write("\" size=\"3\" disabled/></td>\r\n");
      out.write("                        <td id = 'columnTableGame'><input id =\"datepicker\" class=\"col-xs-12\" type=\"text\" name=\"date\" value=\"");
      out.print(game.getDateGame());
      out.write("\" size=\"20\" disabled /></td>\r\n");
      out.write("                        <td id = 'columnTableGame'><input class=\"col-xs-12\" type=\"text\" name= \"owner\" value=\"");
      out.print(game.getNameTeam1());
      out.write("\" size=\"20\" disabled/></td>\r\n");
      out.write("                        <td id = 'columnTableGame'><input class=\"col-xs-12\" type=\"text\" name=\"guest\" value=\"");
      out.print(game.getNameTeam2() );
      out.write("\" size=\"20\" disabled /></td>\r\n");
      out.write("                        <td id = 'columnTableGame'><input class=\"col-xs-12\" type=\"text\" name=\"place\" value=\"");
      out.print(game.getPlaceGame());
      out.write("\" size=\"20\" disabled/></td>\r\n");
      out.write("                        <input id=\"updateGame\" type=\"hidden\" name=\"updateGame\" value=\"updateGame\" />\r\n");
      out.write("                        <td id = 'columnTableGame'><input id =\"s1\" class=\"btn btn-mini btn-warning\" type=\"button\"  onclick=\"sbmit(this.form)\" value = \"обновити\" style = \"display: none\"/></td>\r\n");
      out.write("                </form>\r\n");
      out.write("                <form id =\"form2\"  action=\"../GamesController\" method=\"POST\" >\r\n");
      out.write("                     <input type=\"hidden\" name=\"id\" value=\"");
      out.print(game.getId());
      out.write("\" />   \r\n");
      out.write("                     <input id=\"deleteGame\" type=\"hidden\" name=\"deleteGame\" value=\"deleteGame\"/>\r\n");
      out.write("                     <td id = 'columnTableGame'><input id =\"s2\" class=\"btn btn-mini btn-warning\" type=\"button\" onclick=\"sbmit(this.form)\" value = \"видалити\" style = \"display:none\"/></td>      \r\n");
      out.write("                </form>\r\n");
      out.write("                    </tr>        \r\n");
      out.write("            </div>        \r\n");
      out.write("        ");
}
      out.write("\r\n");
      out.write("            </tbody>\r\n");
      out.write("         </table> \r\n");
      out.write("    </body>\r\n");
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
