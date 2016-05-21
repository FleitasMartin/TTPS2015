<%@ tag language="java" pageEncoding="UTF-8"%>
<div class="form">
	<form method="post" action="${pageContext.request.contextPath}/admin/editarAdmin">
	<input type="hidden" value="${admin.id }" name="id">
		<div class="form-group">
			<label>Nombre</label> <input type="text" name="nombre"
				class="form-control" value="${admin.nombre }" /><br>
		</div>
		<div class="form-group">
			<label>Apellido</label> <input type="text" name="apellido"
				class="form-control" value="${admin.apellido }" /><br>
		</div>
		<div class="form-group">
			<label>Telefono</label> <input type="text" name="telefono"
				class="form-control" value="${admin.telefono }" /><br>
		</div>
		<div class="form-group">
			<label>Email</label> <input type="email" name="email"
				class="form-control" value="${admin.email }" /><br>
		</div>
		<div class="form-group">
			<label>Domicilio</label> <input type="text" name="domicilio"
				class="form-control" value="${admin.domicilio }" /><br>
		</div>
		<input type="submit" value="Editar"
			class="form-control btn btn-success">
	</form>
</div>
<script type="text/javascript">
	$('#tituloDePagina')
			.append(
					'<span class="glyphicon glyphicon-pencil"></span> Modificando administrador');
	$('#tituloDePagina').show();
</script>