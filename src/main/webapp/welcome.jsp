<%-- 
    Document   : welcome
    Created on : Mar 3, 2015, 10:52:01 AM
    Author     : Jonny
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello  ${sessionScope.username}</h1>
        <form action="ShowComments" method="POST" id="myForm">
            <textarea rows="4" cols="50" name="comment" form="myForm" placeholder="Comment Here..."></textarea>
            <br />
            <input type="submit" value="Comment"/>
            <br />
            <%
                List<String> comments = (List<String>)request.getAttribute("comments");
                
                for (String comment : comments) {
                    out.write(comment + "<br />");
                }
            %>
        </form>
    </body>
</html>
