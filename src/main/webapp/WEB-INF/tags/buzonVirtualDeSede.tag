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
	var sede = $('#idNombreSede').val();
	var texto = '';
	if (sede.length == 0)
		texto = 'No hay sugerencias para esta sede'
	else
		texto = '<span class="glyphicon glyphicon-comment"></span> Sugerencias para la sede '
				+ '${sugerencias[0].sede.nombre}';
	$('#tituloDePagina').append(texto);
	$('#tituloDePagina').show();
</script>