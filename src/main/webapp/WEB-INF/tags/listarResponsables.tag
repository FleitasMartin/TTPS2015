<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<table class="table">
	<thead>
		<tr>
			<th>DNI</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Sede</th>
			<th>Email</th>
			<th>Telefono</th>
			<th>Domicilio</th>
			<th>Modificar</th>
			<th>Eliminar</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach var="responsable" items="${responsables}">
			<tr>
				<td><c:out value="${responsable.dni }" /></td>
				<td><c:out value="${responsable.nombre }" /></td>
				<td><c:out value="${responsable.apellido }" /></td>
				<td><c:out value="${responsable.sede.nombre }" /></td>
				<td><c:out value="${responsable.email }" /></td>
				<td><c:out value="${responsable.telefono }" /></td>
				<td><c:out value="${responsable.domicilio }" /></td>
				<td><form
					action="${pageContext.request.contextPath}/responsable/editarResponsable"
					method="GET">
					<input type="hidden" value="${responsable.id }" name="id"> <input
					type="submit" class="btn btn-warning" value="Modificar" />
					</form></td>
				<td>
								<td>
				<form action="${pageContext.request.contextPath}/responsable/eliminarResponsable" method="POST">
						<input type="hidden" value="${responsable.id }" name="id"> <input
							type="submit" class="btn btn-danger botondelete" value="Eliminar" />
					</form>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a href="${pageContext.request.contextPath}/responsable/crear"
	class="btn btn-primary" role="button">Alta Responsable</a>