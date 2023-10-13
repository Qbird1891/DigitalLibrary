<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Titles</title>
</head>
<body>
<table>

  <c:forEach items="${requestScope.showAllTitles}" var="currenttitle">
     <tr>
       <td>${currenttitle.title }|</td>
       
       <td>${currenttitle.type}</td>
      </tr>
      
 </c:forEach>
</table>

<br />
	<a href="index.jsp">Home</a>
</body>
</html>