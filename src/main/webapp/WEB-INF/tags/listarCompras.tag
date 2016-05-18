<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ tag language="java" pageEncoding="UTF-8"%>

<div class="col-md-12">
	<div class="col-md-7">
		<div class="col-md-12">
			<table class="table ">
				<thead>
					<tr>
						<th class="text-center" style="border:none" ><h3>
								<span class="label label-default">Fecha </span>
							</h3></th>
						<th class="text-center" style="border:none" ><h3>
								<span class="label label-default">Monto </span>
							</h3></th>
						<th class="text-center" style="border:none" ><h3>
								<span class="label label-default">Detalle <span
									class="glyphicon glyphicon-list-alt"> </span> </span>
							</h3></th>
						<th class="text-center" style="border:none" ><h3>
								<span class="label label-default">Estado </span>
							</h3></th>
						<th class="text-center" style="border:none" ><h3>
								<span class="label label-default">Borrar </span>
							</h3></th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="compra" items="${compras}">
						<tr>
							<td class="text-center" style="border:none"><h4>
									<span class="label label-success"><fmt:formatDate
											value="${compra.fechaEfectuada }" pattern="dd/MM/yyyy" /></span>
								</h4></td>
							<td class="text-center" style="border:none"><h4>
									<span class="label label-success"><span
										class="glyphicon glyphicon-usd" aria-hidden="true"></span><c:out
											value="${compra.monto }" /></span>
								</h4></td>
							<td class="text-center" style="border:none">
								<div class="btn-group">
									<button type="button" id="idBotonMostrarDetalle${compra.id }"
										class="btn btn-default"
										onclick="mostrarDetalle('${compra.id }')">
										<strong>Mostrar</strong> <span id="idSpanDetalle${compra.id }"
											class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
									</button>
									<button type="button" style="display: none"
										id="idBotonOcultarDetalle${compra.id }"
										class="btn btn-default"
										onclick="ocultarDetalle('${compra.id }')">
										Ocultar <span class="glyphicon glyphicon-eye-close"
											aria-hidden="true"></span>
									</button>
									<ul class="dropdown-menu">
										<li class="dropdown-header">Menues</li>
										<c:forEach var="seleccionDiaMenu"
											items="${compra.selecciones}">
											<li><c:out value="${seleccionDiaMenu.nombre }" /></li>
										</c:forEach>
									</ul>
								</div>
							</td>
							<td class="text-center" style="border:none"><c:choose>
									<c:when test="${compra.pagado}">
										<button type="button" class="btn btn-warning disabled">
											 <strong>Pago</strong> <span
												class="glyphicon glyphicon-saved" aria-hidden="true">
											</span>
										</button>
									</c:when>
									<c:otherwise>
										<form action="${pageContext.request.contextPath}/compra/pagar"
											method="POST">
											<input type="hidden" value="${compra.id }" name="id">
											<button type="submit" class="btn btn-warning ">
												<strong>Pagar</strong> <span class="glyphicon glyphicon-save"
													aria-hidden="true"></span>
											</button>
										</form>
									</c:otherwise>
								</c:choose></td>
							<td class="text-center" style="border:none"><c:choose>
									<c:when test="${compra.pagado}">
										<button type="button" class="btn btn-danger disabled">
											<span class="glyphicon glyphicon-ban-circle"
												aria-hidden="true"></span>
										</button>
									</c:when>
									<c:otherwise>
										<form
											action="${pageContext.request.contextPath}/compra/borrar"
											method="POST">
											<input type="hidden" value="${compra.id }" name="id">
											<button type="submit" class="btn btn-danger ">
												<strong>Borrar</strong> <span class="glyphicon glyphicon-trash"
													aria-hidden="true"></span>
											</button>
										</form>
									</c:otherwise>
								</c:choose></td>
						</tr>
						<div id="idDivCompraDetalle${compra.id }">
							<div id="idCompraDetalle${compra.id }"
								class="col-md-10 col-md-offset-2 "
								style="display: none; position: absolute">
								<div class=" text-center">
									<h3>
										<span class="label label-info">Compra del día <fmt:formatDate
												value="${compra.fechaEfectuada }" pattern="dd/MM/yyyy" /></span>
									</h3>
								</div>
								<div class="text-left">
									<h3>
										<span class="label label-default">Menues</span>
									</h3>
								</div>
								<c:if test="${ compra.cantidadDeSemanas > '1' }">
									<c:forEach var="i" begin="1"
										end="${fn:length(compra.selecciones) / compra.cantidadDeSemanas }">
										<div class="text-center">
											<h4>
												<span class="label label-success"><c:out
														value="${compra.selecciones.get(i-1).nombre }" /></span>
											</h4>
										</div>
									</c:forEach>
								</c:if>
								<c:if test="${ compra.cantidadDeSemanas == '1'}">
									<c:forEach var="seleccionDiaMenu" items="${compra.selecciones}">
										<div class="text-center">
											<h4>
												<span class="label label-success"><c:out
														value="${seleccionDiaMenu.nombre }" /></span>
											</h4>
										</div>
									</c:forEach>

								</c:if>
								<div class="text-left">
									<h3>
										<span class="label label-warning">Cantidad de semanas</span> <span
											class="badge"><c:out
												value="${compra.cantidadDeSemanas }"></c:out></span>
									</h3>
								</div>
							</div>
						</div>
						<!-- </div>
						</div> -->
					</c:forEach>
				</tbody>
			</table>
		</div>
		<a href="${pageContext.request.contextPath}/compra/compraDeTickets"
			class="btn btn-warning" role="button"><strong>Comprar Tickets</strong> <span
				class="glyphicon glyphicon-shopping-cart" aria-hidden="true"> </span></a>
	</div>
	<div id="idDetalleCompra" class="col-md-5">
	
		<div class="col-md-10 col-md-offset-2">
			<c:if test="${not empty error}">
				<div class="alert alert-warning">
					<h3 class="text-center">
						<strong>¡Atenci&oacute;n!</strong>
					</h3>
					<h4 class="text-center">
						<c:out value="${error}"></c:out>
					</h4>
				</div>
			</c:if>
			<c:if test="${not empty mensaje}">
				<div class="alert alert-success">
					<h3 class="text-center">
						<strong>¡Atenci&oacute;n!</strong>
					</h3>
					<h4 class="text-center">
						<c:out value="${mensaje}"></c:out>
					</h4>
				</div>
			</c:if>
		</div>
	</div>

</div>

<script type="text/javascript">
	var ultimoIdcompra = -1;

	function mostrarDetalle(idCompra) {
		if (ultimoIdcompra != -1)
			ocultarDetalle(ultimoIdcompra);
		ultimoIdcompra = idCompra;
		$("#idDetalleCompra").append($("#idCompraDetalle" + idCompra));
		$("#idCompraDetalle" + idCompra).show();
		$("#idBotonMostrarDetalle" + idCompra).hide();
		$("#idBotonOcultarDetalle" + idCompra).show();
	}
	function ocultarDetalle(idCompra) {
		$("#idDivCompraDetalle" + idCompra).append(
				$("#idCompraDetalle" + idCompra));
		$("#idCompraDetalle" + idCompra).hide();
		$("#idBotonOcultarDetalle" + idCompra).hide();
		$("#idBotonMostrarDetalle" + idCompra).show();
		ultimoIdcompra = -1;
	}
	
	$('#tituloDePagina').append('<span class="glyphicon glyphicon-cutlery"></span> Estado de tus compras');
	$('#tituloDePagina').show();
</script>