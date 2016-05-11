<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ tag language="java" pageEncoding="UTF-8"%>

<div>
	<h3>Cartillas</h3>
	<table class="table">
		<thead>
			<tr>
				<td>Desde</td>
				<td>Hasta</td>
				<td>Precio</td>
				<td>Detalle</td>
				<td>Modificar</td>
				<td>Eliminar</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="cartilla" items="${cartillas}">
				<tr>
					<td><fmt:formatDate value="${cartilla.fechaInicio}"
							pattern="dd/MM/yyyy" /></td>
					<td><fmt:formatDate value="${cartilla.fechaFin}"
							pattern="dd/MM/yyyy" /></td>
					<td><c:out value="${cartilla.precio }" /></td>
					<td>
						<form action="${pageContext.request.contextPath}/cartilla/detalle"
							method="GET">
							<input type="hidden" value="${cartilla.id }" name="id"> <input
								type="submit" class="btn btn-warning" value="Detalle" />
						</form>
					</td>
					<td>
						<form action="${pageContext.request.contextPath}/cartilla/editar"
							method="GET">
							<input type="hidden" value="${cartilla.id }" name="id"> <input
								type="submit" class="btn btn-warning" value="Modificar" />
						</form>
					</td>
					<td>
						<form
							action="${pageContext.request.contextPath}/cartilla/eliminar"
							method="POST">
							<input type="hidden" value="${cartilla.id }" name="id"> <input
								type="submit" class="btn btn-danger botondelete"
								value="Eliminar" />
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<a href="${pageContext.request.contextPath}/cartilla/crear"
	class="btn btn-primary" role="button">Alta Cartilla</a>