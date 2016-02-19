<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag language="java" pageEncoding="UTF-8"%>

<div class="row">

	<c:forEach var="dia" items="${semana.dias}">
		<div class="col-xs-6 col-md-2">
			<div class="panel panel-success">
				<div class="panel-heading">
					<label><h4>
							<c:out value="${dia.nombre }" />
						</h4></label>
				</div>
				<div class="panel-body">
					<div class="table">
						<table>
							<c:forEach var="menu" items="${dia.menues}">
								<tr>
									<td>
										<c:out value="${menu.nombre }" /></a>

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
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
	<div class="col-xs-6 col-md-1"></div>
</div>
<a href="${pageContext.request.contextPath}/admin/editarCartilla"
	class="btn btn-danger botondelet" role="button">Eliminar</a>
<a href="${pageContext.request.contextPath}/admin/eliminarCartilla"
	class="btn btn-warning" role="button">Editar</a>
<a href="${pageContext.request.contextPath}/admin/cartillaSemanal"
	class="btn btn-primary" role="button">Volver</a>