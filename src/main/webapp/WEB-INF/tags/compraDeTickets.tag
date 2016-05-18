<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ tag language="java" pageEncoding="UTF-8"%>


<div class="container-fluid">

	<form method="POST"
		action="${pageContext.request.contextPath}/compra/crear">

		<div class="row col-md-11">
			<div class="form-group col-md-3 col-md-offset-1">
				<h4>
					<label><span class="label label-default"> Cantidad
							de Semanas </span></label>
				</h4>
				<select class="form-control" name="cantidadSemanas">
					<c:forEach var="i" begin="1" end="${cantidad }">
						<option value="${i}"><c:out value="${i}" /></option>
					</c:forEach>
				</select>
			</div>

			<div class="form-group col-md-2">
				<h4>
					<label><span class="label label-default"> Precio </span></label>
				</h4>
				<input type="hidden" value="${cartilla.precio }" name="precio"
					id="precioDeCartilla">
				<h3 style="margin-top:1%">
					<span class="label label-success"> <span
						class="glyphicon glyphicon-usd" aria-hidden="true"></span> <strong
						id="precio"> 0 </strong>
					</span>
				</h3>
			</div>

			<div class="form-group col-md-3">
				<input type="hidden"
					value="<fmt:formatDate value="${semana.fechaDesde }" pattern="MM/dd/yyyy"/>"
					name="fechaDesde">
				<h4>
					<label><span class="label label-default"> Sede </span></label>
				</h4>
				<h3 style="margin-top:1%">
					<span class="label label-success"> <strong><c:out
								value="${sede.nombre }" /></strong> <input type="hidden"
						value="${sede.id }" name="sede">
					</span>
				</h3>
			</div>

			<div class="form-group col-md-2">
				<button type="submit" class="form-control btn btn-warning">
					<strong>Comprar</strong> <span
						class="glyphicon glyphicon-shopping-cart" aria-hidden="true">
					</span>
				</button>
			</div>

		</div>

		<c:forEach var="dia" items="${semana.dias}">

			<div class="row col-md-12">
				<div class="col-md-8">

					<div class="col-md-12">
						<div class="panel panel-success">
							<div class="panel-heading text-center">
								<div class="button-group">
									<h4>
										<c:out value="${dia.nombre }" />
										<button type="button"
											id="idBotonMostrarPanelBody${dia.nombre }"
											class="btn btn-default"
											onclick="$('#idPanelBody${dia.nombre}').toggle();$('#idIconoDia${dia.nombre }').toggleClass('glyphicon-collapse-down').toggleClass('glyphicon-collapse-up')">
											<span id="idIconoDia${dia.nombre }"
												class="glyphicon glyphicon-collapse-down"></span>
										</button>
									</h4>
								</div>
							</div>
							<div class="panel-body" id="idPanelBody${dia.nombre }"
								style="display: none">
								<table class="table col-md-12">
									<thead>
										<tr>
											<th class="col-md-2">Elegir</th>
											<th class="col-md-4">Nombre menu</th>
											<th class="col-md-3">¿Para llevar?</th>
											<th class="col-md-3 text-center">Detalle <span
												class="glyphicon glyphicon-list-alt"></span></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="menu" items="${dia.menues}">
											<tr>
												<td>
													<button type="button"
														id="idBotonLimpio${dia.nombre }${menu.id }"
														class="btn btn-default"
														onclick="chequearBoton('${dia.nombre }','${menu.id }', true)">
														<span id="idIconoCheckMenu${dia.nombre }${menu.id}"
															class="glyphicon glyphicon-unchecked"></span>
													</button>
													<button type="button" style="display: none"
														id="idBotonChequeado${dia.nombre }${menu.id }"
														class="btn btn-default"
														onclick="chequearBoton('${dia.nombre }','${menu.id }', false)">
														<span id="idIconoCheckMenu${dia.nombre }${menu.id}"
															class="glyphicon glyphicon-check"></span>
													</button> <input type="checkbox"
													id="idCheckButton${dia.nombre}${menu.id}"
													name="${dia.nombre}" value="${menu.id }"
													style="display: none"> <!--<input type="hidden" name="${dia.nombre}"
													value="${menu.id }">-->
												</td>
												<td><c:out value="${menu.nombre}" /> <input
													type="hidden"
													value="<fmt:formatDate value="${dia.fecha}" pattern="MM/dd/yyyy"/>"
													name="fecha${dia.nombre }" /></td>
												<td><select class="form-control"
													name="seleccionVianda${dia.nombre}">
														<option value="1">Si</option>
														<option value="0">No</option>
												</select></td>
												<td>
													<div class="btn-group">
														<button type="button"
															id="idBotonMostrarDetalle${menu.id }${dia.id }"
															class="btn btn-default"
															onclick="mostrarDetalle('${menu.id }${dia.id }','idDiaDiv${dia.id }')">
															Mostrar <span class="glyphicon glyphicon-eye-open"
																aria-hidden="true"></span>
														</button>
														<button type="button" style="display: none"
															id="idBotonOcultarDetalle${menu.id }${dia.id }"
															class="btn btn-default"
															onclick="ocultarDetalle('${menu.id }${dia.id }')">
															Ocultar <span class="glyphicon glyphicon-eye-close"
																aria-hidden="true"></span>
														</button>
													</div>
													<div id="idDivMenuDetalle${menu.id }${dia.id }">
														<div id="idMenuDetalle${menu.id }${dia.id }"
															class="panel panel-success"
															style="display: none; position: absolute">
															<div class="panel-heading text-center">
																<h4>Detalle</h4>
															</div>
															<div class="panel-body">
																<ul class="list-group">
																	<li class="list-group-item text-center disabled">Componentes</li>
																	<c:forEach var="componente" items="${menu.componentes}">
																		<li class="list-group-item text-center"><c:out
																				value="${componente.tipo }" />: <c:out
																				value="${componente.nombre }" /></li>
																	</c:forEach>
																</ul>
																<ul class="list-group">
																	<li class="list-group-item text-center disabled">Caracter&iacute;sticas</li>
																	<c:forEach var="carac" items="${menu.caracteristica}">
																		<li class="list-group-item text-center"><c:out
																				value="${carac.nombre }" /></li>
																	</c:forEach>

																</ul>
															</div>

														</div>
													</div>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>

					</div>

				</div>
				<div id="idDiaDiv${dia.id }" class="col-md-4"></div>
			</div>
		</c:forEach>

	</form>


