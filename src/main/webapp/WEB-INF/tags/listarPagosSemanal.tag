<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ tag%>
<div class="row">
	<div class='col-md-12'>
		<div class="col-md-7 col-md-offset-1">
			<h2 class="col-md-offset-1">
				<span class="label label-default"><strong>Cantidad
						de tickets vendidos</strong></span>
			</h2>
		</div>
		<div class="col-md-4">
			<form method="GET"
				action="${pageContext.request.contextPath}/pago/listadoSemanal"
				class="form text-center">
				<h4>
						<span class="label label-default"><label for='fechaInicio'>Elegir
								semana a buscar</label></span>
					</h4>
				<div class="col-md-6">
					
					<input type='text' id='fechaInicio' name='fechaInicio'
						class="form-control" />
				</div>
				<div class="col-md-5">
					<button type="submit" class="btn btn-warning">
						<strong>Buscar</strong> <span class="glyphicon glyphicon-search"></span>
					</button>
				</div>
			</form>
		</div>
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
		<div class="col-md-8 text-center">
			<div class="panel panel-success">
				<div class="panel-heading">
					<h4>
						<label>${diaMenu.key}</label>
					</h4>
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

<input type="hidden" id="idLunesSemana"
	value="<fmt:formatDate value='${semana}' pattern='dd/MM/yyyy' />" />

<script type="text/javascript">
	var lunesSemana = $('#idLunesSemana').val();
	$('#tituloDePagina')
			.append(
					'<span class="glyphicon glyphicon-list-alt"></span> Pagos registrados para la semana del '
							+ lunesSemana);
	$('#tituloDePagina').show();
</script>