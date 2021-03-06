<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="form">
	<form method="post" action="${pageContext.request.contextPath}/responsable/editarResponsable">
	<input type="hidden" value="${responsable.id }" name="id">
		<div class="form-group">
			<label>Nombre</label> <input type="text" name="nombre"
				class="form-control" value="${responsable.nombre }" /><br>
		</div>
		<div class="form-group">
			<label>Apellido</label> <input type="text" name="apellido"
				class="form-control" value="${responsable.apellido }" /><br>
		</div>
		<div class="form-group">
			<label>Telefono</label> <input type="text" name="telefono"
				class="form-control" value="${responsable.telefono }" /><br>
		</div>
		<div class="form-group">
			<label>Email</label> <input type="email" name="email"
				class="form-control" value="${responsable.email }" /><br>
		</div>
		<div class="form-group">
			<label>Domicilio</label> <input type="text" name="domicilio"
				class="form-control" value="${responsable.domicilio }" /><br>
		</div>
		<div class="form-group">
		<label>Sede</label> <select class="form-control" name="sedeId">
			<option value="${responsable.sede.id }">${responsable.sede.nombre }</option>
			<c:forEach var="sede" items="${sedes}">
				<option value="${sede.id }">${sede.nombre }</option>
			</c:forEach>
			</select>
		</div>
		<input type="submit" value="Editar"
			class="form-control btn btn-success">
	</form>
</div>

<script type="text/javascript">
	$('#tituloDePagina')
			.append(
					'<span class="glyphicon glyphicon-pencil"></span> Modificando responsable');
	$('#tituloDePagina').show();
</script>