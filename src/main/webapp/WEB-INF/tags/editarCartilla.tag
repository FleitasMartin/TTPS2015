<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ tag language="java" pageEncoding="UTF-8"%>
<div>
	<form method="POST" action="${pageContext.request.contextPath}/cartilla/editar" >
		<div class="row">
			<div class='col-sm-8'>
				<div class="form-group">
					<div class='input-group date ' >
						<label>Desde</label> <input type='text' id='desde' name='desde' class="form-control" value="<fmt:formatDate value="${cartilla.fechaInicio}" pattern="MM/dd/yyyy"/>" /> 
						
						<span
							class="input-group-addon"> <span
							class="glyphicon glyphicon-calendar"></span>
						</span>
					</div>
					<div class='input-group date ' >
						<label>Hasta</label> <input type='text' id='hasta' name='hasta' class="form-control" value="<fmt:formatDate value="${cartilla.fechaFin}" pattern="MM/dd/yyyy"/>" /> <span
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
					<td><input type="checkbox" name="lunes" ${menu.lunes } value="${menu.id }"></td>
					<td><input type="checkbox" name="martes" ${menu.martes } value="${menu.id }">
					</td>
					<td><input type="checkbox" name="miercoles" ${menu.miercoles } value="${menu.id }">
					</td>
					<td><input type="checkbox" name="jueves" ${menu.jueves } value="${menu.id }">
					</td>
					<td><input type="checkbox" name="viernes" ${menu.viernes } value="${menu.id }">
					</td>
				</tr>				
			</c:forEach>

			</tbody>
		</table>
		<label>Precio</label>
		<input type="number" value="${cartilla.precio }" name="precio">
		<input type="hidden" value="${cartilla.id }" name="idCartilla">
		<input type="submit" value="Modificar Cartilla"
			class="form-control btn btn-primary">
		
	</form>
	</div>