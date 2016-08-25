<%-- 
    Document   : GamesPage
    Created on : 7 лип. 2016, 9:33:00
    Author     : us9546
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.LinkedHashSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ua.ticket.web.controllers.GamesController"%>
<%@page import="ua.ticket.web.beans.GameOfTeam"%>
<%@page contentType="text/html" pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src= "../js/manipulGame.js" type="text/javascript"></script>
        
        <!-- Bootstrap -->
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/gamePage.css" rel="stylesheet">
        <script src="../js/jquery.min.js"></script> 
        <script src="../js/datePicker.js"></script>
        <title>Перегляд матчів</title>

    </head>

    <body>
        <jsp:useBean id="gamesList" class="ua.ticket.web.controllers.GamesController"/>
        <jsp:useBean id="gamesInfo" class="ua.ticket.web.controllers.GamesController"/>
        <jsp:useBean id="gamesTeam" class="ua.ticket.web.beans.GameOfTeam"/>
        <jsp:useBean id="reportGame" class="ua.ticket.web.controllers.ReportController"/>

    <div class = "form-group">    
        <form  name="sortForm" action="../GamesController" method="POST" >
         <div id = "listMathes" class="col-sm-2">
            <select class="form-control" name = "sortGames">
                <option class="special" value = "showAllGame"> всі матчі</option>
                <option style="background: #5cb85c; color: #fff;" value = "showCurrentGame"> поточний матч</option>
                <option value = "showFutureGame"> майбутні матчі</option>
            </select>
         </div>   
                <input id = "button_ShowMathes" class="btn btn-info" type="submit" value="показати матчі">
        </form><br>
    </div>
        <button id ="addG" class="btn btn-warning" type = "button" onclick = "addGame();">добавити матч</button> 
          <input id="editGames" type="hidden" name="editGames" value="editGames" />
        <button id="editG" class="btn btn-warning" type = "submit" onclick = "edit();">редагувати матчі</button>  
          
        <form  action="../SubscriptionController" method="POST">
             <button id = 'button_AddGame' type="submit" class="btn btn-primary"> Добавити абоненмент </button> 
        </form>
        
        <form  action="../SaleController" method="POST">
             <button id = 'button_SaleTickets' type="submit" class="btn btn-primary"> Замовити квиток </button> 
        </form> 
        
        <form  action="../SectorController" method="POST">
             <button id = 'button_Sectors' type="submit" class="btn btn-primary btn_sectors"> Довідник секторів </button> 
        </form>
        
        <br><br>
        <div id = 'addGameJS'></div>
        
        <table id ='tableGame' class="table">
            <thead>
                <tr>
                    <th id ='headTable' bgcolor="#BDBDBD" style="width: 8%">Час</th>
                    <th id ='headTable' bgcolor="#BDBDBD" style="width: 10%">Дата</th>
                    <th id ='headTable' bgcolor="#BDBDBD" style="width: 25%">Господарі</th>
                    <th id ='headTable' bgcolor="#BDBDBD" style="width: 25%">Гості</th>
                    <th id ='headTable' bgcolor="#BDBDBD" style="width: 30%">Місце проведення</th>
                    <th id ='headTable' bgcolor="#BDBDBD" style="width: 0%"></th>
                    <th id ='headTable' bgcolor="#BDBDBD" style="width: 0%"></th>
                    <th id ='headTable' bgcolor="#BDBDBD" style="width: 0%"></th>
                </tr>
            </thead>
            <tbody> 
                <div id = "form-game">
                    
        <%
            for (GameOfTeam game : gamesList.getListGame()){
        %>
                <tr class="active">
                <form id ="form1"  action="../GamesController" method="POST" >
                    
                <input type="hidden" name="id" value="<%=game.getId()%>" />     
                <td id = 'columnTableGame'><input class="col-xs-12" type="text" name="time" value="<%=game.getTimeGame() %>" size="3" disabled/></td>
                <td id = 'columnTableGame'><input id ="datepicker" class="col-xs-12" type="text" name="date" value="<%=game.getDateGame()%>" size="20" disabled /></td>
                <td id = 'columnTableGame'><input class="col-xs-12" type="text" name= "owner" value="<%=game.getNameTeam1()%>" size="20" disabled/></td>
                <td id = 'columnTableGame'><input class="col-xs-12" type="text" name="guest" value="<%=game.getNameTeam2() %>" size="20" disabled /></td>
                <td id = 'columnTableGame'><input class="col-xs-12" type="text" name="place" value="<%=game.getPlaceGame()%>" size="20" disabled/></td>


                <td id = 'columnTableGame'><button class="btn btn-info btn-xs btn_zv" type="button" data-toggle="modal" data-target="#<%=game.getId()%>">ЗВІТ</button></td>
                    <div id="<%=game.getId()%>" class="modal fade">
                        <div class="modal-dialog">
                        <div class="modal-content">
                        <div class="modal-header"><button class="close" type="button" data-dismiss="modal">×</button>
                            <p id = "nameTeamIn"><%=game.getNameTeam1()%> - <%=game.getNameTeam2() %></p>
                        <h4 class="modal-title">Дата гри: <%=game.getDateGame()%></h4>
                        </div>
                        <div>
                                <%
                                    Iterator<Integer> iterSector = reportGame.getSectorsForReport(game.getId()).iterator();
                                    int idSector = 0;
                                    int allSumm = 0;
                                    while(iterSector.hasNext()){
                                        idSector = (Integer)iterSector.next();
                                %>
                                
                                <% 
                                    reportGame.getSizePlaceForReport(idSector, game.getId());
                                %>
                                <% 
                                    int countPlace  = reportGame.arrPlace.size();
                                    int priceSector = reportGame.getPriceSectorForReport(idSector);
                                    int sum = countPlace*priceSector;
                                    allSumm = allSumm + sum;
                                %>
                                
                            <div class="alert alert-info">
                                <div class="modal-body">Назва сектора: <%=reportGame.getNameSectorForReport(idSector)%></div>
                                <div class="modal-body">Продано квитків:   <%=countPlace %></div>
                                <div class="modal-body">Ціна квитка в секторі: <%=priceSector %> грн.</div>
                                <div class="modal-body">Сума: <%=sum %> грн.</div>
                                <br>
                            </div>
                                <%}%>
                                <br>
                                
                                <div class="modal-body alert alert-success">Загальна сума: <%=allSumm%> грн.</div>
                                

                            <div class="modal-footer"><button class="btn btn-default" type="button" data-dismiss="modal">Закрыть</button></div>
                        </div>
                        </div>
                        </div>
                    </div> 
                        
                        <input id="updateGame" type="hidden" name="updateGame" value="updateGame" />
                        <td id = 'columnTableGame'><input id ="s1" class="btn btn-mini btn-warning" type="button"  onclick="sbmit(this.form)" value = "обновити" style = "display: none"/></td>
                </form>
                <form id ="form2"  action="../GamesController" method="POST" >
                     <input type="hidden" name="id" value="<%=game.getId()%>" />   
                     <input id="deleteGame" type="hidden" name="deleteGame" value="deleteGame"/>
                     <td id = 'columnTableGame'><input id ="s2" class="btn btn-mini btn-warning" type="button" onclick="sbmit(this.form)" value = "видалити" style = "display:none"/></td>      
                </form>
               </tr>        
            </div>        
        <%}%>
            </tbody>
         </table> 
    </body>
</html>