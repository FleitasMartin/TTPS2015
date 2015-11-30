<%@ tag language="java" pageEncoding="UTF-8"%>
<h2>Tu saldo es: $0</h2>
<br>
<br>
<h4>Cargar saldo</h4>
<form>
	<div class="form-group">
		<label>Monto</label> <input type="text" name="name"
			class="form-control" /><br>
	</div>
	<div class="form-group">
		<label>Forma de pago</label> <select class="form-control">
			<option>Mercado pago</option>
			<option>Pago facil</option>
		</select>
	</div>
	<input type="submit" value="Cargar saldo" class=" btn btn-success">
</form>