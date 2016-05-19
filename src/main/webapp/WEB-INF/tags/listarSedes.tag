<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag language="java" pageEncoding="UTF-8"%>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/confiGMapListar.js"></script>

<div class="row">
	<div class="col-md-7">
		<div class="well mapUsuario" id="map"></div>
	</div>
	<div class="col-md-5 text-center">
		<div class="row">
			<div class="col-md-5">
				<h3>
					<span class="label label-default">
					<span class="glyphicon glyphicon-pushpin"></span> 
					Sedes </span>
				</h3>
			</div>
			<div class="col-md-7">
				<h3>
					<span class="label label-default">
					<span class="glyphicon glyphicon-map-marker"></span> 
					Ubicaciones </span>
				</h3>
			</div>
		</div>
		<c:forEach var="sede" items="${sedes}">
			<!-- 			<tr> -->
			<div class="row ">
				<div class="col-md-5">
					<h4>
						<span class="label label-success"> <c:out
								value="${sede.nombre }" />
						</span>
					</h4>
				</div>
				<div class="col-md-7 ">
					<h4>
						<span class="label label-success"> <c:out
								value="${sede.ubicacion }" />
						</span>
					</h4>
				</div>
			</div>
			<script type="text/javascript">crearMarcador('${sede.nombre }', ${sede.latitud } , ${sede.longitud } );</script>
		</c:forEach>
	</div>
</div>

<script type="text/javascript">
	$('#tituloDePagina').append('<span class="glyphicon glyphicon-globe"></span> Sedes en el mapa de la ciudad');
	$('#tituloDePagina').show();
</script>

<script async defer
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyALdnqGLwYolrMF5GK9cLQVPBu8iBDV4Ck&callback=initMap">
</script>