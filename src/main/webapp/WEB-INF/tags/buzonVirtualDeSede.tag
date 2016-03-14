<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<div>
	<table class="table">
		<tr>
			<th>Usuario</th>
			<th>Sugerencia</th>
			<td>Sede</td>
			<td>Detalle</td>
		</tr>
		<c:forEach var="sugerencia" items="${sugerencias}">
		<tr>
			<td><c:out value="${sugerencia.usuario.nombre }" /></td>
			<td><c:out value="${sugerencia.tipo }" /></td>
			<td><c:out value="${sugerencia.sede.nombre }" /></td>
			<td>
					<button type="button" class="btn btn-default dropdown-toggle"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						Detalle <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li class="dropdown-header">Detalle</li>
							<li><c:out value="${sugerencia.mensaje}" /></li>
					</ul>
				</td>
		</tr>
		</c:forEach>

	</table>
</div>