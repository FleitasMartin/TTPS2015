<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag language="java" pageEncoding="UTF-8"%>

<div class="row">
	<div class="col-md-2">
		<a href="${pageContext.request.contextPath}/cartilla/listar"
			class="btn btn-default" role="button"><strong>Volver</strong> <span
			class="glyphicon glyphicon-circle-arrow-left"></span></a>
	</div>
	<div class="col-md-2">
		<form action="${pageContext.request.contextPath}/cartilla/editar"
			method="GET">
			<input type="hidden" value="${id}" name="id">
			<button type="submit" class="btn btn-warning">
				<strong>Modificar</strong> <span class="glyphicon glyphicon-pencil"></span>
			</button>
		</form>
	</div>
	<div class="col-md-1">
		<form action="${pageContext.request.contextPath}/cartilla/eliminar"
			method="POST">
			<input type="hidden" value="${id}" name="id">
			<button type="submit" class="btn btn-danger botondelete">
				<strong>Borrar</strong> <span class="glyphicon glyphicon-trash"></span>
			</button>
		</form>
	</div>
</div>

<div class="row text-center" style="margin-top: 1%">

	<c:forEach var="dia" items="${semana.dias}">

		<div class="col-md-3">
			<div class="panel panel-success">
				<div class="panel-heading">
					<h4>
							<strong><c:out value="${dia.nombre }" /></strong>
						</h4>
				</div>
				<div class="panel-body">

					<c:forEach var="menu" items="${dia.menues}">

						<div class="row">

							<div class="col-md-6">
								<h4>
									<span class="label label-success"><c:out
											value="${menu.nombre }" /></span>
								</h4>
							</div>
							<div class="col-md-6">

								<button type="button" class="btn btn-default"
									data-toggle="modal" data-target="#idMenu${menu.id}">
									<span class="glyphicon glyphicon-eye-open"></span>
								</button>

								<!-- Modal -->
								<div class="modal fade" id="idMenu${menu.id}" role="dialog">
									<div class="modal-dialog">
										<!-- Modal content-->
										<div class="modal-content">
											<div class="modal-header text-center">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4 class="modal-title">
													Detalle del menu <span class="label label-success"><c:out
															value="${menu.nombre }" /></span>
												</h4>
											</div>
											<div class="modal-body text-center">
												<div class="row">
													<h3>
														<span class="label label-default">Componentes</span>
													</h3>
												</div>
												<c:forEach var="componente" items="${menu.componentes}">

													<div class="row">
														<div class="col-md-6 col-md-offset-3">
															<h4>
																<span class="label label-success"><c:out
																		value="${componente.nombre }" /></span>
															</h4>
														</div>
													</div>

												</c:forEach>
												<div class="row">
													<h3>
														<span class="label label-default">Caracter&iacute;sticas</span>
													</h3>
												</div>
												<c:forEach var="caracteristica"
													items="${menu.caracteristica}">

													<div class="row">
														<div class="col-md-6 col-md-offset-3">
															<h4>
																<span class="label label-success"><c:out
																		value="${caracteristica.nombre }" /></span>
															</h4>
														</div>
													</div>

												</c:forEach>

											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-warning"
													data-dismiss="modal">Cerrar</button>
											</div>

										</div>
										<!-- Fin modal content -->
									</div>
								</div>
								<!-- Fin modal -->
							</div>

						</div>
					</c:forEach>

				</div>
			</div>
		</div>
	</c:forEach>
</div>



<script type="text/javascript">
	$('#tituloDePagina')
			.append(
					'<span class="glyphicon glyphicon-list"></span> Detalles de la cartilla');
	$('#tituloDePagina').show();
</script>


<!-- <div class="row"> -->

<%-- 	<c:forEach var="dia" items="${semana.dias}"> --%>
<!-- 		<div class="col-xs-6 col-md-2"> -->
<!-- 			<div class="panel panel-success"> -->
<!-- 				<div class="panel-heading"> -->
<!-- 					<label><h4> -->
<%-- 							<c:out value="${dia.nombre }" /> --%>
<!-- 						</h4></label> -->
<!-- 				</div> -->
<!-- 				<div class="panel-body"> -->
<!-- 					<div class="table"> -->
<!-- 						<table> -->
<%-- 							<c:forEach var="menu" items="${dia.menues}"> --%>
<!-- 								<tr> -->
<%-- 									<td><c:out value="${menu.nombre }" /></a> --%>
<!-- 										<div class="btn-group"> -->
<!-- 											<button type="button" class="btn btn-default dropdown-toggle" -->
<!-- 												data-toggle="dropdown" aria-haspopup="true" -->
<!-- 												aria-expanded="false"> -->
<!-- 												Detalle <span class="caret"></span> -->
<!-- 											</button> -->
<!-- 											<ul class="dropdown-menu"> -->
<!-- 												<li class="dropdown-header">Componentes</li> -->
<%-- 												<c:forEach var="componente" items="${menu.componentes}"> --%>
<%-- 													<li><c:out value="${componente.nombre }" /></li> --%>
<%-- 												</c:forEach> --%>

<!-- 												<li class="dropdown-header">Caracteristicas</li> -->
<%-- 												<c:forEach var="carac" items="${menu.caracteristica}"> --%>
<%-- 													<li><c:out value="${carac.nombre }" /></li> --%>
<%-- 												</c:forEach> --%>
<!-- 											</ul> -->
<!-- 										</div></td> -->
<!-- 								</tr> -->
<%-- 							</c:forEach> --%>
<!-- 						</table> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
<%-- 	</c:forEach> --%>
<!-- 	<div class="col-xs-6 col-md-1"></div> -->
<!-- </div> -->

<%-- <form action="${pageContext.request.contextPath}/cartilla/editar" --%>
<!-- 	method="GET"> -->
<%-- 	<input type="hidden" value="${id}" name="id"> <input --%>
<!-- 		type="submit" class="btn btn-warning" value="Modificar" /> -->
<!-- </form> -->

<%-- <form action="${pageContext.request.contextPath}/cartilla/eliminar" --%>
<!-- 	method="POST"> -->
<%-- 	<input type="hidden" value="${id}" name="id"> <input --%>
<!-- 		type="submit" class="btn btn-danger botondelete" value="Eliminar" /> -->
<!-- </form> -->

<%-- <a href="${pageContext.request.contextPath}/cartilla/listar" --%>
<!-- class="btn btn-primary" role="button">Volver -->
<!-- </a> -->