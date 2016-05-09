<%@ tag language="java" pageEncoding="UTF-8"%>
<div class="form">
	<form method="post"
		action="${pageContext.request.contextPath}/sede/editar">
		<input type="hidden" value="${sede.id }" name="id">
		<div class="form-group">
			<label>Nombre</label> <input type="text" name="nombre" id="nombre"
				class="form-control" value="${sede.nombre }" /><br>
		</div>
		<div class="form-group">
			<label>Ubicaci&oacute;n</label> <input type="text" name="ubicacion"
				class="form-control" value="${sede.ubicacion }" /><br>
		</div>
		<div class="form-group">
			<label>Capacidad</label> <input type="text" name="capacidad"
				class="form-control" value="${sede.capacidad }" /><br>
		</div>
		<div class="form-group">
			<label>Indique en el mapa la ubicaci&oacute;n de la sede</label>
			<div id="map"></div>
			<input type="hidden" id="latitud" name="latitud"
				value="${sede.latitud }"> <input type="hidden" id="longitud"
				name="longitud" value="${sede.longitud }">
		</div>
		<input type="submit" value="Editar"
			class="form-control btn btn-success">
	</form>
</div>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/confiGMapEditar.js"></script>
<script async defer
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyALdnqGLwYolrMF5GK9cLQVPBu8iBDV4Ck&callback=initMap">
	
</script>