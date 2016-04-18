<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<div class="table-responsive">
	<table class="table">
		<thead>
			<tr>
				<th>Fecha Efectuada</th>
				<th>Monto</th>
				<th>Detalles</th>
				<th>Email</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="compra" items="${compras}">
				<tr>
					<td><c:out value="${compra.fechaEfectuada }" /></td>
					<td><c:out value="${compra.monto }" /></td>
					<td>
					<div class="btn-group">
							<button type="button" class="btn btn-default dropdown-toggle"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">
								Detalle <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li class="dropdown-header">Menues</li>
								<c:forEach var="seleccionDiaMenu" items="${compra.selecciones}">
									<li><c:out value="${seleccionDiaMenu.nombre }" /></li>
								</c:forEach>
							</ul>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<a href="${pageContext.request.contextPath}/compra/compraDeTickets"
	class="btn btn-primary" role="button">Comprar Tickets</a>