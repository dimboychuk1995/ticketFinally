<%-- 
    Document   : GamesPage
    Created on : 7 лип. 2016, 9:33:00
    Author     : us9546
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ua.ticket.web.controllers.GamesController"%>
<%@page import="ua.ticket.web.beans.GameOfTeam"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src= "../js/manipulGame.js" type="text/javascript"></script>
        <!-- Bootstrap -->
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/game.css" rel="stylesheet">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        
        <title>Перегляд матчів</title>
    </head>

    <body>
        <jsp:useBean id="gamesList" class="ua.ticket.web.controllers.GamesController"/>
        <jsp:useBean id="gamesInfo" class="ua.ticket.web.controllers.GamesController"/>
        <jsp:useBean id="gamesTeam" class="ua.ticket.web.beans.GameOfTeam"/>

    <center>
        <div class = "page-header">
        <h2 id ="headName">Розклад матчів НФК Урагану</h2>
        </div>
    </center>
    <div class = "form-group">    
        <form  name="sortForm" action="../GamesController" method="POST" >
         <div class="col-sm-2">
            <select class="form-control" name = "sortGames">
                <option class="special" value = "showAllGame"> всі матчі</option>
                <option style="background: #5cb85c; color: #fff;" value = "showCurrentGame"> поточний матч</option>
                <option value = "showFutureGame"> майбутні матчі</option>
            </select>
         </div>   
                <input class="btn btn-info" type="submit" value="показати матчі">
        </form><br>
    </div>
          <input class="btn btn-warning" type="button" id="more_games" onclick = "add_games();" value="добавити матч" />
          <input id="editGames" type="hidden" name="editGames" value="editGames" />
          <button id="editG" class="btn btn-warning" type = "submit" onclick = "edit();">редагувати матчі</button>  
          <br><br>
        <%
            for (GameOfTeam game : gamesList.futureGame()){
        %>
        <table class="table-bordered">
        
            <div id = "form-game">
                <form id ="form1"  action="../GamesController" method="POST" >
                    
                        <input type="hidden" name="id" value="<%=game.getId()%>" />     
                  <tbody>    
                    <tr class="active">
                        <td><input class="col-xs-12" type="text" name="time" value="<%=game.getTimeGame() %>" size="3" disabled/></td>
                        <td><input class="col-xs-12" type="text" name="date" value="<%=game.getDateGame()%>" size="20" disabled /></td>
                        <td><input class="col-xs-12" type="text" name= "owner" value="<%=game.getNameTeam1()%>" size="20" disabled/></td>
                        <td><input class="col-xs-12" type="text" name="guest" value="<%=game.getNameTeam2() %>" size="20" disabled /></td>
                        <td><input class="col-xs-12" type="text" name="place" value="<%=game.getPlaceGame()%>" size="20" disabled/></td>
                        <input id="updateGame" type="hidden" name="updateGame" value="updateGame" />
                        <td><input id ="s1" class="btn btn-mini btn-warning" type="button"  onclick="sbmit(this.form)" value = "обновити" style = "display: none"/></td>
                </form>
                <form id ="form2"  action="../GamesController" method="POST" >
                     <input type="hidden" name="id" value="<%=game.getId()%>" />   
                     <input id="deleteGame" type="hidden" name="deleteGame" value="deleteGame"/>
                     <td><input id ="s2" class="btn btn-mini btn-warning" type="button" onclick="sbmit(this.form)" value = "видалити" style = "display:none"/></td>      
                </form>
                    </tr>
                </tbody>    
            </div>        
        </table>    
        <%}%> 
    </body>
</html>