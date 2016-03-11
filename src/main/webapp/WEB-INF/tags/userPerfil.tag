<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<table class="table">
	<thead>
		<tr>
			<th>D.N.I.</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Facultad</th>
			<th>Telefono</th>
			<th>Email</th>
			<th>Domicilio</th>
			<th>Tipo de usuario</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><c:out value="${usuario.dni }" /></td>
			<td><c:out value="${usuario.nombre }" /></td>
			<td><c:out value="${usuario.apellido }" /></td>
			<td><c:out value="${usuario.facultad }" /></td>
			<td><c:out value="${usuario.telefono }" /></td>
			<td><c:out value="${usuario.email }" /></td>
			<td><c:out value="${admin.domicilio }" /></td>
			<td><c:out value="${admin.tipo }" /></td>
		</tr>
	</tbody>
</table>

<h2>Mis Preferencias</h2>
<table class="table">

	<thead>
		<c:forEach var="caracteristica" items="${usuario.caracteristica}">
		<tr>
		
			<th><c:out value="${caracteristica.nombre }" /></th>
			<td><span class="glyphicon glyphicon-ok"></span></td>

		</tr>
		</c:forEach>
	</thead>
<!-- 	<tbody> -->
<%--  	<c:forEach var="caracteristica" items="${usuario.caracteristica}">  --%>
<!--  		<tr> -->
<!--  			<td><span class="glyphicon glyphicon-ok"></span></td> --> 
<!--  			<td><span class="glyphicon glyphicon-remove"></span></td>  -->
<!-- 		</tr> -->
<%--  	</c:forEach> --%> 
<!-- 	</tbody> -->
</table>
<a href="${pageContext.request.contextPath}/user/editarPreferencias" class="btn btn-primary" role="button">Modificar
	preferencias</a>