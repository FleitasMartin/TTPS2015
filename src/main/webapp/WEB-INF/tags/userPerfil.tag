<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<table class="table">
	<thead>
		<tr>
			<th>D.N.I.</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Facultad</th>
			<th>Telefono</th>
			<th>Email</th>
			<th>Domicilio</th>
			<th>Tipo de usuario</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><c:out value="${usuario.dni }" /></td>
			<td><c:out value="${usuario.nombre }" /></td>
			<td><c:out value="${usuario.apellido }" /></td>
			<td><c:out value="${usuario.facultad }" /></td>
			<td><c:out value="${usuario.telefono }" /></td>
			<td><c:out value="${usuario.email }" /></td>
			<td><c:out value="${admin.domicilio }" /></td>
			<td><c:out value="${admin.tipo }" /></td>
		</tr>
	</tbody>
</table>

<h2>Mis Preferencias</h2>
<table class="table">

	<thead>
		<tr>
			<th>Vegetariano</th>
			<th>Celiaco</th>
			<th>Diab&eacute;tco</th>
			<th>Hipertenso</th>
			<th>Intolerante a la lactosa</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><span class="glyphicon glyphicon-ok"></span></td>
			<td><span class="glyphicon glyphicon-remove"></span></td>
			<td><span class="glyphicon glyphicon-remove"></span></td>
			<td><span class="glyphicon glyphicon-remove"></span></td>
			<td><span class="glyphicon glyphicon-remove"></span></td>
		</tr>
	</tbody>
</table>
<a href="#" class="btn btn-primary" role="button">Modificar
	preferencias</a>