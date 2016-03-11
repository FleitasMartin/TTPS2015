<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<div class="form">
	<form method="post" action="${pageContext.request.contextPath}/user/editarPreferencias">
		<label>Caracteristicas</label> 
		<select multiple name="caracteristicas" id="caracteristicas" class="form-control">
			<c:forEach var="caracteristica" items="${caracteristicas}">
				<option value="${caracteristica.id }"><c:out value="${caracteristica.nombre }" /></option>
			</c:forEach>
			<c:forEach var="caracteristica" items="${usuario.caracteristica}">
				<option selected value="${caracteristica.id }"><c:out value="${caracteristica.nombre }" /></option>	
			</c:forEach>
		</select> 

		<input type="submit" value="Editar"
			class="form-control btn btn-success">
	</form>
</div>

<script type="text/javascript">
	var dual1 = $("#caracteristicas").bootstrapDualListbox();
</script>