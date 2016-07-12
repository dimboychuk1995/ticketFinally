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
            input   { 
                
                    background: #F8F8FF;  
                    }
    
      
        </style>
    </head>

    <body>
        <jsp:useBean id="gamesList" class="ua.ticket.web.controllers.GamesController"/>
        <jsp:useBean id="gamesInfo" class="ua.ticket.web.controllers.GamesController"/>
        <jsp:useBean id="gamesTeam" class="ua.ticket.web.beans.GameOfTeam"/>

        <h2 align ="center">Розклад матчів НФК Урагану</h2>
        
        <form  action="../GamesController" method="POST" >
            <select name = "sortGames">
                <option value = "showAllGame"> всі матчі</option>
                <option value = "showCurrentGame"> поточний матч</option>
                <option value = "showFutureGame"> майбутні матчі</option>
            </select>
            <input type="submit" value="показати матчі">
        </form>
        <br>
        <br>
        <br>
         
        <CENTER>
        <div>
        <%
            for (GameOfTeam game : gamesList.futureGame()){
        %>
                <form  action="../GamesController" method="POST" >
                    <div id = "form-game">
                    <div class="content">
                        <input  type="hidden" name="id" value="<%=game.getId()%>" />
                        <input  type="text" name="time" value="<%=game.getTimeGame() %>" size="20"/>
                        <input  type="text" name="date" value="<%=game.getDateGame()%>" size="20" />
                        <input  type="text" name= "owner" value="<%=game.getNameTeam1()%>" size="20"/>
                        <input  type="text" name="guest" value="<%=game.getNameTeam2() %>" size="20" />
                        <input  type="text" name="place" value="<%=game.getPlaceGame()%>" size="20"/>
                        <input id="updateGame" type="hidden" name="updateGame" value="updateGame" />
                        <button type="submit">редагувати</button>
                    </div>
                    </div>    
                </form> 
        <br>

        <%}%>
        
        
        <input type="button" id="more_games" onclick="add_games();" value="Добавити матч" />
            
                <script>
                    function add_games() {
                        var objTo = document.getElementById('form-game')
                        var divtest = document.createElement("div");
                        divtest.innerHTML = '<div class="content">\n\
                                            <form  action="../GamesController" method="POST" >\n\
\n\                                         <input type="text" name= "time"    value="" size="20" placeholder = "час матчу"/>\n\
                                            <input type="text" name= "date"    value="" size="20" placeholder = "дата матчу"/>\n\
                                            <input type="text" name= "owner"   value="" size="20" placeholder = "господар"/>\n\
                                            <input type="text" name= "guest"   value="" size="20" placeholder = "гості"/>\n\
                                            <input type="text" name= "place"   value="" size="20" placeholder = "місце проведення"/>\n\
                                            <input id="insertGame" type="hidden" name="insertGame" value="insertGame" />\n\
                                            <button type="submit">Добавити</button>\n\
                                            </form>\n\
                                            </div>';
                        objTo.appendChild(divtest)
                    }
                </script>
        </div>
    </CENTER>    
    </body>
</html>
