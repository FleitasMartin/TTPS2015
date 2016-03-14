<%@ tag language="java" pageEncoding="UTF-8"%>
<div class="form" method="POST" action="${pageContext.request.contextPath}/admin/altaUsuario">
	<form>
		<div class="form-group">
			<label>Nombre</label> <input type="text" name="nombre"
				class="form-control" /><br>
		</div>
		<div class="form-group">
			<label>Apellido</label> <input type="text" name="apellido"
				class="form-control" /><br>
		</div>
		<div class="form-group">
			<label>DNI</label> <input type="text" name="dni"
				class="form-control" /><br>
		</div>
		<div class="form-group">
			<label>Contrase&ntilde;a</label> <input type="password" name="contrasena"
				class="form-control" /><br>
		</div>
		<div class="form-group">
			<label>Rol</label> <select class="form-control" name="rol">
				<option value="0">Admin</option>
				<option value="1">Responsable</option>
			</select>
		</div>
		<input type="submit" value="Crear"
			class="form-control btn btn-success">
	</form>
</div>