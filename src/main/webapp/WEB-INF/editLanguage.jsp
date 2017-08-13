<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h2>Update language:</h2>
<form:form method="POST" action="/languages/edit/${id}" modelAttribute="language">
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

<p><a href = "/languages/delete/${id}">Delete</a></p>
<p><a href = "/languages">Dashboard</a></p>