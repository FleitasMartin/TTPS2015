<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<div class="form">
	<form method="POST" action="${pageContext.request.contextPath}/menu/crear">
		<div class="form-group">
			<label for="exampleInputEmail1">Nombre</label> <input type="text"
				class="form-control" id="nombreMenu" name="nombre">
		</div>
		<label>Caracteristicas</label> 
		<select multiple name="caracteristicas" id="caracteristicas"class="form-control">
		<c:forEach var="caracteristica" items="${caracteristicas}">
			<option value="${caracteristica.id }"><c:out value="${caracteristica.nombre }" /></option>
		</c:forEach>	
		</select> <label>Bebidas</label> <select multiple name="bebidas" id="bebidas"
			class="form-control">
			<c:forEach var="componente" items="${componentes}">
				<c:if test="${componente.tipo == 'bebida'}">
					<option value="${componente.id }"><c:out value="${componente.nombre }" /></option>
				</c:if>
			</c:forEach>
		</select> <label>Entradas</label> <select multiple name="entradas" id="entradas"
			class="form-control">
			<c:forEach var="componente" items="${componentes}">
				<c:if test="${componente.tipo == 'entrada'}">
					<option value="${componente.id }"><c:out value="${componente.nombre }" /></option>
				</c:if>
			</c:forEach>
		</select> 
		<label>Platos</label> 
		<select multiple name="platos" id="platos"
			class="form-control">
			<c:forEach var="componente" items="${componentes}">
				<c:if test="${componente.tipo == 'plato'}">
					<option value="${componente.id }"><c:out value="${componente.nombre }" /></option>
				</c:if>
			</c:forEach>
		</select> 
		<label>Postres</label> 
		<select multiple name="postres" id="postres"
			class="form-control">
			<c:forEach var="componente" items="${componentes}">
				<c:if test="${componente.tipo == 'postre'}">
					<option value="${componente.id }"><c:out value="${componente.nombre }" /></option>
				</c:if>
			</c:forEach>
		</select> 
		<input type="submit" value="Crear"
			class="form-control btn btn-success">
	</form>
</div>
<script type="text/javascript">
	var dual1 = $("#caracteristicas").bootstrapDualListbox();
	var dual2 = $("#bebidas").bootstrapDualListbox();
	var dual3 = $("#entradas").bootstrapDualListbox();
	var dual4 = $("#platos").bootstrapDualListbox();
	var dual5 = $("#postres").bootstrapDualListbox();
</script>