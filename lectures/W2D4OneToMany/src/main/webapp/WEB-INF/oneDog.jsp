<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) --> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Functions --> 
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <!-- for Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <!-- YOUR own local CSS -->
    <link rel="stylesheet" href="/css/style.css"/>
    <title>Dog Emporium</title>
</head>
<body class="p-3">
	<header class="d-flex justify-content-between align-items-center border-bottom">
		<h1>Dog Emporium</h1>
		<a href="/">Dashboard</a>	
	</header>
	
	<h3><c:out value="${ oneDog.name }" /></h3> 
	<p><c:out value="${ oneDog.age }" /></p> 
	<p><c:out value="${ oneDog.hairColor }" /></p> 
	
	<h3>Here are this dog's collars:</h3>
	<table class="table">
		<thead>
			<th>Color</th>
			<th>Tag Shape</th>
			<th>Actions</th>
		</thead>
		<tbody>
			<c:forEach var="oneCollar" items="${ oneDog.collars }">
				<tr>
					<td><c:out value="${ oneCollar.color }" /></td>
					<td><c:out value="${ oneCollar.tagShape }" /></td>
					<td>
						<form action="/collars/${oneCollar.id}/${ oneDog.id }" method="post">
							<input type="hidden" name="_method" value="delete">
							<button class='btn btn-outline-danger'>Delete</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a href="/collars/new">Add a new collar to this dog</a>
</body>
</html>