<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag language="java" pageEncoding="UTF-8"%>

<a href="${pageContext.request.contextPath}/admin/crear"
	class="btn btn-warning" role="button"><strong>Crear
		Administrador</strong> <span class="glyphicon glyphicon-cog"></span></a>

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
		<div class="col-md-2">
			<h3>
				<span class="label label-default">M&aacute;s datos</span>
			</h3>
		</div>
		<div class="col-md-2">
			<h3>
				<span class="label label-default">Modificar</span>
			</h3>
		</div>
		<div class="col-md-1">
			<h3>
				<span class="label label-default">Borrar</span>
			</h3>
		</div>
	</div>
</div>


<c:forEach var="admin" items="${admins}">
	<div class="row text-center">
		<div class="col-md-2">
			<h4>
				<span class="label label-success"><c:out
						value="${admin.dni }" /></span>
			</h4>
		</div>

		<div class="col-md-3">
			<h4>
				<span class="label label-success"> <c:out
						value="${admin.nombre }" /> <c:out
						value="${admin.apellido }" /></span>
			</h4>
		</div>
		<div class="col-md-2">
			<button type="button" class="btn btn-default" data-toggle="modal"
				data-target="#idAdmin${admin.id}">
				<strong>Mostrar</strong> <span class="glyphicon glyphicon-eye-open"></span>
			</button>

			<!-- Modal -->
			<div class="modal fade" id="idAdmin${admin.id}"
				role="dialog">
				<div class="modal-dialog">
					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header text-center">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">
								Detalle del administrador <span class="label label-success"><c:out
										value="${admin.nombre }" /> <c:out
										value="${admin.apellido }" /></span> con D.N.I. <span
									class="label label-success"><c:out
										value="${admin.dni }" /> </span>

							</h4>
						</div>
						<div class="modal-body text-center">
							<div class="row">
								<div class="col-md-4">
									<h4>
										<span class="label label-default">Email</span>
									</h4>
								</div>
								<div class="col-md-6">
									<h4>
										<span class="label label-success"><c:out
												value="${admin.email }" /></span>
									</h4>
								</div>
							</div>

							<div class="row">
								<div class="col-md-4">
									<h4>
										<span class="label label-default">Tel&eacute;fono</span>
									</h4>
								</div>
								<div class="col-md-6">
									<h4>
										<span class="label label-success"><c:out
												value="${admin.telefono }" /></span>
									</h4>
								</div>
							</div>

							<div class="row">
								<div class="col-md-4">
									<h4>
										<span class="label label-default">Domicilio</span>
									</h4>
								</div>
								<div class="col-md-6">
									<h4>
										<span class="label label-success"><c:out
												value="${admin.domicilio }" /></span>
									</h4>
								</div>
							</div>

						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-warning"
								data-dismiss="modal">Cerrar</button>
						</div>
					</div>
				</div>
			</div>

		</div>
		<div class="col-md-2">
			<form
				action="${pageContext.request.contextPath}/admin/editarAdmin"
				method="GET">
				<input type="hidden" value="${admin.id }" name="id">
				<button type="submit" class="btn btn-warning">
					<span class="glyphicon glyphicon-pencil"></span>
				</button>
			</form>
		</div>
		<div class="col-md-1">
			<form
				action="${pageContext.request.contextPath}/admin/eliminarAdmin"
				method="POST">
				<input type="hidden" value="${admin.id }" name="id">
				<button type="submit" class="btn btn-danger">
					<span class="glyphicon glyphicon-trash"></span>
				</button>
			</form>
		</div>
	</div>
</c:forEach>


<script type="text/javascript">
	$('#tituloDePagina')
			.append(
					'<span class="glyphicon glyphicon-user"></span> Listado de administradores del comedor');
	$('#tituloDePagina').show();
</script>