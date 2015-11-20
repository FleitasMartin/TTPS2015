<%@ tag%>
<div class="form">
	<form>
		<label>Tipo</label>
		<select class="form-control">
		  <option>Bebida</option>
		  <option>Entrada</option>
		  <option>Plato principal</option>
		  <option>Postre</option>		  
		</select>
		<div class="form-group">
		<label>Nombre</label> <input type="text" name="name" class="form-control" /><br>
		</div>
		<select multiple name="duallistbox" class="form-control">
		  <option>Arroz</option>
		  <option>Pollo</option>
		  <option>Tomate</option>
		  <option>Lechuga</option>		  
		</select>
		
		<input type="submit" value="Crear" class="form-control btn btn-success">
	</form>
</div>
<script type="text/javascript">
var demo1 = $('select[name="duallistbox"]').bootstrapDualListbox();
</script>
