<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<div>
	<form method="POST"
		action="${pageContext.request.contextPath}/cartilla/crear">
		<div class="row col-md-12">
			<div class='col-md-4'>
				<div class="form-group">
					<div class='input-group date '>
						<label>Desde</label> <input type='text' id='desde' name='desde'
							class="form-control" /> <span class="input-group-addon">
							<span class="glyphicon glyphicon-calendar"></span>
						</span>
					</div>
					<div class='input-group date '>
						<label>Hasta</label> <input type='text' id='hasta' name='hasta'
							class="form-control" /> <span class="input-group-addon">
							<span class="glyphicon glyphicon-calendar"></span>
						</span>
					</div>
				</div>
			</div>
			<c:if test="${not empty error}">
				<div class="col-md-8">
					<div class="alert alert-danger">
						<h3 class="text-center">
							<strong>¡Encontramos un problema!</strong>
						</h3>
						<h4 class="text-center">
							<c:out value="${error}"></c:out>
						</h4>
					</div>
				</div>
			</c:if>
			<script type="text/javascript">
				$(function() {
					$('#desde').datepicker();
				});
				$(function() {
					$('#hasta').datepicker();
				});
			</script>
		</div>
		<table class="table">
			<thead>
				<tr>
					<td>Menus</td>
					<td>Lunes</td>
					<td>Martes</td>
					<td>Mi&eacute;rcoles</td>
					<td>Jueves</td>
					<td>Viernes</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="menu" items="${menues}">
					<input type="hidden" value="${menu.id }" name="id">
					<tr>
						<td><c:out value="${menu.nombre }" /></td>
						<td><input type="checkbox" name="lunes" value="${menu.id }"></td>
						<td><input type="checkbox" name="martes" value="${menu.id }">
						</td>
						<td><input type="checkbox" name="miercoles"
							value="${menu.id }"></td>
						<td><input type="checkbox" name="jueves" value="${menu.id }">
						</td>
						<td><input type="checkbox" name="viernes" value="${menu.id }">
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<label>Precio</label> <input type="number" value="" name="precio">
		<input type="submit" value="Alta Cartilla"
			class="form-control btn btn-primary">

	</form>
</div>

<script type="text/javascript">
	$('#tituloDePagina')
			.append(
					'<span class="glyphicon glyphicon-cog"></span> Creando cartilla');
	$('#tituloDePagina').show();
</script>