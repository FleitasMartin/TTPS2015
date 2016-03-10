<%@ tag%>
<div class="form">
	<form method="POST" action="${pageContext.request.contextPath}/componente/crear">
		<label>Tipo</label> <select class="form-control" name="tipo">
			<option value="bebida">Bebida</option>
			<option value="entrada">Entrada</option>
			<option value="plato">Plato principal</option>
			<option value="postre">Postre</option>
		</select>
		<div class="form-group">
			<label>Nombre</label> <input type="text" name="nombre"
				class="form-control" /><br>
		</div>
		<input type="submit" value="Crear"
			class="form-control btn btn-success">
	</form>
</div>