<%@ tag%>
<table class="table">
	<thead>
		<tr>
			<th>Nombre de usuario</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Rol</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>Usuario1</td>
			<td>Juan</td>
			<td>Perez</td>
			<td>Admin</td>
			<td>
				<form action="">
					<input type="submit" class="btn btn-danger botondelete"
						value="Eliminar" />
				</form>
			</td>
			<td><a class="btn btn-warning"
				href="${pageContext.request.contextPath}/admin/userEdit/">Editar</a></td>
		</tr>
		<tr>
			<td>Usuario2</td>
			<td>Juana</td>
			<td>Perez</td>
			<td>Responsable</td>
			<td>
				<form action="">
					<input type="submit" class="btn btn-danger botondelete"
						value="Eliminar" />
				</form>
			</td>
			<td><a class="btn btn-warning"
				href="${pageContext.request.contextPath}/admin/userEdit/">Editar</a></td>
		</tr>
		<tr>
			<td>Usuario3</td>
			<td>Pablo</td>
			<td>Perez</td>
			<td>Responsable</td>
			<td>
				<form action="">
					<input type="submit" class="btn btn-danger botondelete"
						value="Eliminar" />
				</form>
			</td>
			<td><a class="btn btn-warning"
				href="${pageContext.request.contextPath}/admin/userEdit/">Editar</a></td>
		</tr>
		<tr>
			<td>Usuario4</td>
			<td>Agustina</td>
			<td>Perez</td>
			<td>Admin</td>
			<td>
				<form action="">
					<input type="submit" class="btn btn-danger botondelete"
						value="Eliminar" />
				</form>
			</td>
			<td><a class="btn btn-warning"
				href="${pageContext.request.contextPath}/admin/userEdit/">Editar</a></td>
		</tr>
	</tbody>
</table>
<a href="${pageContext.request.contextPath}/admin/altaUsuario" class="btn btn-primary" role="button">Alta Usuario</a>

