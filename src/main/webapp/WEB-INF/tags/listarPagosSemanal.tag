<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag%>
<div class="row">
	<div class='col-sm-7 col-sm-offset-1'>
		<h2>
			<strong>Cantidad de tickets vendidos</strong>
		</h2>
		<form method="GET"
			action="${pageContext.request.contextPath}/pago/listadoSemanal"
			class="col-sm-offset-1 form-inline">
			<div class="form-group ">
				<div class='date'>
					<label for='fechaInicio'>Semana</label> <input type='text'
						id='fechaInicio' name='fechaInicio' class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<input type="submit" value="Buscar"
					class="form-control btn btn-default">
			</div>

		</form>
	</div>
	<script type="text/javascript">
		$(function() {
			$('#fechaInicio').datepicker();
		});
	</script>
</div>
<br>
<c:forEach var="diaMenu" items="${map}">
	<div class="row">
		<div class="col-xs-6 col-md-8">
			<div class="panel panel-success">
				<div class="panel-heading">
					<label><h4>${diaMenu.key}</h4></label>
				</div>
				<div class="panel-body">
					<table class="table">
						<thead>
							<tr>
								<th>Nombre menu</th>
								<th>Cantidad</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="menu" items="${diaMenu.value}">
								<tr>
									<td><c:out value="${menu.key}" /></td>
									<td><c:out value="${menu.value}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</c:forEach>