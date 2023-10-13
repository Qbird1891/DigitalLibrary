<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Digital Library Database</title>
</head>
<body>
<h1> Digital Library</h1>
     <a href="insertTitle.jsp">Insert Title</a>
     
     <a href="deleteTitle.jsp">Delete Title</a>
     
     <a href="SearchByID.jsp">Search by ID #</a>
     
     <a href="SearchByTitle.jsp">Search by Title Name</a>
     
     <a href="SearchByType.jsp">Search by Item Type</a> 

     <form action="showAllTitles" method="get">
           <input type="submit" value="showAllTitles" />
     </form>
</body>
</html>