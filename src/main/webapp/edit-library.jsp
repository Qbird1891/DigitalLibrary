<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit an Existing Library</title>
</head>
<body>
	<form action="editLibraryDetailsServlet" method="post">
		<input type="hidden" name="id" value="${libraryToEdit.id}"> 
		Library Name: <input type="text" name="libraryName" value="${libraryToEdit.libraryName}"><br /> 
		Library date: <input type="text" name="month" placeholder="mm" size="4" value="${month}">
					  <input type="text" name="day" placeholder="dd" size="4" value="${date}">, 
					  <input type="text" name="year" placeholder="yyyy" size="4" value="${year}"> 
		Library Owner Name: <input type="text" name="ownerName" value="${libraryToEdit.library.ownerName}"><br /> 
		Available Items:<br /> <select name="allItemsToAdd" multiple size="6">
		<c:forEach items="${requestScope.allItems}" var="currentitem">
				<option value="${currentitem.id}">${currentitem.title}|
					${currentitem.type}</option>
			</c:forEach>
		</select> <br /> <input type="submit" value="Edit Library and Add Media">
	</form>
	<a href="index.html">Go add new media instead.</a>
</body>
</html>