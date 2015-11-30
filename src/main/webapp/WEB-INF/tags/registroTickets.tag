<%@ tag language="java" pageEncoding="UTF-8"%>
<form class="form-inline">
	<div class="form-group">
		<label for="dni">DNI</label> <input type="text" class="form-control"
			id="dni" placeholder="11223344">
	</div>
	<button type="submit" class="btn btn-default">Buscar</button>
</form>
<form class="form-inline">
	<div class="form-group">
		<label for="name">Nombre</label> <input type="text"
			class="form-control" id="name" placeholder="Julieta Park">
	</div>
	<button type="submit" class="btn btn-default">Buscar</button>
</form>


<div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="panel-title">Resultado de b&uacute;squeda</h3>
	</div>
	<div class="panel-body">
		<table class="table">
			<tr>
				<td>Nombre</td>
				<td>Julieta Park</td>
			</tr>
			<tr>
				<td>DNI</td>
				<td>11223344</td>
			</tr>
			<tr>
				<td>Menu</td>
				<td>Menu 2</td>
			</tr>
			<tr>
				<td>Turno</td>
				<td>Turno 2</td>
			</tr>
			<tr>
				<td>Para llevar</td>
				<td>No</td>
			</tr>
			<tr>
				<td>Pago</td>
				<td>Si</td>
			</tr>
		</table>
		<button type="submit" class="btn btn-default">Ingresar
			comensal</button>
	</div>
</div>