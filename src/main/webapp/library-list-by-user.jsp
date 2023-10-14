<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Libraries</title>
</head>
<body>
	<form method="post" action="listNavigationServlet">
		<table>
			<c:forEach items="${requestScope.allLibraries}" var="currentlibrary">
				<tr>
					<td><input type="radio" name="id" value="${currentlibrary.id}"></td>
					<td><h2>${currentlibrary.libraryName}</h2></td>
				</tr>
				<tr>
					<td colspan="3">Trip Date: ${currentlibrary.libraryDate}</td>
				</tr>
				<tr>
					<td colspan="3">Library Owner: ${currentlibrary.library.ownerName}</td>
				</tr>
				<c:forEach var="libraryVal" items="${currentlibrary.listOfItems}">
					<tr>
						<td></td>
						<td colspan="3">${libraryVal.title}, ${libraryVal.type}</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToList"> 
		<input type="submit" value="delete" name="doThisToList"> 
		<input type="submit" value="add" name="doThisToList">
	</form>
	<a href="addItemsForLibraryServlet">Create a new Library</a>
	<a href="index.html">Insert a new piece of media</a>
</body>
</html>