<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<c:choose>
	<c:when test="${!empty sugerencias}">
		<input type="hidden" id="idNombreSede"
			value="{sugerencias[0].sede.nombre}">

		<div class="col-md-12 text-center">
			<div class="row">
				<div class="col-md-2">
					<h3>
						<span class="label label-default">D.N.I.</span>
					</h3>
				</div>
				<div class="col-md-3">
					<h3>
						<span class="label label-default">Nombre</span>
					</h3>
				</div>
				<div class="col-md-3">
					<h3>
						<span class="label label-default">Acerca de</span>
					</h3>
				</div>
				<div class="col-md-4">
					<h3>
						<span class="label label-default">Contenido</span>
					</h3>
				</div>
			</div>

			<c:forEach var="sugerencia" items="${sugerencias}">
				<div class="row">
					<div class="col-md-2">
						<h4>
							<span class="label label-success"><c:out
									value="${sugerencia.usuario.dni }" /></span>
						</h4>
					</div>
					<div class="col-md-3">
						<h4>
							<span class="label label-success"><c:out
									value="${sugerencia.usuario.nombre }" /> <c:out
									value="${sugerencia.usuario.apellido }" /></span>
						</h4>
					</div>
					<div class="col-md-3">
						<h4>
							<span class="label label-success"><c:out
									value="${sugerencia.tipo }" /> </span>
						</h4>
					</div>
					<div class="col-md-4">
						<button type="button" class="btn btn-default" data-toggle="modal"
							data-target="#idSugerencia${sugerencia.id}">
							<strong>Abrir</strong> <span class="glyphicon glyphicon-eye-open"></span>
						</button>

						<!-- Modal -->
						<div class="modal fade" id="idSugerencia${sugerencia.id}"
							role="dialog">
							<div class="modal-dialog">
								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header text-center">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">
											Sugerencia de <span class="label label-success"><c:out
													value="${sugerencia.usuario.nombre }" /> <c:out
													value="${sugerencia.usuario.apellido }" /></span> sobre <span
												class="label label-success"><c:out
													value="${sugerencia.tipo }" /> </span>

										</h4>
									</div>
									<div class="modal-body">
										<p>${sugerencia.mensaje }</p>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-warning"
											data-dismiss="modal">Cerrar</button>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>

			</c:forEach>

		</div>
	</c:when>
	<c:when test="${empty sugerencias}">
		<input type="hidden" id="idNombreSede" value="">
	</c:when>
</c:choose>

<script type="text/javascript">
	$('#tituloDePagina')
			.append(
					'<span class="glyphicon glyphicon-comment"></span> Buz&oacute;n general del comedor');
	$('#tituloDePagina').show();
</script>

<!-- <div> -->
<!-- 	<table class="table"> -->
<!-- 		<tr> -->
<!-- 			<th>Usuario</th> -->
<!-- 			<th>Sugerencia</th> -->
<!-- 			<td>Sede</td> -->
<!-- 			<td>Detalle</td> -->
<!-- 		</tr> -->
<%-- 		<c:forEach var="sugerencia" items="${sugerencias}"> --%>
<!-- 			<tr> -->
<%-- 				<td><c:out value="${sugerencia.usuario.nombre }" /></td> --%>
<%-- 				<td><c:out value="${sugerencia.tipo }" /></td> --%>
<%-- 				<td><c:out value="${sugerencia.sede.nombre }" /> --%>
<%-- 					<c:if test="${empty sugerencia.sede}"> --%>
<!-- 				General -->
<%-- 				</c:if></td> --%>
<!-- 				<td> -->
<!-- 					<div class="btn-group"> -->
<!-- 						<button type="button" class="btn btn-default dropdown-toggle" -->
<!-- 							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> -->
<!-- 							Detalle <span class="caret"></span> -->
<!-- 						</button> -->
<!-- 						<ul class="dropdown-menu"> -->
<!-- 							<li class="dropdown-header">Detalle</li> -->
<%-- 							<li><c:out value="${sugerencia.mensaje}" /></li> --%>
<!-- 						</ul> -->
<!-- 					</div> -->
<!-- 				</td> -->
<!-- 			</tr> -->
<%-- 		</c:forEach> --%>

<!-- 	</table> -->
<!-- </div> -->