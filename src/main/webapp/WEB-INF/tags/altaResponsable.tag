<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<div class="form">
	<form method="POST"
		action="${pageContext.request.contextPath}/admin/altaResponsable">
		<div class="form-group">
			<label>Nombre</label> <input type="text" name="nombre"
				class="form-control" /><br>
		</div>
		<div class="form-group">
			<label>Apellido</label> <input type="text" name="apellido"
				class="form-control" /><br>
		</div>
		<div class="form-group">
			<label>DNI</label> <input type="number" name="dni"
				class="form-control" /><br>
		</div>
		<div class="form-group">
			<label>Contrase&ntilde;a</label> <input type="password"
				name="contrasena" class="form-control" /><br>
		</div>
		<div class="form-group">
			<label>Sede</label> <select class="form-control" name="sedeId">
				<c:forEach var="sede" items="${sedes}">
					<option value="${sede.id }">${sede.nombre }</option>
				</c:forEach>
			</select>
		</div>
		<input type="submit" value="Crear"
			class="form-control btn btn-success">
	</form>
</div>