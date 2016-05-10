<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag language="java" pageEncoding="UTF-8"%>

<h1><c:out value="${mensaje}"></c:out></h1>
<div class="table-responsive">
	<table class="table">
		<thead>
			<tr>
				<th>Fecha Efectuada</th>
				<th>Monto</th>
				<th>Detalles</th>
				<th>Pago</th>
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
					<td><c:choose>
							<c:when test="${compra.pagado}">
							Pagado
 							 </c:when>
							<c:otherwise>
							<form action="${pageContext.request.contextPath}/compra/pagar"
								method="POST">
								<input type="hidden" value="${compra.id }" name="id"> <input
									type="submit" class="btn btn-danger " value="Pagar" />
							</form>
  							</c:otherwise>
						</c:choose> 
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<a href="${pageContext.request.contextPath}/compra/compraDeTickets"
	class="btn btn-primary" role="button">Comprar Tickets</a>