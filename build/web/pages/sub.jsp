<%@page import="ua.ticket.web.controllers.SubscriptionController"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : main
    Created on : 6 лип. 2016, 10:24:49
    Author     : us9522
--%>
<%@page import="ua.ticket.web.beans.Subscription"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Абонементи</title>
        <script src= "../js/manipulSub.js" type="text/javascript"></script>
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/sub.css" rel="stylesheet">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
        
        <jsp:useBean id="subscriptionList" class="ua.ticket.web.controllers.SubscriptionController"/>
        
        <button id ="addS" class="btn btn-warning" type = "button" onclick = "add_games();">добавити абонемент</button> 
        
        <input id="editGames" type="hidden" name="editGames" value="editGames" />
        <button id="editS" class="btn btn-warning" type = "submit" onclick = "editS();">редагувати абонементи</button> 
        
        <form  action="../GamesController" method="POST">
             <button id = 'button_InfoGame' type="submit" class="btn btn-primary"> Інформація про матчі </button> 
        </form>
        
        <form  action="../SaleController" method="POST">
             <button id = 'button_SaleTickets' type="submit" class="btn btn-primary"> Замовити квиток </button>
             <br>
        </form> 
        <br>
        <div id = 'addSubJs'></div>
        <br>
        <table id ="tableSub" class="table">
            <thead>
                <tr>
                    <th class ='headTable' bgcolor="#BDBDBD" style="width: 60%">ПІП</th>
                    <th class ='headTable' bgcolor="#BDBDBD" style="width: 25%">сезон</th>
                    <th class ='headTable' bgcolor="#BDBDBD" style="width: 5%">сектор</th>
                    <th class ='headTable' bgcolor="#BDBDBD" style="width: 5%">ряд</th>
                    <th class ='headTable' bgcolor="#BDBDBD" style="width: 5%" >місце</th>
                    <th class ='headTable' bgcolor="#BDBDBD" style="width: 0%" ></th>
                    <th class ='headTable' bgcolor="#BDBDBD" style="width: 0%" ></th>
                </tr>
                
            </thead>
            <tbody>
            <div>
                 <%
                    for (Subscription subscription : subscriptionList.getSubscriptionAll()) {
                %>
                    <form  action="../SubscriptionController" method="POST">
                        <div class="form-group">
                            <tr>
                            <input id="id" type="hidden" name="id" value="<%=subscription.getId()%>" size="20" />
                            <td class = 'columnTableSub'><input id="PIP"   class="col-xs-12"  type="text" name="PIP" value="<%=subscription.getPIP()%>" size="20" disabled /></td>
                            <td class = 'columnTableSub'><input id="season"class="col-xs-12"  type="text" name="season" value="<%=subscription.getSeason()%>" size="20" disabled  /></td>
                            <td class = 'columnTableSub'><input id="sector"class="col-xs-12"  type="text" name="sector" value="<%=subscription.getSector()%>" size="20" disabled /></td>
                            <td class = 'columnTableSub'><input id="row"   class="col-xs-12"  type="text" name="row" value="<%=subscription.getRow()%>" size="20" disabled  /></td>
                            <td class = 'columnTableSub'><input id="number" class="col-xs-12" type="text" name="number" value="<%=subscription.getNumber()%>" size="20" disabled  /></td>
                        </div>
                        <td class = 'columnTableSub'><button id="btn_update" value="update" type="submit" class="btn btn-mini btn-warning" style = "display: none">Оновити</button></td>  
                    </form>
                
                    <form  action="../SubscriptionController" method="POST">
                        <input class="delete_sub" id="id" type="text" name="id" value="<%=subscription.getId()%>" size="20" />
                        <td class = 'columnTableSub'><button id="btn_delete" value="delete" type="submit" class="btn btn-mini btn-warning" style = "display: none" >Видалити</button></td> 
                    </form>
                    </tr>
                 </div>       
                <%}%>
                </tbody>
                </table>
         <!--
            <div class="add_sub">
                
                <form action="../SubscriptionController" method="POST">
                    <div class="form-group">
                        <div class ="col-xs-2">
                        <input class="form-control" type="text" id="PIP" name="PIP" value="" placeholder="ПІП"/> 
                        </div>
                        <div class ="col-xs-2">
                        <select class="form-control" name="season">
                            <option id="season">2015-2016</option>
                            <option id="season">2016-2017</option>
                            <option id="season">2017-2018</option>
                            <option id="season">2018-2019</option>
                        </select>
                        </div>
                        <div class ="col-xs-2">
                        <input class="form-control" type="text" id="sector" name="sector" value="" placeholder="sector" />
                        </div>
                        <div class ="col-xs-2">
                        <input class="form-control" type="text" id="row" name="row" value="" placeholder="row" />
                        </div>
                        <div class ="col-xs-2">
                        <input class="form-control" type="text" id="number" name="number" value="" placeholder="number" />
                        </div>
                        <button id="btn_add" value="delete" type="submit" class="btn btn-success">Зберегти</button> 
                    </div> 
                </form>
                
            </div>
        -->
        <div class="footer"></div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    
        <script src="../js/bootstrap.min.js"></script>
       
        
    </body>
</html>
