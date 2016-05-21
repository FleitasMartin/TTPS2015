<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag language="java" pageEncoding="UTF-8"%>

<a href="${pageContext.request.contextPath}/componente/crear"
	class="btn btn-warning" role="button"><strong>Crear
		Componente</strong> <span class="glyphicon glyphicon-cog"></span></a>

<div class="col-md-8 col-md-offset-2 ">
	<div class="col-md-2">
		<div class="btn btn-primary disabled" id="botonPlatos"
			onclick="toggle('#divPlatos','#botonPlatos')"><strong>Platos</strong></div>
	</div>
	<div class="col-md-2">
		<div class="btn btn-primary" id="botonEntradas"
			onclick="toggle('#divEntradas','#botonEntradas')"><strong>Entradas</strong></div>
	</div>
	<div class="col-md-2">
		<div class="btn btn-primary" id="botonPostres"
			onclick="toggle('#divPostres','#botonPostres')"><strong>Postres</strong></div>
	</div>
	<div class="col-md-2">
		<div class="btn btn-primary" id="botonBebidas"
			onclick="toggle('#divBebidas','#botonBebidas')"><strong>Bebidas</strong></div>
	</div>
</div>

<div class="col-md-12 text-center" id="divContenedor">
	<div class="col-md-7 col-md-offset-2" style="display: none"
		id="divBebidas">
		<div class="well">
			<div class="row">
				<div class="col-md-4">
					<h3>
						<span class="label label-default">Nombre</span>
					</h3>
				</div>
				<div class="col-md-4">
					<h3>
						<span class="label label-default">Modificar</span>
					</h3>
				</div>
				<div class="col-md-4">
					<h3>
						<span class="label label-default">Borrar</span>
					</h3>
				</div>
			</div>
			<c:forEach var="componente" items="${componentes}">
				<c:if test="${componente.tipo == 'bebida'}">

					<div class="row">
						<div class="col-md-4">
							<h4>
								<span class="label label-success"><c:out
										value="${componente.nombre }" /></span>
							</h4>
						</div>
						<div class="col-md-4">

							<form
								action="${pageContext.request.contextPath}/componente/editar"
								method="GET">
								<input type="hidden" value="${componente.id }" name="id">

								<button type="submit" class="btn btn-warning">
									<span class="glyphicon glyphicon-pencil"></span>
								</button>

							</form>

						</div>
						<div class="col-md-4">

							<form
								action="${pageContext.request.contextPath}/componente/eliminar"
								method="POST">
								<input type="hidden" value="${componente.id }" name="id">

								<button type="submit" class="btn btn-danger">
									<span class="glyphicon glyphicon-trash"></span>
								</button>

							</form>

						</div>
					</div>

				</c:if>
			</c:forEach>
		</div>
	</div>

	<div class="col-md-7 col-md-offset-2" style="display: none"
		id="divEntradas">

		<div class="well">
			<div class="row">
				<div class="col-md-4">
					<h3>
						<span class="label label-default">Nombre</span>
					</h3>
				</div>
				<div class="col-md-4">
					<h3>
						<span class="label label-default">Modificar</span>
					</h3>
				</div>
				<div class="col-md-4">
					<h3>
						<span class="label label-default">Borrar</span>
					</h3>
				</div>
			</div>
			<c:forEach var="componente" items="${componentes}">
				<c:if test="${componente.tipo == 'entrada'}">
					<div class="row">
						<div class="col-md-4">
							<h4>
								<span class="label label-success"><c:out
										value="${componente.nombre }" /></span>
							</h4>
						</div>
						<div class="col-md-4">
							<form
								action="${pageContext.request.contextPath}/componente/editar"
								method="GET">
								<input type="hidden" value="${componente.id }" name="id">
								<button type="submit" class="btn btn-warning">
									<span class="glyphicon glyphicon-pencil"></span>
								</button>
							</form>
						</div>
						<div class="col-md-4">
							<form
								action="${pageContext.request.contextPath}/componente/eliminar"
								method="POST">
								<input type="hidden" value="${componente.id }" name="id">
								<button type="submit" class="btn btn-danger">
									<span class="glyphicon glyphicon-trash"></span>
								</button>
							</form>
						</div>
					</div>
				</c:if>
			</c:forEach>
		</div>
	</div>

	<div class="col-md-7 col-md-offset-2" id="divPlatos">

		<div class="well">
			<div class="row">
				<div class="col-md-4">
					<h3>
						<span class="label label-default">Nombre</span>
					</h3>
				</div>
				<div class="col-md-4">
					<h3>
						<span class="label label-default">Modificar</span>
					</h3>
				</div>
				<div class="col-md-4">
					<h3>
						<span class="label label-default">Borrar</span>
					</h3>
				</div>
			</div>
			<c:forEach var="componente" items="${componentes}">
				<c:if test="${componente.tipo == 'plato'}">
					<div class="row">
						<div class="col-md-4">
							<h4>
								<span class="label label-success"><c:out
										value="${componente.nombre }" /></span>
							</h4>
						</div>
						<div class="col-md-4">
							<form
								action="${pageContext.request.contextPath}/componente/editar"
								method="GET">
								<input type="hidden" value="${componente.id }" name="id">
								<button type="submit" class="btn btn-warning">
									<span class="glyphicon glyphicon-pencil"></span>
								</button>
							</form>
						</div>
						<div class="col-md-4">
							<form
								action="${pageContext.request.contextPath}/componente/eliminar"
								method="POST">
								<input type="hidden" value="${componente.id }" name="id">
								<button type="submit" class="btn btn-danger">
									<span class="glyphicon glyphicon-trash"></span>
								</button>
							</form>
						</div>
					</div>
				</c:if>
			</c:forEach>
		</div>
	</div>

	<div class="col-md-7 col-md-offset-2" style="display: none"
		id="divPostres">

		<div class="well">
			<div class="row">
				<div class="col-md-4">
					<h3>
						<span class="label label-default">Nombre</span>
					</h3>
				</div>
				<div class="col-md-4">
					<h3>
						<span class="label label-default">Modificar</span>
					</h3>
				</div>
				<div class="col-md-4">
					<h3>
						<span class="label label-default">Borrar</span>
					</h3>
				</div>
			</div>
			<c:forEach var="componente" items="${componentes}">
				<c:if test="${componente.tipo == 'postre'}">
					<div class="row">
						<div class="col-md-4">
							<h4>
								<span class="label label-success"><c:out
										value="${componente.nombre }" /></span>
							</h4>
						</div>
						<div class="col-md-4">
							<form
								action="${pageContext.request.contextPath}/componente/editar"
								method="GET">
								<input type="hidden" value="${componente.id }" name="id">
								<button type="submit" class="btn btn-warning">
									<span class="glyphicon glyphicon-pencil"></span>
								</button>
							</form>
						</div>
						<div class="col-md-4">
							<form
								action="${pageContext.request.contextPath}/componente/eliminar"
								method="POST">
								<input type="hidden" value="${componente.id }" name="id">
								<button type="submit" class="btn btn-danger">
									<span class="glyphicon glyphicon-trash"></span>
								</button>
							</form>
						</div>
					</div>
				</c:if>
			</c:forEach>
		</div>
	</div>

</div>

<script type="text/javascript">
	$('#tituloDePagina')
			.append(
					'<span class="glyphicon glyphicon-list"></span> Listado de componentes del comedor');
	$('#tituloDePagina').show();
</script>
<script type="text/javascript">
	var divMostrado = "#divPlatos";
	var botonDesactivado = "#botonPlatos";

	function toggle(idDivParaMostrar, divBoton) {
		ocultarDiv(divMostrado);
		$(idDivParaMostrar).show();
		$(divBoton).addClass('disabled');
		divMostrado = idDivParaMostrar;
		botonDesactivado = divBoton;
	}

	function ocultarDiv(idDivOcultar) {
		$(idDivOcultar).hide();
		$(botonDesactivado).removeClass('disabled');
	}
</script>
