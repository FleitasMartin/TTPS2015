<%@ tag language="java" pageEncoding="UTF-8"%>
<div class="form" >
	<form method="POST" action="${pageContext.request.contextPath}/admin/altaAdmin">
		<div class="form-group">
			<label>Nombre</label> <input type="text" name="nombre"
				class="form-control" /><br>
		</div>
		<div class="form-group">
			<label>Apellido</label> <input type="text" name="apellido"
				class="form-control" /><br>
		</div>
		<div class="form-group">
			<label>DNI</label> <input type="number" name="dni"
				class="form-control" /><br>
		</div>
		<div class="form-group">
			<label>Contrase&ntilde;a</label> <input type="password" name="contrasena"
				class="form-control" /><br>
		</div>
		<input type="submit" value="Crear"
			class="form-control btn btn-success">
	</form>
</div>