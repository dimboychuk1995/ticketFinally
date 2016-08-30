<%-- 
    Document   : addGame
    Created on : 3 серп. 2016, 17:05:12
    Author     : us9546
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>addGame</title>
    </head>
    <body>
        <div>
        <br>
            <form  action="../GamesController" method="POST" >
                <div class ="col-xs-1">
                        <select class="form-control" name="season">
                            <option id="season">2015-2016</option>
                            <option id="season">2016-2017</option>
                            <option id="season">2017-2018</option>
                            <option id="season">2018-2019</option>
                        </select>
                </div>
                <div class="col-xs-2">
                    <input id = "inputAddTime" class="form-control" type="text" name= "time"    value="" size="3" placeholder = "час"/>
                </div>
                <div class="col-xs-2">
                    <input class="form-control" type="text" name= "date"    value="" size="20" placeholder = "дата матчу"/>
                </div>
                <div class="col-xs-2">
                    <input class="form-control" type="text" name= "owner"   value="Ураган" size="20" placeholder = "господар"/>
                </div>
                    <div class="col-xs-2">
                <input class="form-control" type="text" name= "guest"   value="" size="20" placeholder = "гості"/>
                </div>
                <div class="col-xs-2">
                    <input class="form-control" type="text" name= "place"   value="Коледж фіичного виховання" size="20" placeholder = "місце проведення"/>                                            
                </div>
                <input id="insertGame" type="hidden" name="insertGame" value="insertGame" />
                <button class = "btn btn-success" type="submit">зберегти</button>
            </form>
        </div>
        <br>
    </body>
</html>
