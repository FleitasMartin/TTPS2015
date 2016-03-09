<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag%>
<table class="table">
	<thead>
		<tr>
			<th>Nombre de Sede</th>
			<th>Ubicaci&oacute;n</th>
			<th>Capacidad</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="sede" items="${sedes}">
			<tr>
				<td><c:out value="${sede.nombre }" /></td>
				<td><c:out value="${sede.ubicacion }" /></td>
				<td><c:out value="${sede.capacidad }" /></td>
				<td>
					<form action="#" method="POST">
						<input type="hidden" value="${sede.id }" name="id"> <input
							type="submit" class="btn btn-danger botondelete" value="Eliminar" />
					</form>
				</td>
				<td><a class="btn btn-warning" href="#">Editar</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a href="${pageContext.request.contextPath}/admin/altaSede"
	class="btn btn-primary" role="button">Alta Sede</a>
<div id="map"></div>

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
		var bosqueOeste = {
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
		});
	}
</script>
<script async defer
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyALdnqGLwYolrMF5GK9cLQVPBu8iBDV4Ck&callback=initMap">
	
</script>