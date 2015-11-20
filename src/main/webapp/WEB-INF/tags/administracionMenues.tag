
<%@ tag%>


<div>
	<table class="table">
		<tr>
			<td>Nombre</td>
			<td>Celiaco</td>
			<td>Diab&eacute;tco</td>
			<td>Hipertenso</td>
			<td>Intolerante a la Lactosa</td>
			<td>Detalle</td>
			<td>Modificar</td>
			<td>Eliminar</td>
		</tr>
		<tr>
			<td>Rizzoto</td>
			<td>Apto</td>
			<td>Apto</td>
			<td>Apto</td>
			<td>Apto</td>
			<td><a class="btn btn-warning" href="#">Detalle</a></td>
			<td><a class="btn btn-warning" href="#">Modificar</a></td>
			<td><a class="btn btn-danger botondelete" href="#">Eliminar</a></td>
		</tr>
		<tr>
			<td>Pastel de Papa</td>
			<td>Apto</td>
			<td>Apto</td>
			<td>Apto</td>
			<td>Apto</td>
			<td><a class="btn btn-warning" href="#">Detalle</a></td>
			<td><a class="btn btn-warning" href="#">Modificar</a></td>
			<td><a class="btn btn-danger botondelete" href="#">Eliminar</a></td>
		</tr>
		<tr>
			<td>Pasta</td>
			<td>Apto</td>
			<td>Apto</td>
			<td>Apto</td>
			<td>Apto</td>
			<td><a class="btn btn-warning" href="#">Detalle</a></td>
			<td><a class="btn btn-warning" href="#">Modificar</a></td>
			<td><a class="btn btn-danger botondelete" href="#">Eliminar</a></td>
		</tr>


	</table>

	<a href="${pageContext.request.contextPath}/admin/altaMenu"
		class="btn btn-primary" role="button">Alta Menu</a>
</div>