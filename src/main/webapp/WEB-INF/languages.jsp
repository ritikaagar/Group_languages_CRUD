<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>

<table class = "table">
	<tr>
	    <th>Name</th>
	    <th>Creator</th>
	    <th>Version</th>
	    <th>Action</th>
  	</tr>
 	
  	<c:forEach items= "${languages}" var= "lang" varStatus = "loop"> 
  	<tr>
		<td><a href = "/languages/${loop.index}"><c:out value="${lang.name}"/></a></td>
		<td><c:out value="${lang.creator}"/></td>
		<td><c:out value="${lang.version}"/></td>
		<td><a href = "/languages/delete/${loop.index}">Delete</a> <a href = "/languages/edit/${loop.index}">Edit</a></td>
	</tr>
	</c:forEach>
	
</table>
<br>
<h2>Create a new language:</h2>
<form:form method="POST" action="/languages/new" modelAttribute="language">
	<p>
    <form:label path="name">Name:
    <form:errors path="name"/>
    <form:input path="name"/></form:label>
    </p>
    
    <p>
    <form:label path="creator">Creator:
    <form:errors path="creator"/>
    <form:textarea path="creator"/></form:label>
    </p>
    
    <p>
    <form:label path="version">Version:
    <form:errors path="version"/>
    <form:input path="version"/></form:label>
    </p>
    
    <p>
    <input type="submit" value="Submit"/>
    </p>
</form:form>