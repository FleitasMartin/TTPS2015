<%@ tag language="java" pageEncoding="UTF-8"%>
<div class="form">
	<form method="post" action="${pageContext.request.contextPath}/sede/editar">
	<input type="hidden" value="${sede.id }" name="id">
		<div class="form-group">
			<label>Nombre</label> <input type="text" name="nombre"
				class="form-control" value="${sede.nombre }" /><br>
		</div>
		<div class="form-group">
			<label>Ubicaci&oacute;n</label> <input type="text" name="ubicacion"
				class="form-control" value="${sede.ubicacion }" /><br>
		</div>
		<div class="form-group">
			<label>Capacidad</label> <input type="text" name="capacidad"
				class="form-control" value="${sede.capacidad }" /><br>
		</div>

		<input type="submit" value="Editar"
			class="form-control btn btn-success">
	</form>
</div>