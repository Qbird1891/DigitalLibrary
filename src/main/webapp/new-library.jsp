<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a New Library</title>
</head>
<body>
	<form action="createNewLibraryServlet" method="post">
		Library Name: <input type="text" name="libraryName"><br /> 
		Library date: <input type="text" name="month" placeholder="mm" size="4">
					  <input type="text" name="day" placeholder="dd" size="4">,
					  <input type="text" name="year" placeholder="yyyy" size="4"> 
		Library Owner Name: <input type="text" name="ownerName"><br /> 
		Available Items:<br /> <select name="allItemsToAdd" multiple size="6">
			<c:forEach items="${requestScope.allItems}" var="currentitem">
				<option value="${currentitem.id}">${currentitem.title}|
					${currentitem.type}</option>
			</c:forEach>
		</select> <br /> <input type="submit" value="Create Library and Add Items">
	</form>
	<a href="index.html">Go add new items instead.</a>
</body>
</html>