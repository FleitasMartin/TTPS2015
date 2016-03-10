<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<table class="table">
	<thead>
		<tr>
			<th>DNI</th>
			<th>Nombre</th>
			<th>Apellido</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach var="admin" items="${admins}">
			<tr>
				<td><c:out value="${admin.dni }" /></td>
				<td><c:out value="${admin.nombre }" /></td>
				<td><c:out value="${admin.apellido }" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a href="${pageContext.request.contextPath}/admin/crear"
	class="btn btn-primary" role="button">Alta Administrador</a>