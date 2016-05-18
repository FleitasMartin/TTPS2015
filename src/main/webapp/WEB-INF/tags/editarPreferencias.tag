<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<div class="form col-md-12 text-center">
	<form method="post"
		action="${pageContext.request.contextPath}/user/editarPreferencias">
		<div class="row">
			<div class="col-md-8 col-md-offset-1">
				<select multiple name="caracteristicas" id="caracteristicas"
					class="form-control">
					<c:forEach var="caracteristica" items="${caracteristicas}">
						<option value="${caracteristica.id }"><c:out
								value="${caracteristica.nombre }" /></option>
					</c:forEach>
					<c:forEach var="caracteristica" items="${usuario.caracteristica}">
						<option selected value="${caracteristica.id }"><c:out
								value="${caracteristica.nombre }" /></option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="row" style="margin-top: 1%">
			<div class="col-md-2 col-md-offset-4">
				<!-- 				<input type="submit" value="Terminar" -->
				<!-- 					class="form-control btn btn-warning"> -->
				<button type="submit" class="form-control btn btn-warning">
					<strong>Guardar</strong> <span class="glyphicon glyphicon-save" aria-hidden="true">
					</span>
				</button>
			</div>
		</div>
	</form>
</div>

<script type="text/javascript">
	var dual1 = $("#caracteristicas")
			.bootstrapDualListbox(
					{
						nonSelectedListLabel : '<h3><span class="label label-default">Caracter&iacute;sticas del sistema</span> </h3>',
						selectedListLabel : '<h3><span class="label label-default">Caracter&iacute;sticas personales</span>	</h3>',
						showFilterInputs : false,
						infoText : '<h5><span class="label label-info"> Mostrando {0} </span></h5>',
						infoTextEmpty : '<h5><span class="label label-info"> No hay características seleccionadas </span></h5>'
					});

	$('#tituloDePagina').append('<span class="glyphicon glyphicon-pencil"></span> Modificando caracter&iacute;sticas');
	$('#tituloDePagina').show();
</script>