</div>

<script type="text/javascript">
	var ultimoIdMenuSemana = -1;
	var ultimoIdDiaDiv = -1;

	var precio = 0;

	function mostrarDetalle(idMenuSemana, idDiaDiv) {
		if (ultimoIdDiaDiv != -1)
			ocultarDetalle(ultimoIdMenuSemana);
		ultimoIdMenuSemana = idMenuSemana;
		ultimoIdDiaDiv = idDiaDiv;
		$("#" + idDiaDiv).append($("#idMenuDetalle" + idMenuSemana));
		$("#idMenuDetalle" + idMenuSemana).show();
		$("#idBotonMostrarDetalle" + idMenuSemana).hide();
		$("#idBotonOcultarDetalle" + idMenuSemana).show();
	}

	function ocultarDetalle(idMenuSemana) {
		$("#idDivMenuDetalle" + idMenuSemana).append(
				$("#idMenuDetalle" + idMenuSemana));
		$("#idMenuDetalle" + idMenuSemana).hide();
		$("#idBotonOcultarDetalle" + idMenuSemana).hide();
		$("#idBotonMostrarDetalle" + idMenuSemana).show();
		ultimoIdDiaDiv = -1;
	}

	function chequearBoton(diaNombre, menuId, checkBoolean) {
		$('#idBotonLimpio' + diaNombre + menuId).toggle();
		$('#idBotonChequeado' + diaNombre + menuId).toggle();
		$('#idCheckButton' + diaNombre + menuId).prop('checked', checkBoolean);
		(checkBoolean) ? incrementarPrecio() : reducirPrecio();
		$('#precio').empty();
		$('#precio').append(precio);
	}

	function incrementarPrecio() {
		precio += Number($('#precioDeCartilla').val());
	}

	function reducirPrecio() {
		precio -= Number($('#precioDeCartilla').val());
	}

	$('#tituloDePagina')
			.append(
					'<span class="glyphicon glyphicon-calendar"></span> Comprando tickets');
	$('#tituloDePagina').show();
</script>
