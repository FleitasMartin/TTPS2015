<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag language="java" pageEncoding="UTF-8"%>

<div>
	<table class="table">
		<tr>
			<td>Nombre</td>
			<td>Celiaco</td>
			<td>Diab&eacute;tco</td>
			<td>Hipertenso</td>
			<td>Intolerante a la Lactosa</td>
			<td>Detalle</td>
			<td>Modificar</td>
			<td>Eliminar</td>
		</tr>
		<c:forEach var="menu" items="${menues}">
			<tr>
				<td><c:out value="${menu.nombre }" /></td>
				<td><c:out value="${menu.celiaco }" /></td>
				<td><c:out value="${menu.diabetico }" /></td>
				<td><c:out value="${menu.hipertenso }" /></td>
				<td><c:out value="${menu.intoLactosa }" /></td>
<!-- 				<td><a class="btn btn-warning" href="#">Detalle</a></td> -->
				<td>
				<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			    Detalle <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu">
				  <c:forEach var="componente" items="${menu.componentes}">
				    <li><c:out value="${componente.nombre }" /></li>
				  </c:forEach>
				  </ul>
			  </td>
				<td><form action="${pageContext.request.contextPath}/admin/editarMenu" method="GET">
							<input type="hidden" value="${menu.id }" name="id">
							<input type="submit" class="btn btn-warning"
									value="Modificar" />
						</form>
				</td>
				<td>
				<form action="${pageContext.request.contextPath}/admin/eliminarMenu" method="POST">
						<input type="hidden" value="${menu.id }" name="id">
						<input type="submit" class="btn btn-danger botondelete"
								value="Eliminar" />
				</form>
				</td>
<!-- 				<td><a class="btn btn-danger botondelete" href="#">Eliminar</a></td> -->
			</tr>
		</c:forEach>
<!-- 		<tr> -->
<!-- 			<td>Rizzoto</td> -->
<!-- 			<td>Apto</td> -->
<!-- 			<td>Apto</td> -->
<!-- 			<td>Apto</td> -->
<!-- 			<td>Apto</td> -->
<!-- 			<td><a class="btn btn-warning" href="#">Detalle</a></td> -->
<!-- 			<td><a class="btn btn-warning" href="#">Modificar</a></td> -->
<!-- 			<td><a class="btn btn-danger botondelete" href="#">Eliminar</a></td> -->
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td>Pastel de Papa</td> -->
<!-- 			<td>Apto</td> -->
<!-- 			<td>Apto</td> -->
<!-- 			<td>Apto</td> -->
<!-- 			<td>Apto</td> -->
<!-- 			<td><a class="btn btn-warning" href="#">Detalle</a></td> -->
<!-- 			<td><a class="btn btn-warning" href="#">Modificar</a></td> -->
<!-- 			<td><a class="btn btn-danger botondelete" href="#">Eliminar</a></td> -->
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td>Pasta</td> -->
<!-- 			<td>Apto</td> -->
<!-- 			<td>Apto</td> -->
<!-- 			<td>Apto</td> -->
<!-- 			<td>Apto</td> -->
<!-- 			<td><a class="btn btn-warning" href="#">Detalle</a></td> -->
<!-- 			<td><a class="btn btn-warning" href="#">Modificar</a></td> -->
<!-- 			<td><a class="btn btn-danger botondelete" href="#">Eliminar</a></td> -->
<!-- 		</tr> -->


	</table>

	<a href="${pageContext.request.contextPath}/admin/altaMenu"
		class="btn btn-primary" role="button">Alta Menu</a>
</div>