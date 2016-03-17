<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ tag language="java" pageEncoding="UTF-8"%>
<div>
	<form method="POST"
		action="${pageContext.request.contextPath}/compra/crear">
		<div class="form-group">
			<label>Cantidad de Semanas</label> <select class="form-control"
				name="cantidadSemanas">
				<c:forEach var="i" begin="1" end="${cantidad }">
					<option value="${i}"><c:out value="${i}" /></option>
				</c:forEach>
			</select>
		</div>

		<div class="row">
			<c:forEach var="dia" items="${semana.dias}">
				<label><h4><c:out value="${dia.nombre }" /></h4></label>
				<div class="panel-body">
					<div class="table">
						<table>
							<c:forEach var="menu" items="${dia.menues}">
								<tr>
									<td>
									<!-- <input type="checkbox" name="${dia.nombre}">-->
									<input type="radio" name="${dia.nombre}" value="${menu.id }">
									<c:out value="${menu.nombre}" /> 
									<input type="hidden" value="<fmt:formatDate value="${dia.fecha}" pattern="MM/dd/yyyy"/>" name="fecha${dia.nombre }" /> </td>
									<!-- <input type="hidden" value="${dia.fecha }" name="fecha${dia.nombre}"></td>-->
									<td>
										<label>Donde Comer</label> 
										<select class="form-control" name="seleccionVianda${dia.nombre}">
											<option value="1">Vianda</option>
											<option value="0">Comedor</option>
										</select>
									</td>
									<td>
									<div class="btn-group">
										<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Detalle <span class="caret"></span></button>
										<ul class="dropdown-menu">
											<li class="dropdown-header">Componentes</li>
											<c:forEach var="componente" items="${menu.componentes}">
												<li><c:out value="${componente.nombre }" /></li>
											</c:forEach>
											<li class="dropdown-header">Caracteristicas</li>
											<c:forEach var="carac" items="${menu.caracteristica}">
												<li><c:out value="${carac.nombre }" /></li>
											</c:forEach>
										</ul>
										</div>
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</c:forEach>
		</div>
		<label>Precio</label> <input type="hidden" value="${cartilla.precio }"
			name="precio">
		<p>
			<c:out value="${cartilla.precio }" />
		</p>
		<label>Sede</label>
		<p>
			<c:out value="${sede.nombre }" />
			<input type="hidden" value="${sede.id }" name="sede">
		</p>
		<input type="submit" value="Comprar"
			class="form-control btn btn-primary">
	</form>
</div>

