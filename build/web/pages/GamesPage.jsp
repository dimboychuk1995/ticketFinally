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
        <title>Перегляд матчів</title>
        <style>
            body    {
                    background: #FDF5E6;
                    }
                    
            #liniya { 
                    
                    float: left;
                    height:10px; 
                    margin-left: 210px; 
                    margin-top: 4px;
                    }
    
      
        </style>
    </head>

    <body>
        <jsp:useBean id="gamesList" class="ua.ticket.web.controllers.GamesController"/>
        <jsp:useBean id="gamesInfo" class="ua.ticket.web.controllers.GamesController"/>
        <jsp:useBean id="gamesTeam" class="ua.ticket.web.beans.GameOfTeam"/>

        <h2 align ="center">Розклад матчів НФК Урагану</h2>
        
        <form  name="sortForm" action="../GamesController" method="POST" >
            <select name = "sortGames">
                <option value = "showAllGame"> всі матчі</option>
                <option value = "showCurrentGame"> поточний матч</option>
                <option value = "showFutureGame"> майбутні матчі</option>
            </select>
            <input type="submit" value="показати матчі">
            <input type="button" id="more_games" onclick = "add_games();" value="добавити матч" />
          </form>
           
            <input id="editGames" type="hidden" name="editGames" value="editGames" />
            <button id="editG" type = "submit" onclick = "edit();">редагувати матчі</button>  
          
        
        <br>
        <CENTER>
        <div>
        <%
            for (GameOfTeam game : gamesList.futureGame()){
        %>
            <div id = "form-game">
                <form id ="form1"  action="../GamesController" method="POST" >
                        <input type="hidden" name="id" value="<%=game.getId()%>" />
                        <input class="inputs" type="text" name="time" value="<%=game.getTimeGame() %>" size="3" disabled/>
                        <input id="datepicker" class="inputs" type="text" name="date" value="<%=game.getDateGame()%>" size="20" disabled />
                        <input class="inputs" type="text" name= "owner" value="<%=game.getNameTeam1()%>" size="20" disabled/>
                        <input class="inputs" type="text" name="guest" value="<%=game.getNameTeam2() %>" size="20" disabled />
                        <input class="inputs" type="text" name="place" value="<%=game.getPlaceGame()%>" size="20" disabled/>
                 <br>
                        <input id="updateGame" type="hidden" name="updateGame" value="updateGame" />
                        <input id ="s1" class="buttonEdit" type="button"  onclick="sbmit(this.form)" value = "обновити" style = "display: none"/>  
                </form>
                <br>        
                <form id ="form2"  action="../GamesController" method="POST" >
                     <input type="hidden" name="id" value="<%=game.getId()%>" />   
                     <input id="deleteGame" type="hidden" name="deleteGame" value="deleteGame"/>
                     <input id ="s2" class="buttonEdit" type="button" onclick="sbmit(this.form)" value = "видалити" style = "display:none"/>       
                </form>
                
            <br>              
        <%}%>
        </div>
    </CENTER>    
    </body>
</html>