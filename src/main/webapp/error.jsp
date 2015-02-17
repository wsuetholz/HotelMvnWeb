<%-- 
    Document   : errors
    Created on : Feb 11, 2015, 9:32:23 PM
    Author     : wsuetholz
--%>

%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <p style="font-size: xx-small;"><a href="index.jsp">Home</a> &gt; Error</p>
        <h1>Error!</h1>
        <p>${requestScope.errorMsg}</p>
        <p><%-- =request.getAttribute("errorMsg").toString() --%></p>
        <p><a href="index.jsp">Click here</a> to return to the home page.</p>
    </body>
</html>
