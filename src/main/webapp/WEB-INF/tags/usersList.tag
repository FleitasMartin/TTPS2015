<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<table class="table">
	<thead>
		<tr>
			<th>DNI</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Email</th>
			<th>Telefono</th>
			<th>Domicilio</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach var="usuario" items="${usuarios}">
			<tr>
				<td><c:out value="${usuario.dni }" /></td>
				<td><c:out value="${usuario.nombre }" /></td>
				<td><c:out value="${usuario.apellido }" /></td>
				<td><c:out value="${usuario.email }" /></td>
				<td><c:out value="${usuario.telefono }" /></td>
				<td><c:out value="${usuario.domicilio }" /></td>

			</tr>
		</c:forEach>
	</tbody>
</table>
