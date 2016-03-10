<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ tag language="java" pageEncoding="UTF-8"%>

<div >
<!-- 	<div class="row"> -->
	<h3>Cartillas</h3>
	<table class="table">
		<thead>
			<tr>
				<td>Desde</td>
				<td>Hasta</td>
				<td>Precio</td>
				<td>Detalle</td>
				<td>Modificar</td>
				<td>Eliminar</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="cartilla" items="${cartillas}">
   				<tr>
					<td><fmt:formatDate value="${cartilla.fechaInicio}" pattern="dd/MM/yyyy"/></td>
					<td><fmt:formatDate value="${cartilla.fechaFin}" pattern="dd/MM/yyyy"/></td>
					<td><c:out value="${cartilla.precio }" /></td>
					<td>
						<form action="${pageContext.request.contextPath}/cartilla/detalle" method="GET">
							<input type="hidden" value="${cartilla.id }" name="id">
							<input type="submit" class="btn btn-warning"
									value="Detalle" />
						</form>
					</td>
					<td>
						<form action="${pageContext.request.contextPath}/cartilla/editar" method="GET">
							<input type="hidden" value="${cartilla.id }" name="id">
							<input type="submit" class="btn btn-warning"
									value="Modificar" />
						</form>
					</td>
					<td>
					<form action="${pageContext.request.contextPath}/cartilla/eliminar" method="POST">
						<input type="hidden" value="${cartilla.id }" name="id">
						<input type="submit" class="btn btn-danger botondelete"
								value="Eliminar" />
					</form>
					</td>
				</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
<!-- </div> -->
<!-- 		<div class='col-sm-6'> -->
<!-- 			<div class="form-group"> -->
<!-- 				<div class='input-group date' > -->
<!-- 					<label>Desde</label> <input type='text' id='desde' class="form-control" /> <span -->
<!-- 						class="input-group-addon"> <span -->
<!-- 						class="glyphicon glyphicon-calendar"></span> -->
<!-- 					</span> -->
<!-- 				</div> -->
<!-- 				<div class='input-group date datepicker' > -->
<!-- 					<label>Hasta</label> <input type='text' id='hasta' class="form-control" /> <span -->
<!-- 						class="input-group-addon"> <span -->
<!-- 						class="glyphicon glyphicon-calendar"></span> -->
<!-- 					</span> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 		<script type="text/javascript"> 
             $(function () {
                 $('#desde').datepicker();
             });
             $(function () {
                 $('#hasta').datepicker();
             });
         </script> -->

<!-- 
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
	<div class="col-xs-6 col-md-1"></div>-->
<a href="${pageContext.request.contextPath}/admin/altaCartilla"
	class="btn btn-primary" role="button">Alta Cartilla</a>