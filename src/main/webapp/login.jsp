<%-- 
    Document   : login
    Created on : Mar 3, 2015, 10:32:50 AM
    Author     : Jonny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Please Log in:</h1>
        <form action="loginServ" method="POST">
            <input type="text" name="username" placeholder="username"/>
            <input type="password" name="password" placeholder="password"/>
            <input type="submit" value="login"/>
        </form>
    </body>
</html>
