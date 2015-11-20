<%@ tag%>
<h3>Sugerencia</h3>

<div class="form">
	<form>
		<div class="form-group">
			<label>Nombre Usuario</label> <input type="text" name="user"
				class="form-control" /><br>
		</div>
		<div class="form-group">
			<label>Tipo de sugerencia</label> <select class="form-control">
				<option value="alimento">alimento</option>
				<option value="infraestructura">infraestructura</option>
				<option value="atencion">atencion</option>
			</select>
		</div>
		<div class="form-group">
			<label>Sede</label> <select class="form-control">
				<option value="sedeBosque">Sede Bosque</option>
				<option value="sedeCentro">Sede Centro</option>
				<option value="sedeBosqueOeste">Sede Bosque Oeste</option>
				<option value="clubEverton">Club Everton</option>
			</select>
		</div>
		<div class="form-group">
			<textarea class="form-control" name="message" rows="10" cols="30">
  </textarea>
		</div>
		<input type="submit" value="Enviar"
			class="form-control btn btn-success">
	</form>
</div>