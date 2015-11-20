<%@ tag language="java" pageEncoding="UTF-8"%>

<table class="table">
	<thead>
		<tr>
			<th>Nombre de Sede</th>
			<th>Ubicaci&oacute;n</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>Club Everton</td>
			<td>Calle 14 entre 63 y 64</td>
		</tr>
		<tr>
			<td>Sede Bosque Oeste</td>
			<td>Calle 50 y 116</td>
		</tr>
		<tr>
			<td>Sede Bosque</td>
			<td>Boulevard 120 entre 61 y 62</td>
		</tr>
		<tr>
			<td>Sede Centro de La Plata</td>
			<td>Calle 44 N&ordm; 733 (ATULP)</td>
		</tr>
	</tbody>
</table>
<div id="map"></div>

    <script type="text/javascript">

var map;
function initMap() {
	var myLatLng = {lat: -34.920421, lng: -57.9525343};
  map = new google.maps.Map(document.getElementById('map'), {
    center: myLatLng,
    zoom: 13
  });
  var bosqueOeste = {lat: -34.90757, lng: -57.94190};
  var bosqueEste = {lat: -34.90945,lng: -57.925642};
  var clubEverton = {lat:-34.93040, lng: -57.94457};
  var centroATULP = {lat:-34.9131241,lng: -57.9582042};
  var marker = new google.maps.Marker({
	    position: bosqueOeste,
	    map: map,
	    title: 'Comedor universitario. Sede bosque oeste.'
	  });
  var marker2 = new google.maps.Marker({
	    position: bosqueEste,
	    map: map,
	    title: 'Comedor universitario. Sede bosque este.'
	  });
  var marker3 = new google.maps.Marker({
	    position: clubEverton,
	    map: map,
	    title: 'Comedor universitario. Club Everton.'
	  });
  var marker4 = new google.maps.Marker({
	    position: centroATULP,
	    map: map,
	    title: 'Comedor universitario. Centro ATULP.'
	  });
}

    </script>
    <script async defer
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyALdnqGLwYolrMF5GK9cLQVPBu8iBDV4Ck&callback=initMap">
    </script>