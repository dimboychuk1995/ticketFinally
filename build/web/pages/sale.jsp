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
<%--<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>--%>


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
        <script src= "../js/Error.js" type="text/javascript"></script>
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

                        <option id="teams" value = <%=game.getId()%>><%=game.getNameTeam1()%> - <%=game.getNameTeam2()%></option>

                        <%}%>
                    </select>
                    
                    <button type="submit" value="update" class="btn btn-default btn_show">Показати список квитків по даному матчі</button>
                </div>  
                </form>
                    <form action="../SesionController" method="POST" class="form_out">
                    <input type="hidden" name="exitSesion" value="exitSesion" />
                    <button id ="exitBtn" class="btnExit" type="submit">Вийти</button>
                </form>
                         

            <div class="sectors_up">
                
                <div class="row sector_f">
                    <center>
                    <h3 id = 'nameTeams'><%=placeList.getNameTeams()%></h3>
                    </center>
                    
                    <%      
                        Iterator iterSector = placeList.getListSector().iterator();
                        String idSectorClass = "";
                        String idRowClass = "idRow";
                        while (iterSector.hasNext()){
                            int idSector = (Integer) iterSector.next();
                            
                            switch (idSector){
                                case 1: idSectorClass = "idClassA";
                                break;
                                case 2: idSectorClass = "idClassB";
                                break;
                                case 3: idSectorClass = "idClassVIP";
                                break;
                                case 4: idSectorClass = "idClassF";
                                break;
                                case 5: idSectorClass = "idClassG";
                                break;
                                case 6: idSectorClass = "idClassC";
                                break;
                                case 7: idSectorClass = "idClassD";
                                break;
                                case 8: idSectorClass = "idClassE";
                                break;
                                case 9: idSectorClass = "idClassO";
                                break;
                                case 10: idSectorClass = "idClassP";
                                break;
                            }
                    %>
                    <div class="first_sec">
                    <div id="<%=idSectorClass%>" class="sector">
                        <br>
                        <% 
                        Iterator<Integer> iterRows = placeList.getListRows(idSector).iterator();
                        while (iterRows.hasNext()){
                           int idRows = iterRows.next();
                            placeList.setIdRow(idRows);
                        %>
                        <div class = "<%=idRowClass + idRows%>">
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
                                
                            <button data-toggle="modal" data-target="#<%=place.getId()%>" id="btn_update" value="update" type="submit" class="<%=colorButton%> btn_place"><%=place.getNumber()%></button>
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
                                                                    <%
                                                                        String statusTicket = "";
                                                                        switch (place.getStatus()){
                                                                            case 0: statusTicket = "Free";
                                                                               break;
                                                                            case 1: statusTicket = "Busy";
                                                                               break;
                                                                            case 2: statusTicket = "Booked";
                                                                               break;    
                                                                        }
                                                                    %>
                                                                   <select onchange="document.getElementById('selectHidden').value = this.value"  class="form-control" name="status">
                                                                       <option selected><%=statusTicket%></option>
                                                                       <option>Free</option>
                                                                       <option>Busy</option>
                                                                       <option>Booked</option>   
                                                                   </select>
                                                                   <!--<input placeholder="Вільно/зайнято" class="form-control" id="status" type="text" name="status" value="<%=place.getStatus()%>"/> -->
                                                                   <label for="PIP">П.І.Б.</label>
                                                                   <input placeholder="ПІП" class="form-control" id="PIP" type="text" name="PIP" value="<%=place.getPIP()%>"/> 
                                                           </div>
                                                               <input id="orderPlace" type="hidden" name="orderPlace" value="orderPlace" />
                                                               <button id="btn_update" value="update" type="submit" class="btn btn-warning">Зберегти</button>
                                                       </form>
                                                   </div>
                                                                      <form action="../TicketController" method="POST">
                                                                <input class="form-control" id="selectHidden" type="hidden" name="selectHidden" value="defoult"/>
                                                                <input class="form-control" id="status" type="hidden" name="status" value=""/>
                                                                <input class="form-control" id="PIP" type="hidden" name="PIP" value="<%=place.getPIP()%>"/>
                                                                <input class="form-control" id="id" type="hidden" name="id" value="<%=place.getId()%>"/> 
                                                                <input class="form-control" id="row" type="hidden" name="row" value="<%=place.getRow()%>"/> 
                                                                <input class="form-control" id="number" type="hidden" name="number" value="<%=place.getNumber()%>"/> 
                                                                <input class="form-control" id="sector" type="hidden" name="sector" value="<%=place.getIdSector()%>"/>
                                                                <%
                                                                    String submit  = "";
                                                                    String onclick = "";
                                                                    if (place.getStatus() != 1){
                                                                       submit = "reset";                                                                                                                                             
                                                                       onclick = "masageErrorStatus();";
                                                                    }
                                                                %>
                                                                
                                                                <p id = 'button_PrintTicket'> <button id ="buttonPrintTicket" name="buttonToPrintTicket" type="<%=submit%>" class= "btn btn-primary" onclick="<%=onclick%>"> друкувати квиток </button> 
                                                           </form> 
                                               <div class="modal-footer">
                                               <button type="button" class="btn btn-default" data-dismiss="modal">Вийти</button>
                                           </div>
                                       </div>
                                   </div>
                               </div>
                                <%}%>
                         <%}%>
                        </div>
                        <%}%>                        
                    </div>
                    
                    <%}%>
                    </div>
                </div>
            </div>
                    
                    <img class="media-object" src="../image/pole.PNG" alt="...">
        <div class="btn btn-success btn-lg sl_sector sector_o">службовий Сектор О</div>
        <div class="btn btn-success btn-lg sl_sector sector_p">службовий Сектор P</div>
        <br>
        <div class="btn btn-success btn-lg sl_sector sector_l" data-toggle="modal" data-target="#ModalL">Сектор L</div>
                        
        <form  action="../SubscriptionController" method="POST" class="form_add">
            <p id = 'button_AddSub'> <button type="submit" class="btn btn-primary"> Добавити абоненмент </button> 
        </form>
        <form  action="../GamesController" method="POST">
            <p id = 'button_InfoGame'> <button type="submit" class="btn btn-primary"> Інформація про ігри </button>
        </form>
        </div>
                    
        <div id="ModalL" class="modal fade">
                <div class="modal-dialog">

                  <!-- Modal content-->
                  <div class="modal-content">
                    <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal">&times;</button>
                      <h4 class="modal-title">Modal Header</h4>
                    </div>
                    <div class="modal-body">
                        <form role="form" action="../SaleController" method="POST">
                            <div class="form-group">
                                <label for="PIP">ПІП</label>
                                <input type="text" name="PIP" class="form-control" id="PIP" placeholder="Введіть прізвище">
                            </div>
                            <button type="submit"  class="btn btn-success">Додати</button>
                        </form>
                    </div>
                    <div class="modal-footer">
                      <button type="button" class="btn btn-default" data-dismiss="modal">Закрити</button>
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