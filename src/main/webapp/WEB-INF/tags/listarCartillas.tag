<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ tag language="java" pageEncoding="UTF-8"%>

<a href="${pageContext.request.contextPath}/cartilla/crear"
	class="btn btn-warning" role="button"><strong>Crear
		Cartilla</strong> <span class="glyphicon glyphicon-cog"></span></a>

<div class="row text-center">

	<div class="col-md-2">
		<h3>
			<span class="label label-default">Desde</span>
		</h3>
	</div>
	<div class="col-md-2">
		<h3>
			<span class="label label-default">Hasta</span>
		</h3>
	</div>
	<div class="col-md-2">
		<h3>
			<span class="label label-default">Precio</span>
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

<c:forEach var="cartilla" items="${cartillas}">

	<div class="row text-center">
		<div class="col-md-2">
			<h4>
				<span class="label label-success"><fmt:formatDate
						value="${cartilla.fechaInicio}" pattern="dd/MM/yyyy" /></span>
			</h4>
		</div>
		<div class="col-md-2">
			<h4>
				<span class="label label-success"><fmt:formatDate
						value="${cartilla.fechaFin}" pattern="dd/MM/yyyy" /></span>
			</h4>
		</div>
		<div class="col-md-2">
			<h4>
				<span class="label label-success"><c:out
						value="${cartilla.precio }" /></span>
			</h4>
		</div>
		<div class="col-md-2">
			<form action="${pageContext.request.contextPath}/cartilla/detalle"
				method="GET">
				<input type="hidden" value="${cartilla.id }" name="id">
				<button type="submit" class="btn btn-default">
					<strong>Mostrar</strong> <span class="glyphicon glyphicon-new-window"></span>
				</button>
			</form>
		</div>
		<div class="col-md-2">
			<form action="${pageContext.request.contextPath}/cartilla/editar"
				method="GET">
				<input type="hidden" value="${cartilla.id }" name="id">
				<button type="submit" class="btn btn-warning">
					<span class="glyphicon glyphicon-pencil"></span>
				</button>
			</form>
		</div>
		<div class="col-md-2">
			<form action="${pageContext.request.contextPath}/cartilla/eliminar"
				method="POST">
				<input type="hidden" value="${cartilla.id }" name="id">
				<button type="submit" class="btn btn-danger botondelete">
					<span class="glyphicon glyphicon-trash"></span>
				</button>
			</form>
		</div>

	</div>

</c:forEach>

<script type="text/javascript">
	$('#tituloDePagina')
			.append(
					'<span class="glyphicon glyphicon-list"></span> Listado de cartillas del comedor');
	$('#tituloDePagina').show();
</script>