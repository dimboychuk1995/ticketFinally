<%-- 
    Document   : sale
    Created on : 7 лип. 2016, 14:21:36
    Author     : us9522
--%>
<%@page import="java.util.Iterator"%>
<%@page import="ua.ticket.web.controllers.SaleController"%>
<%@page import="ua.ticket.web.beans.Place"%>
<%@page import="ua.ticket.web.controllers.GamesController"%>
<%@page import="ua.ticket.web.beans.GameOfTeam"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Продаж квитків</title>

        <!-- Bootstrap -->
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/sale.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
      </head>
  
  
    <body>
        
        <jsp:useBean id="placeList" class="ua.ticket.web.controllers.SaleController"/>
        <jsp:useBean id="gamesList" class="ua.ticket.web.controllers.GamesController"/>
        
        <div class="header"></div>    

        <div class="content">
                
            <div class="list_matches">
                <form class="form-inline" role="form" action="../SaleController" method="POST">
                    <select class="form-control matches" name = "selectGame">
                        <%
                            for (GameOfTeam game : gamesList.showFutureGame()){
                        %>

                        <option id="teams" value = <%=game.getId()%> ><%=game.getNameTeam1()%> - <%=game.getNameTeam2()%></option>

                        <%}%>
                    </select>
                    
                    <button type="submit" value="update" class="btn btn-default btn_show">Показати список квитків по даному матчі</button>
                     
                </form>
            </div>
            
            
            <div class="sectors_up">
                
                <div class="row sector_f">
                    <center>
                    <h3><%=placeList.getNameTeams()%></h3>
                    </center>
                    <table class = "table table-bordered">
                        <thead>
                            <tr>
                                <th bgcolor="#BDBDBD" style="width: 10%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Сектор</th>
                                <th bgcolor="#BDBDBD" style="width: 10%">Ряд</th>
                                <th bgcolor="#BDBDBD" style="width: 80%">Місце</th>
                            </tr>
                        </thead>
                        <tbody>
                    <%      
                          Iterator iterSector = placeList.getListSector().iterator();
                          while (iterSector.hasNext()){
                              int idSector = (Integer) iterSector.next();
                    %>
                    <tr>
                        <td bgcolor="#01A9DB" rowspan=" <%=placeList.getListRows(idSector).size()%>">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=idSector%></td>
                        
                    <% 
                        Iterator<Integer> iterRows = placeList.getListRows(idSector).iterator();
                        while (iterRows.hasNext()){
                           int idRows = iterRows.next();
                            placeList.setIdRow(idRows);
                        
                    %>
                    <td bgcolor="#FE642E">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=idRows%></td>
                    <td bgcolor="#61210B">
                    <%
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
                    %>
                    <button data-toggle="modal" data-target="#<%=place.getId()%>" id="btn_update" value="update" type="submit" class="<%=colorButton%>"><%=place.getNumber()%></button>
 
                    <div id="<%=place.getId()%>" class="modal fade" role="dialog">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Інформація про квиток</h4>
                                </div>
                                <div class="modal-body">
                                    <form action="../SaleController" method="POST">
                                        <div class="form-group form-group_on_sale">
                                       <!-- <label for="id">id</label> 
                                            <input placeholder="id" class="form-control" id="id" type="text" name="id" value="<%=place.getId()%>"/> 
                                            <label for="row">row</label>
                                            <input placeholder="Ряд" class="form-control" id="row" type="text" name="row" value="<%=place.getRow()%>"/> 
                                            <label for="number">number</label>
                                            <input placeholder="Місце" class="form-control" id="number" type="text" name="number" value="<%=place.getNumber()%>"/> 
                                            <label for="id_sector">id_sector</label>
                                            <input placeholder="Сектор" class="form-control" id="id_sector" type="text" name="id_sector" value="<%=place.getIdSector()%>"/> 
                                       -->
                                            <input placeholder="id" class="form-control" id="id" type="hidden" name="id" value="<%=place.getId()%>"/>      
                                            <label for="status">Статус</label>
                                            <input placeholder="Вільно/зайнято" class="form-control" id="status" type="text" name="status" value="<%=place.getStatus()%>"/> 
                                            <label for="PIP">П.І.Б.</label>
                                            <input placeholder="ПІП" class="form-control" id="PIP" type="text" name="PIP" value="<%=place.getPIP()%>"/> 
                                        </div>
                                            <input id="orderPlace" type="hidden" name="orderPlace" value="orderPlace" />
                                            <button id="btn_update" value="update" type="submit" class="btn btn-warning">Зберегти</button>
                                    </form>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Вийти</button>
                                </div>
                            </div>
                        </div>
                    </div>
                     
                    <%}else continue;%>
                    <%}%>
                    </td>
                    </tr>
                    <%}%>
                    
                    <%}%>
                        
                    </tbody>
                </table>                 
                </div>
                
                <div class="row sectors_c_d_e">
                    <div class="col-lg-3 sector_c">
                        
                    </div>
                    
                    <div class="col-lg-6 sector_d">
                        
                    </div>
                    
                    <div class="col-lg-3 sector_e">
                        
                    </div>
                </div>
                
            </div>

        </div>
        <div class="footer"></div>
      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script src="../js/bootstrap.min.js"></script>
    </body>
</html>