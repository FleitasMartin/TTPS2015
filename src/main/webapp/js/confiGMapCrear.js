/**
 * Funciones y variables para mostrar el mapa al crear una sede
 */
var map;
var marker;
function initMap() {
	var latLngLaPlata = {
		lat : -34.920421,
		lng : -57.9525343
	};
	map = new google.maps.Map(document.getElementById('map'), {
		center : latLngLaPlata,
		zoom : 13
	});
	map.addListener('click', function(e) {
		placeMarker(e.latLng, map);
	});
}
function placeMarker(latLng, map) {
	if ((typeof (marker) !== 'undefined') && (marker !== null))
		marker.setMap(null);
	marker = new google.maps.Marker({
		position : latLng,
		map : map
	});
	calcLatLong();
	map.panTo(latLng);
}
function calcLatLong() {
	$("#latitud").val(marker.getPosition().lat());
	$("#longitud").val(marker.getPosition().lng());
}