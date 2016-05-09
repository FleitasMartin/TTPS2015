/**
 * Funciones y variables para mostrar el mapa en el listado de sedes
 */
var map;
var marcadores = [];

function initMap() {
	var latLngLaPlata = {
		lat : -34.920421,
		lng : -57.9525343
	};
	map = new google.maps.Map(document.getElementById('map'), {
		center : latLngLaPlata,
		zoom : 13
	});

	for (i = 0; i < marcadores.length; i++) {
		marcadores[i] = new google.maps.Marker({
			position : {
				lat : marcadores[i].latitud,
				lng : marcadores[i].longitud
			},
			map : map,
			title : marcadores[i].nombre
		});
	}
}

function crearMarcador(nombre, latitud, longitud) {
	marcadores[marcadores.length] = {
		nombre : nombre,
		latitud : latitud,
		longitud : longitud
	};
}