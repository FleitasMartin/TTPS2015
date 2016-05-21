<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag language="java" pageEncoding="UTF-8"%>

<a href="${pageContext.request.contextPath}/menu/crear"
	class="btn btn-warning" role="button"><strong>Crear Menu</strong> <span
	class="glyphicon glyphicon-cog"></span></a>

<div class="col-md-offset-1 col-md-12 text-center">
	<div class="row">
		<div class="col-md-3">
			<h3>
				<span class="label label-default">Nombre</span>
			</h3>
		</div>
		<div class="col-md-2">
			<h3>
				<span class="label label-default">Detalle</span>
			</h3>
		</div>
		<div class="col-md-2">
			<h3>
				<span class="label label-default">Modificar</span>
			</h3>
		</div>
		<div class="col-md-2">
			<h3>
				<span class="label label-default">Borrar</span>
			</h3>
		</div>

	</div>

	<c:forEach var="menu" items="${menues}">
		<div class="row text-center">
			<div class="col-md-3">
				<h4>
					<span class="label label-success"><c:out
							value="${menu.nombre }" /></span>
				</h4>
			</div>

			<div class="col-md-2">
				<button type="button" class="btn btn-default" data-toggle="modal"
					data-target="#idMenu${menu.id}">
					<strong>Mostrar</strong> <span class="glyphicon glyphicon-eye-open"></span>
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
								<c:forEach var="caracteristica" items="${menu.caracteristica}">

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

			</div>

			<div class="col-md-2">
				<form action="${pageContext.request.contextPath}/menu/editar"
					method="GET">
					<input type="hidden" value="${menu.id }" name="id">
					<button type="submit" class="btn btn-warning">
						<span class="glyphicon glyphicon-pencil"></span>
					</button>
				</form>
			</div>
			<div class="col-md-2">
				<form action="${pageContext.request.contextPath}/menu/eliminar"
					method="POST">
					<input type="hidden" value="${menu.id }" name="id">
					<button type="submit" class="btn btn-danger">
						<span class="glyphicon glyphicon-trash"></span>
					</button>
				</form>
			</div>
		</div>
	</c:forEach>




</div>

<script type="text/javascript">
	$('#tituloDePagina')
			.append(
					'<span class="glyphicon glyphicon-list"></span> Listado de men&uacute;es del comedor');
	$('#tituloDePagina').show();
</script>