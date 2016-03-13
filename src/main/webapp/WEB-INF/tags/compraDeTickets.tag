<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<div>
	<form method="POST"
		action="${pageContext.request.contextPath}/cartilla/crear">
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
				<label><h4>
						<c:out value="${dia.nombre }" />
					</h4></label>
				<div class="panel-body">
					<div class="table">
						<table>
							<c:forEach var="menu" items="${dia.menues}">

								<input type="hidden" value="${menu.id }" name="id">
								<tr>
									<td><input type="checkbox" name="${menu.id}"> <c:out
											value="${menu.nombre }" /></td>
									<td>
										<button type="button" class="btn btn-default dropdown-toggle"
											data-toggle="dropdown" aria-haspopup="true"
											aria-expanded="false">
											Detalle <span class="caret"></span>
										</button>
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
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</c:forEach>
		</div>



		<label>Precio</label>
		<p>
			<c:out value="${cartilla.precio }" />
		</p>
		<p>
			<c:out value="${sede.nombre }" />
		</p>
		<input type="submit" value="Alta Cartilla"
			class="form-control btn btn-primary">
	</form>
</div>

