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
			<div id="map"></div>
		</div>
		<input type="submit" value="Crear"
			class="form-control btn btn-success">
	</form>
</div>
<script type="text/javascript">
	var map;
	function initMap() {
		var myLatLng = {
			lat : -34.920421,
			lng : -57.9525343
		};
		map = new google.maps.Map(document.getElementById('map'), {
			center : myLatLng,
			zoom : 13
		});
		map.addListener('click', function(e) {
			placeMarkerAndPanTo(e.latLng, map);
		});
		/*var bosqueOeste = {
			lat : -34.90757,
			lng : -57.94190
		};
		var bosqueEste = {
			lat : -34.90945,
			lng : -57.925642
		};
		var clubEverton = {
			lat : -34.93040,
			lng : -57.94457
		};
		var centroATULP = {
			lat : -34.9131241,
			lng : -57.9582042
		};
		var marker = new google.maps.Marker({
			position : bosqueOeste,
			map : map,
			title : 'Comedor universitario. Sede bosque oeste.'
		});
		var marker2 = new google.maps.Marker({
			position : bosqueEste,
			map : map,
			title : 'Comedor universitario. Sede bosque este.'
		});
		var marker3 = new google.maps.Marker({
			position : clubEverton,
			map : map,
			title : 'Comedor universitario. Club Everton.'
		});
		var marker4 = new google.maps.Marker({
			position : centroATULP,
			map : map,
			title : 'Comedor universitario. Centro ATULP.'
		});*/
	}
	//https://developers.google.com/maps/documentation/javascript/events#EventArguments
	function placeMarkerAndPanTo(latLng, map) {
		var marker = new google.maps.Marker({
			position : latLng,
			map : map
		});
		map.panTo(latLng);
	}
</script>
<script async defer
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyALdnqGLwYolrMF5GK9cLQVPBu8iBDV4Ck&callback=initMap">
	
</script>