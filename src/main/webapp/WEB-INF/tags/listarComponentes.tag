<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag language="java" pageEncoding="UTF-8"%>

<a href="${pageContext.request.contextPath}/componente/crear"
	class="btn btn-warning" role="button"><strong>Crear Componente</strong> <span class="glyphicon glyphicon-cog"></span></a>
<div class="col-md-12 text-center">

	<div class="col-md-6 ">
		<h2>
			<span class="label label-info">Bebidas</span>
		</h2>
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
					<span class="label label-default">Eliminar</span>
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

	<div class="col-md-6">
		<h2>
			<span class="label label-info">Entradas</span>
		</h2>
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
					<span class="label label-default">Eliminar</span>
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
<div class="col-md-12 text-center" style="margin-top:1%">

	<div class="col-md-6">
		<h2>
			<span class="label label-info">Platos</span>
		</h2>
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
					<span class="label label-default">Eliminar</span>
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

	<div class="col-md-6">
		<h2>
			<span class="label label-info">Postres</span>
		</h2>
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
					<span class="label label-default">Eliminar</span>
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

<script type="text/javascript">
	$('#tituloDePagina')
			.append(
					'<span class="glyphicon glyphicon-list"></span> Listado de componentes del comedor');
	$('#tituloDePagina').show();
</script>
