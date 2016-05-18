<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag language="java" pageEncoding="UTF-8"%>

<div class="col-md-12 ">

	<div class="row">
		<div class="col-md-2">
			<h2>
				<span class="label label-default">DNI</span>
			</h2>
		</div>
		<div class="col-md-4">
			<h2>
				<span class="label label-default">Nombre completo</span>
			</h2>
		</div>
		<div class="col-md-6">
			<h2>
				<span class="label label-default">Email</span>
			</h2>
		</div>
	</div>

	<c:forEach var="usuario" items="${usuarios}">
		<div class="row">
			<div class="col-md-2">
				<h3>
					<span class="label label-success"><c:out
							value="${usuario.dni }" /></span>
				</h3>
			</div>
			<div class="col-md-4">
				<h3>
					<span class="label label-success"><c:out
							value="${usuario.nombre }" /> <c:out
							value="${usuario.apellido }" /></span>
				</h3>
			</div>
			<div class="col-md-6">
				<h3>
					<span class="label label-success"><c:out
							value="${usuario.email }" /></span>
				</h3>
			</div>
		</div>

	</c:forEach>
</div>
<script type="text/javascript">
	$('#tituloDePagina')
			.append(
					'<span class="glyphicon glyphicon-user"></span> Usuarios habilitados a comprar tickets');
	$('#tituloDePagina').show();
</script>