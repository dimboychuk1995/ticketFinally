<%-- 
    Document   : sale
    Created on : 7 лип. 2016, 14:21:36
    Author     : us9522
--%>
<%@page import="ua.ticket.web.controllers.SaleController"%>
<%@page import="ua.ticket.web.beans.Place"%>
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


        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
      </head>
  
  
    <body>
        
        <jsp:useBean id="placeList" class="ua.ticket.web.controllers.SaleController"/>
        
        <div class="header"></div>    

        <div class="content">

            <div class="sectors_up">
                
                <div class="row sector_f">
                    <%
                        for(Place place : placeList.getPlaceSectorA()){
                    %>
                    
                    <button data-toggle="modal" data-target="#updateTicket" id="btn_update" value="update" type="submit" class="btn btn-warning"><%=place.getId()%></button>
                    
                    <div id="updateTicket" class="modal fade" role="dialog">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Інформація про квиток</h4>
                                </div>
                                <div class="modal-body">
                                    <form action="../SaleController" method="POST">
                                        <div class="form-group form-group_on_sale">
                                            <label for="id">id</label>
                                            <input placeholder="id" class="form-control" id="id" type="text" name="id" value="<%=place.getId()%>"/> 
                                            <label for="row">row</label>
                                            <input placeholder="Ряд" class="form-control" id="row" type="text" name="row" value="<%=place.getRow()%>"/> 
                                            <label for="number">number</label>
                                            <input placeholder="Місце" class="form-control" id="number" type="text" name="number" value="<%=place.getNumber()%>"/> 
                                            <label for="id_sector">id_sector</label>
                                            <input placeholder="Сектор" class="form-control" id="id_sector" type="text" name="id_sector" value="<%=place.getIdSector()%>"/> 
                                            <label for="status">status</label>
                                            <input placeholder="Вільно/зайнято" class="form-control" id="status" type="text" name="status" value="<%=place.getStatus()%>"/> 
                                            <label for="PIP">PIP</label>
                                            <input placeholder="ПІП" class="form-control" id="PIP" type="text" name="PIP" value="<%=place.getPIP()%>"/> 
                                        </div>
                                            <button id="btn_update" value="update" type="submit" class="btn btn-warning"><%=place.getId()%></button>
                                    </form>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Вийти</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <%}%>
                                    
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