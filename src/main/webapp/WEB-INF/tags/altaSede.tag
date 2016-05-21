<%@ tag language="java" pageEncoding="UTF-8"%>
<div class="form">
	<form method="post"
		action="${pageContext.request.contextPath}/sede/crear">
		<div class="form-group">
			<label>Nombre</label> <input type="text" name="nombre"
				class="form-control" /><br>
		</div>
		<div class="form-group">
			<label>Ubicaci&oacute;n</label> <input type="text" name="ubicacion"
				class="form-control" /><br>
		</div>
		<div class="form-group">
			<label>Capacidad</label> <input type="text" name="capacidad"
				class="form-control" /><br>
		</div>
		<div class="form-group">
			<label>Indique en el mapa la ubicaci&oacute;n de la sede</label>
			<div id="map" class="sede map"></div>
			<input type="hidden" id="latitud" name="latitud"> <input
				type="hidden" id="longitud" name="longitud">
		</div>
		<input type="submit" value="Crear"
			class="form-control btn btn-success">
	</form>
</div>
<script type="text/javascript">
	$('#tituloDePagina')
			.append(
					'<span class="glyphicon glyphicon-cog"></span> Creando sede');
	$('#tituloDePagina').show();
</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/confiGMapCrear.js"></script>
<script async defer
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyALdnqGLwYolrMF5GK9cLQVPBu8iBDV4Ck&callback=initMap">
	
</script>