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
        <title>JSP Page</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/sub.css" rel="stylesheet">
    </head>
    <body>
        
        <jsp:useBean id="subscriptionList" class="ua.ticket.web.controllers.SubscriptionController"/>

        <div class="header">
            
        </div>
        
        <div class="content">
            
            <div class="forms">
                <%
                    for (Subscription subscription : subscriptionList.getSubscriptionAll()) {
                %>
                    <form role="form form_update" action="../SubscriptionController" method="POST">
                        <div class="form-group">
                            <input id="id" type="text" name="id" value="<%=subscription.getId()%>" size="20" />
                            <input id="PIP" type="text" name="PIP" value="<%=subscription.getPIP()%>" size="20" />
                            <input id="season" type="text" name="season" value="<%=subscription.getSeason()%>" size="20" />
                            <input id="placeId" type="text" name="placeId" value="<%=subscription.getPlaceId()%>" size="20" />
                        </div>
                        <button id="btn_update" value="update" type="submit" class="btn btn-warning">Оновити</button>  
                    </form>
                    
                    <form role="form form_delete" action="../SubscriptionController" method="POST">
                        <div class="form-group">
                            <input id="id" class="id_none" type="text" name="id" value="<%=subscription.getId()%>" size="0" />
                        </div>
                        <button id="btn_delete" value="delete" type="submit" class="btn btn-danger">Видалити</button>  
                    </form>
                <%}%>
            </div> 
            
            <div class="add_sub">
                <form method="POST">
                    
                </form>
            </div>
            
        </div>
        
        <div class="footer"></div>
        
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    
        <script src="../js/bootstrap.min.js"></script>
       
        
    </body>
</html>
