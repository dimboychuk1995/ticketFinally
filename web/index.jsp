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
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/index.css">
        
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
       <div class="container">
         <h2>Сторінка входу</h2>
         <p id = "texstLog">Будь ласка введіть Ваш логін та пароль</p>
         <form class="form-inline" role="form" action="LoginController" method="POST">
           <div class="form-group">
             <label for="email">Login:</label>
             <input type="email" class="form-control" id="email" name = login placeholder="введіть Ваш Login">
           </div>
           <div class="form-group">
             <label for="pwd">Password:</label>
             <input type="password" class="form-control" id="pwd"  name = password placeholder="введіть Ваш пароль">
           </div>
           <button type="submit" class="btn_Send">Відправити</button>
         </form>
       </div>   
    </body>
</html>
