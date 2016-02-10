<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag language="java" pageEncoding="UTF-8"%>

<a href="${pageContext.request.contextPath}/admin/altaComponente"
	class="btn btn-primary" role="button">Alta Componente</a>
<div>
	<h3>Bebidas</h3>
	<table class="table">
		<thead>
			<tr>
				<td>Nombre</td>
				<td>Modificar</td>
				<td>Eliminar</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="componente" items="${componentes}">
			<c:if test="${componente.tipo == 'bebida'}">
   				<tr>
					<td><c:out value="${componente.nombre }" /></td>
					<td>
						<form action="${pageContext.request.contextPath}/admin/editarComponente" method="GET">
							<input type="hidden" value="${componente.id }" name="id">
							<input type="submit" class="btn btn-warning"
									value="Modificar" />
						</form>
					</td>
					<td>
					<form action="${pageContext.request.contextPath}/admin/eliminarComponente" method="POST">
						<input type="hidden" value="${componente.id }" name="id">
						<input type="submit" class="btn btn-danger botondelete"
								value="Eliminar" />
					</form>
					</td>
				</tr>
			</c:if>		
		</c:forEach>
		</tbody>
	</table>
	<h3>Entradas</h3>
	<table class="table">
		<thead>
			<tr>
				<td>Nombre</td>
				<td>Modificar</td>
				<td>Eliminar</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="componente" items="${componentes}">
			<c:if test="${componente.tipo == 'entrada'}">
   				<tr>
					<td><c:out value="${componente.nombre }" /></td>
					<td>
						<form action="${pageContext.request.contextPath}/admin/editarComponente" method="GET">
							<input type="hidden" value="${componente.id }" name="id">
							<input type="submit" class="btn btn-warning"
									value="Modificar" />
						</form>
					</td>
					<td>
					<form action="${pageContext.request.contextPath}/admin/eliminarComponente" method="POST">
						<input type="hidden" value="${componente.id }" name="id">
						<input type="submit" class="btn btn-danger botondelete"
								value="Eliminar" />
					</form>
					</td>
				</tr>
			</c:if>		
		</c:forEach>
		</tbody>
	</table>
	<h3>Plato principal</h3>
	<table class="table">
		<thead>
			<tr>
				<td>Nombre</td>
				<td>Modificar</td>
				<td>Eliminar</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="componente" items="${componentes}">
			<c:if test="${componente.tipo == 'plato'}">
   				<tr>
					<td><c:out value="${componente.nombre }" /></td>
					<td>
						<form action="${pageContext.request.contextPath}/admin/editarComponente" method="GET">
							<input type="hidden" value="${componente.id }" name="id">
							<input type="submit" class="btn btn-warning"
									value="Modificar" />
						</form>
					</td>
					<td>
					<form action="${pageContext.request.contextPath}/admin/eliminarComponente" method="POST">
						<input type="hidden" value="${componente.id }" name="id">
						<input type="submit" class="btn btn-danger botondelete"
								value="Eliminar" />
					</form>
					</td>
				</tr>
			</c:if>		
		</c:forEach>
		</tbody>
	</table>
	<h3>Postre</h3>
	<table class="table">
		<thead>
			<tr>
				<td>Nombre</td>
				<td>Modificar</td>
				<td>Eliminar</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="componente" items="${componentes}">
			<c:if test="${componente.tipo == 'postre'}">
   				<tr>
					<td><c:out value="${componente.nombre }" /></td>
					<td>
						<form action="${pageContext.request.contextPath}/admin/editarComponente" method="GET">
							<input type="hidden" value="${componente.id }" name="id">
							<input type="submit" class="btn btn-warning"
									value="Modificar" />
						</form>
					</td>
					<td>
					<form action="${pageContext.request.contextPath}/admin/eliminarComponente" method="POST">
						<input type="hidden" value="${componente.id }" name="id">
						<input type="submit" class="btn btn-danger botondelete"
								value="Eliminar" />
					</form>
					</td>
				</tr>
			</c:if>		
		</c:forEach>
		</tbody>
	</table>
</div>