<%@ tag%>
<div class="container">
	<div class="row">
		<div class='col-sm-6'>
			<div class="form-group">
				<div class='input-group date' >
					<label>Desde</label> <input type='text' id='desde' class="form-control" /> <span
						class="input-group-addon"> <span
						class="glyphicon glyphicon-calendar"></span>
					</span>
				</div>
				<div class='input-group date datepicker' >
					<label>Hasta</label> <input type='text' id='hasta' class="form-control" /> <span
						class="input-group-addon"> <span
						class="glyphicon glyphicon-calendar"></span>
					</span>
				</div>
			</div>
		</div>
		<script type="text/javascript">
            $(function () {
                $('#desde').datepicker();
            });
            $(function () {
                $('#hasta').datepicker();
            });
        </script>
	</div>
</div>
<div class="row">
	<div class="col-xs-6 col-md-1"></div>
	<div class="col-xs-6 col-md-2">
		<div class="panel panel-success">
			<div class="panel-heading">
				<label><h4>Lunes</h4></label>
			</div>
			<div class="panel-body">
				<div class="table">
					<table>
						<tr>
							<td><a href="">Menu 1</a></td>
						</tr>
						<tr>
							<td><a href="">Menu 2</a></td>
						</tr>
						<tr>
							<td><a href="">Menu 3</a></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="col-xs-6 col-md-2">
		<div class="panel panel-success">
			<div class="panel-heading">
				<label><h4>Martes</h4></label>
			</div>
			<div class="panel-body">
				<div class="table">
					<table>
						<tr>
							<td><a href="">Menu 1</a></td>
						</tr>
						<tr>
							<td><a href="">Menu 2</a></td>
						</tr>
						<tr>
							<td><a href="">Menu 3</a></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="col-xs-6 col-md-2">
		<div class="panel panel-success">
			<div class="panel-heading">
				<label><h5>Miercoles</h5></label>
			</div>
			<div class="panel-body">
				<div class="table">
					<table>
						<tr>
							<td><a href="">Menu 1</a></td>
						</tr>
						<tr>
							<td><a href="">Menu 2</a></td>
						</tr>
						<tr>
							<td><a href="">Menu 3</a></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="col-xs-6 col-md-2 ">
		<div class="panel panel-success">
			<div class="panel-heading">
				<label><h4>Jueves</h4></label>
			</div>
			<div class="panel-body">
				<div class="table">
					<table>
						<tr>
							<td><a href="">Menu 1</a></td>
						</tr>
						<tr>
							<td><a href="">Menu 2</a></td>
						</tr>
						<tr>
							<td><a href="">Menu 3</a></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="col-xs-6 col-md-2 ">
		<div class="panel panel-success">
			<div class="panel-heading">
				<label><h4>Viernes</h4></label>
			</div>
			<div class="panel-body">
				<div class="table">
					<table>
						<tr>
							<td><a href="">Menu 1</a></td>
						</tr>
						<tr>
							<td><a href="">Menu 2</a></td>
						</tr>
						<tr>
							<td><a href="">Menu 3</a></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="col-xs-6 col-md-1"></div>
</div>
<a href="${pageContext.request.contextPath}/admin/altaCartilla"
	class="btn btn-primary" role="button">Alta Cartilla</a>