<%@ tag%>
<div class="form">
	<form>
		<div class="form-group">
			<label for="exampleInputEmail1">Nombre</label> <input type="text"
				class="form-control" id="nombreMenu" name="name">
		</div>
		<label>Caracteristicas</label> <select multiple name="duallistbox"
			class="form-control">
			<option>Celiaco</option>
			<option>Diab&eacute;tico</option>
			<option>Hipertenso</option>
			<option>Intolerante a la Lactosa</option>
		</select> <label>Bebidas</label> <select multiple name="duallistbox"
			class="form-control">
			<option>Bebida 1</option>
			<option>Bebida 1</option>
			<option>Bebida 1</option>
			<option>Bebida 1</option>
		</select> <label>Entradas</label> <select multiple name="duallistbox"
			class="form-control">
			<option>Entrada 1</option>
			<option>Entrada 1</option>
			<option>Entrada 1</option>
			<option>Entrada 1</option>
		</select> <label>Platos</label> <select multiple name="duallistbox"
			class="form-control">
			<option>Plato 1</option>
			<option>Plato 2</option>
			<option>Plato 3</option>
			<option>Plato 4</option>
		</select> <label>Postres</label> <select multiple name="duallistbox"
			class="form-control">
			<option>Postre 1</option>
			<option>Postre 2</option>
			<option>Postre 3</option>
			<option>Postre 4</option>
		</select> <input type="submit" value="Crear"
			class="form-control btn btn-success">
	</form>
</div>
<script type="text/javascript">
	var demo1 = $('select[name="duallistbox"]').bootstrapDualListbox();
</script>