<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag%>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/confiGMapListar.js"></script>

<div class="row">

	<div class="col-md-5">

		<div id="map" class="well map"></div>

	</div>

	<div class="col-md-6 ">

		<div class="col-md-12 ">
		
		<div class="row">
					<div class="col-md-4"><h4><span class="label label-default">Sede</span></h4></div>
					<div class="col-md-4"><h4><span class="label label-default">Ubicaci&oacute;n</span></h4></div>
					<div class="col-md-2"><h4><span class="label label-default">Cap.</span></h4></div>
					<div class="col-md-2"><h4><span class="label label-default">Editar/Borrar</span></h4></div>
		</div>
		

				<c:forEach var="sede" items="${sedes}">
					<div class="row">
						<div class="col-md-4"><h4><span class="label label-success"><c:out value="${sede.nombre }" /></span></h4></div>
						<div class="col-md-4"><h4><span class="label label-success"><c:out value="${sede.ubicacion }" /></span></h4></div>
						<div class="col-md-2"><h4><span class="label label-success"><c:out value="${sede.capacidad }" /></span></h4></div>
						<div class="col-md-1">
						<form
								action="${pageContext.request.contextPath}/sede/editar"
								method="GET">
								<button
									type="submit" class="btn btn-warning" ><span class="glyphicon glyphicon-pencil"></span></button>
								<input type="hidden" value="${sede.id }" name="id">
							</form>
						</div>
						<div class="col-md-1">
							<form action="${pageContext.request.contextPath}/sede/eliminar"
								method="POST">
								<button
									type="submit" class="btn btn-danger botondelete"
									><span class="glyphicon glyphicon-trash"></span></button>
								<input type="hidden" value="${sede.id }" name="id">
							</form>
						</div>
					</div>
					<script type="text/javascript">crearMarcador('${sede.nombre }', ${sede.latitud } , ${sede.longitud } );</script>
				</c:forEach>
		</div>		
				
		<div class="col-md-12 text-center">				
		<a href="${pageContext.request.contextPath}/sede/crear"
			class="btn btn-warning" role="button"> <strong>Alta Sede <span class="glyphicon glyphicon-home"></span> </strong> </a>
		
		</div>
		
	</div>



</div>

<script type="text/javascript">
	$('#tituloDePagina')
			.append(
					'<span class="glyphicon glyphicon-globe"></span> Sedes en el mapa de la ciudad');
	$('#tituloDePagina').show();
</script>

<script async defer
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyALdnqGLwYolrMF5GK9cLQVPBu8iBDV4Ck&callback=initMap">
</script>



<!-- <table class="table"> -->
<!-- 	<thead> -->
<!-- 		<tr> -->
<!-- 			<th>Nombre de Sede</th> -->
<!-- 			<th>Ubicaci&oacute;n</th> -->
<!-- 			<th>Capacidad</th> -->
<!-- 		</tr> -->
<!-- 	</thead> -->
<!-- 	<tbody> -->
<%-- 		<c:forEach var="sede" items="${sedes}"> --%>
<!-- 			<tr> -->
<%-- 				<td><c:out value="${sede.nombre }" /></td> --%>
<%-- 				<td><c:out value="${sede.ubicacion }" /></td> --%>
<%-- 				<td><c:out value="${sede.capacidad }" /></td> --%>
<!-- 				<td><form -->
<%-- 						action="${pageContext.request.contextPath}/sede/editar" --%>
<!-- 						method="GET"> -->
<%-- 						<input type="hidden" value="${sede.id }" name="id"> <input --%>
<!-- 							type="submit" class="btn btn-warning" value="Editar" /> -->
<!-- 					</form></td> -->
<!-- 				<td> -->
<%-- 					<form action="${pageContext.request.contextPath}/sede/eliminar" --%>
<!-- 						method="POST"> -->
<%-- 						<input type="hidden" value="${sede.id }" name="id"> <input --%>
<!-- 							type="submit" class="btn btn-danger botondelete" value="Eliminar" /> -->
<!-- 					</form> -->
<!-- 				</td> -->
<!-- 			</tr> -->
<!-- 			<script type="text/javascript">crearMarcador('${sede.nombre }', ${sede.latitud } , ${sede.longitud } );</script> -->
<%-- 		</c:forEach> --%>
<!-- 	</tbody> -->
<!-- </table> -->
<%-- <a href="${pageContext.request.contextPath}/sede/crear" --%>
<!-- 	class="btn btn-primary" role="button">Alta Sede</a> -->
<!-- <div id="map"></div> -->