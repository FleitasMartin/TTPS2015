<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<table class="table">
	<thead>
		<tr>
			<th>DNI</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Sede</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach var="responsable" items="${resps}">
			<tr>
				<td><c:out value="${responsable.dni }" /></td>
				<td><c:out value="${responsable.nombre }" /></td>
				<td><c:out value="${responsable.apellido }" /></td>
				<td><c:out value="${responsable.sede.nombre }" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a href="${pageContext.request.contextPath}/admin/altaResponsable"
	class="btn btn-primary" role="button">Alta Responsable</a>