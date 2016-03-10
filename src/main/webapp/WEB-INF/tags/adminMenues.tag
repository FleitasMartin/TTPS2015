<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag language="java" pageEncoding="UTF-8"%>

<div>
	<table class="table">
		<tr>
			<td>Nombre</td>
			<td>Detalle</td>
			<td>Modificar</td>
			<td>Eliminar</td>
		</tr>
		<c:forEach var="menu" items="${menues}">
			<tr>
				<td><c:out value="${menu.nombre }" /></td>
				<td>
					<button type="button" class="btn btn-default dropdown-toggle"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						Detalle <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li class="dropdown-header">Componentes</li>
						<c:forEach var="componente" items="${menu.componentes}">
							<li><c:out value="${componente.nombre }" /></li>
						</c:forEach>

						<li class="dropdown-header">Caracteristicas</li>
						<c:forEach var="carac" items="${menu.caracteristica}">
							<li><c:out value="${carac.nombre }" /></li>
						</c:forEach>
					</ul>
				</td>
				<td><form
						action="${pageContext.request.contextPath}/menu/editar"
						method="GET">
						<input type="hidden" value="${menu.id }" name="id"> <input
							type="submit" class="btn btn-warning" value="Modificar" />
					</form></td>
				<td>
					<form
						action="${pageContext.request.contextPath}/menu/eliminar"
						method="POST">
						<input type="hidden" value="${menu.id }" name="id"> <input
							type="submit" class="btn btn-danger botondelete" value="Eliminar" />
					</form>
				</td>
			</tr>
		</c:forEach>
		
	</table>

	<a href="${pageContext.request.contextPath}/menu/crear"
		class="btn btn-primary" role="button">Alta Menu</a>
</div>