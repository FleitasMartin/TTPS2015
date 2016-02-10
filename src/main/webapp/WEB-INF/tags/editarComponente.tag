<%@ tag%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="form">
	<form method="POST" action="${pageContext.request.contextPath}/admin/editarComponente">
		<input type="hidden" value="${componente.id }" name="id">
		<div class="form-group">
			<label>Nombre</label> <input type="text" name="nombre"
				class="form-control" value="${componente.nombre }" /><br>
		</div>
		<input type="submit" value="Crear"
			class="form-control btn btn-success">
	</form>
</div>