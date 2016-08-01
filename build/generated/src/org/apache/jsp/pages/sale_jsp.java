package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import ua.ticket.web.controllers.SaleController;
import ua.ticket.web.beans.Place;
import ua.ticket.web.controllers.GamesController;
import ua.ticket.web.beans.GameOfTeam;

public final class sale_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <title>Продаж квитків</title>\n");
      out.write("\n");
      out.write("        <!-- Bootstrap -->\n");
      out.write("        <link href=\"../css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"../css/sale.css\" rel=\"stylesheet\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n");
      out.write("        <script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->\n");
      out.write("        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n");
      out.write("        <!--[if lt IE 9]>\n");
      out.write("          <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\n");
      out.write("          <script src=\"https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js\"></script>\n");
      out.write("        <![endif]-->\n");
      out.write("      </head>\n");
      out.write("  \n");
      out.write("  \n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");
      ua.ticket.web.controllers.SaleController placeList = null;
      synchronized (_jspx_page_context) {
        placeList = (ua.ticket.web.controllers.SaleController) _jspx_page_context.getAttribute("placeList", PageContext.PAGE_SCOPE);
        if (placeList == null){
          placeList = new ua.ticket.web.controllers.SaleController();
          _jspx_page_context.setAttribute("placeList", placeList, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
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
      out.write("        \n");
      out.write("        <div class=\"header\"></div>    \n");
      out.write("\n");
      out.write("        <div class=\"content\">\n");
      out.write("                \n");
      out.write("            <div class=\"list_matches\">\n");
      out.write("                <form class=\"form-inline\" role=\"form\" action=\"../SaleController\" method=\"POST\">\n");
      out.write("                    <select class=\"form-control matches\" name = \"selectGame\">\n");
      out.write("                        ");

                            for (GameOfTeam game : gamesList.showFutureGame()){
                        
      out.write("\n");
      out.write("\n");
      out.write("                        <option id=\"teams\" value = ");
      out.print(game.getId());
      out.write(' ');
      out.write('>');
      out.print(game.getNameTeam1());
      out.write(" - ");
      out.print(game.getNameTeam2());
      out.write("</option>\n");
      out.write("\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                    </select>\n");
      out.write("                    \n");
      out.write("                    <button type=\"submit\" value=\"update\" class=\"btn btn-default btn_show\">Показати список квитків по даному матчі</button>\n");
      out.write("                </div>\n");
      out.write("                    \n");
      out.write("                </form>\n");
      out.write("  \n");
      out.write("                    <form  action=\"../GamesController\" method=\"POST\">\n");
      out.write("                        <p id = 'button_InfoGame'> <button type=\"submit\" class=\"btn btn-primary\"> Інформація про ігри </button>\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                    <form  action=\"../SubscriptionController\" method=\"POST\">\n");
      out.write("                        <p id = 'button_AddGame'> <button type=\"submit\" class=\"btn btn-primary\"> Добавити абоненмент </button> \n");
      out.write("                    </form>\n");
      out.write("            \n");
      out.write("                        \n");
      out.write("\n");
      out.write("            <div class=\"sectors_up\">\n");
      out.write("                \n");
      out.write("                <div class=\"row sector_f\">\n");
      out.write("                    <center>\n");
      out.write("                    <h3 id = 'nameTeams'>");
      out.print(placeList.getNameTeams());
      out.write("</h3>\n");
      out.write("                    </center>\n");
      out.write("                    <table class = \"table table-bordered\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th id ='headTableSale' bgcolor=\"#BDBDBD\" style=\"width: 10%\">Сектор</th>\n");
      out.write("                                <th id ='headTableSale' bgcolor=\"#BDBDBD\" style=\"width: 10%\">Ряд</th>\n");
      out.write("                                <th id ='headTableSale' bgcolor=\"#BDBDBD\" style=\"width: 80%\">Місце</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                    ");
      
                          Iterator iterSector = placeList.getListSector().iterator();
                          while (iterSector.hasNext()){
                              int idSector = (Integer) iterSector.next();
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td bgcolor=\"#01A9DB\" rowspan=\" ");
      out.print(placeList.getListRows(idSector).size());
      out.write('"');
      out.write('>');
      out.print(placeList.getNameSector(idSector));
      out.write("</td>\n");
      out.write("                        \n");
      out.write("                    ");
 
                        Iterator<Integer> iterRows = placeList.getListRows(idSector).iterator();
                        while (iterRows.hasNext()){
                           int idRows = iterRows.next();
                            placeList.setIdRow(idRows);
                        
                    
      out.write("\n");
      out.write("                    <td bgcolor=\"#FE642E\">");
      out.print(idRows);
      out.write("</td>\n");
      out.write("                    <td bgcolor=\"#61210B\">\n");
      out.write("                    ");

                        for(Place place : placeList.getAllPlace()){
                            
                            if (idSector == place.getIdSector() && idRows == place.getRow()){
                                int status = place.getStatus();
                                String colorButton = "btn btn-danger";
                                switch(status){
                                    case 0: colorButton = "btn btn-success";
                                        break;
                                    case 1: colorButton = "btn btn-warning";
                                        break;
                                    case 2: colorButton = "btn btn-info";
                                        break;
                                }
                    
      out.write("\n");
      out.write("                    <button data-toggle=\"modal\" data-target=\"#");
      out.print(place.getId());
      out.write("\" id=\"btn_update\" value=\"update\" type=\"submit\" class=\"");
      out.print(colorButton);
      out.write('"');
      out.write('>');
      out.print(place.getNumber());
      out.write("</button>\n");
      out.write(" \n");
      out.write("                    <div id=\"");
      out.print(place.getId());
      out.write("\" class=\"modal fade\" role=\"dialog\">\n");
      out.write("                        <div class=\"modal-dialog\">\n");
      out.write("                            <div class=\"modal-content\">\n");
      out.write("                                <div class=\"modal-header\">\n");
      out.write("                                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                                    <h4 class=\"modal-title\">Інформація про квиток</h4>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"modal-body\">\n");
      out.write("                                    <form action=\"../SaleController\" method=\"POST\">\n");
      out.write("                                        <div class=\"form-group form-group_on_sale\">\n");
      out.write("                                       <!-- <label for=\"id\">id</label> \n");
      out.write("                                            <input placeholder=\"id\" class=\"form-control\" id=\"id\" type=\"text\" name=\"id\" value=\"");
      out.print(place.getId());
      out.write("\"/> \n");
      out.write("                                            <label for=\"row\">row</label>\n");
      out.write("                                            <input placeholder=\"Ряд\" class=\"form-control\" id=\"row\" type=\"text\" name=\"row\" value=\"");
      out.print(place.getRow());
      out.write("\"/> \n");
      out.write("                                            <label for=\"number\">number</label>\n");
      out.write("                                            <input placeholder=\"Місце\" class=\"form-control\" id=\"number\" type=\"text\" name=\"number\" value=\"");
      out.print(place.getNumber());
      out.write("\"/> \n");
      out.write("                                            <label for=\"id_sector\">id_sector</label>\n");
      out.write("                                            <input placeholder=\"Сектор\" class=\"form-control\" id=\"id_sector\" type=\"text\" name=\"id_sector\" value=\"");
      out.print(place.getIdSector());
      out.write("\"/> \n");
      out.write("                                       -->\n");
      out.write("                                            <input placeholder=\"id\" class=\"form-control\" id=\"id\" type=\"hidden\" name=\"id\" value=\"");
      out.print(place.getId());
      out.write("\"/>      \n");
      out.write("                                            <label for=\"status\">Статус</label>\n");
      out.write("                                            <input placeholder=\"Вільно/зайнято\" class=\"form-control\" id=\"status\" type=\"text\" name=\"status\" value=\"");
      out.print(place.getStatus());
      out.write("\"/> \n");
      out.write("                                            <label for=\"PIP\">П.І.Б.</label>\n");
      out.write("                                            <input placeholder=\"ПІП\" class=\"form-control\" id=\"PIP\" type=\"text\" name=\"PIP\" value=\"");
      out.print(place.getPIP());
      out.write("\"/> \n");
      out.write("                                        </div>\n");
      out.write("                                            <input id=\"orderPlace\" type=\"hidden\" name=\"orderPlace\" value=\"orderPlace\" />\n");
      out.write("                                            <button id=\"btn_update\" value=\"update\" type=\"submit\" class=\"btn btn-warning\">Зберегти</button>\n");
      out.write("                                    </form>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"modal-footer\">\n");
      out.write("                                    <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Вийти</button>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                     \n");
      out.write("                    ");
}else continue;
      out.write("\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                    \n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                        \n");
      out.write("                    </tbody>\n");
      out.write("                </table>                 \n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <div class=\"row sectors_c_d_e\">\n");
      out.write("                    <div class=\"col-lg-3 sector_c\">\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <div class=\"col-lg-6 sector_d\">\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <div class=\"col-lg-3 sector_e\">\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div class=\"footer\"></div>\n");
      out.write("      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\n");
      out.write("      <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js\"></script>\n");
      out.write("      <!-- Include all compiled plugins (below), or include individual files as needed -->\n");
      out.write("      <script src=\"../js/bootstrap.min.js\"></script>\n");
      out.write("    </body>\n");
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
