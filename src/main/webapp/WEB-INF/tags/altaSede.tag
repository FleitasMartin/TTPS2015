<%@ tag language="java" pageEncoding="UTF-8"%>
<div class="form">
	<form method="post" action="${pageContext.request.contextPath}/sede/crear">
		<div class="form-group">
			<label>Nombre</label> <input type="text" name="nombre"
				class="form-control" /><br>
		</div>
		<div class="form-group">
			<label>Ubicaci&oacute;n</label> <input type="text" name="ubicacion"
				class="form-control" /><br>
		</div>
		<div class="form-group">
			<label>Capacidad</label> <input type="text" name="capacidad"
				class="form-control" /><br>
		</div>

		<input type="submit" value="Crear"
			class="form-control btn btn-success">
	</form>
</div>