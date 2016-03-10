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
			<th>Modificar</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach var="admin" items="${admins}">
			<tr>
				<td><c:out value="${admin.dni }" /></td>
				<td><c:out value="${admin.nombre }" /></td>
				<td><c:out value="${admin.apellido }" /></td>
				<td><c:out value="${admin.email }" /></td>
				<td><c:out value="${admin.telefono }" /></td>
				<td><c:out value="${admin.domicilio }" /></td>
				<td><form
						action="${pageContext.request.contextPath}/admin/editarAdmin"
						method="GET">
						<input type="hidden" value="${admin.id }" name="id"> <input
							type="submit" class="btn btn-warning" value="Modificar" />
					</form></td>
				<td>
				<td>
				<form action="${pageContext.request.contextPath}/admin/eliminarAdmin" method="POST">
						<input type="hidden" value="${admin.id }" name="id"> <input
							type="submit" class="btn btn-danger botondelete" value="Eliminar" />
					</form>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a href="${pageContext.request.contextPath}/admin/crear"
	class="btn btn-primary" role="button">Alta Administrador</a>