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
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="gamesList" class="ua.ticket.web.controllers.GamesController"/>
        <jsp:useBean id="gamesInfo" class="ua.ticket.web.controllers.GamesController"/>
        <jsp:useBean id="gamesTeam" class="ua.ticket.web.beans.GameOfTeam"/>
        
    <CENTER>
        <h3>Розклад матчів НФК Урагану</h3>
        
        <%
            for (GameOfTeam game : gamesList.futureGame()){
        %>
            

                <div class="form-game"> 
                    <input id="timeGame1" type="text" name=" time " value="<%=game.getTimeGame() %>" size="20" />
                    <input id="timeGame" type="text" name=" date " value="<%=game.getDateGame()%>" size="20" />
                    <input id="team1" type="text" name=" owner " value="<%=game.getNameTeam1()%>" size="20" />
                    <input id="team2" type="text" name=" guest " value="<%=game.getNameTeam2() %>" size="20" />
                    <input id="place" type="text" name=" place " value="<%=game.getPlaceGame()%>" size="20" />
                </div>
               
       
        <%}%>  
    </CENTER>    
    </body>
</html>
