<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag%>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/confiGMapListar.js"></script>

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
				<td><form
						action="${pageContext.request.contextPath}/sede/editar"
						method="GET">
						<input type="hidden" value="${sede.id }" name="id"> <input
							type="submit" class="btn btn-warning" value="Editar" />
					</form></td>
				<td>
					<form action="${pageContext.request.contextPath}/sede/eliminar"
						method="POST">
						<input type="hidden" value="${sede.id }" name="id"> <input
							type="submit" class="btn btn-danger botondelete" value="Eliminar" />
					</form>
				</td>
			</tr>
			<script type="text/javascript">crearMarcador('${sede.nombre }', ${sede.latitud } , ${sede.longitud } );</script>
		</c:forEach>
	</tbody>
</table>
<a href="${pageContext.request.contextPath}/sede/crear"
	class="btn btn-primary" role="button">Alta Sede</a>
<div id="map"></div>

<script async defer
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyALdnqGLwYolrMF5GK9cLQVPBu8iBDV4Ck&callback=initMap">
</script>
