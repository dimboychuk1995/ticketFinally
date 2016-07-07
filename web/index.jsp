<%-- 
    Document   : index
    Created on : 6 лип. 2016, 10:07:43
    Author     : us9522
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <CENTER>
        <div class="main">
            
            <div class="header"></div>
            
            <div class="content">
                
                <div class="login">
                    <br><h2>Сторінка входу</h2>
                        <br  id = "login_table">
                        <h6>Будь ласка введіть Ваш логін та пароль</h6>
                            <br>
                               <form class="login_form" action="LoginController" method="POST">
                                   <table>
                                       <tr>
                                           <td><font> логін </font></td>
                                           <td><input type = text name = login></td>
                                       </tr>
                                       <tr>
                                           <td><font> пароль </font></td>
                                           <td><input type = password name = password> </td>
                                       </tr>
                                       <tr>
                                           <td align = right><input type="submit" value="ok" ></td>
                                       </tr>
                                   </table>
                               </form>  
                                
                            </br>
                         </br>
                    </br>
                </div>
                
            </div>
            
        </div>
    </CENTER>    
    </body>
</html>
