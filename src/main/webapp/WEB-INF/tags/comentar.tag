<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<h3>Sugerencia</h3>

<div class="form">
	<form method="post" action="${pageContext.request.contextPath}/sugerencia/comentar">
		<div class="form-group">
			<label>Nombre Usuario: <c:out value="${usuario.nombre}"></c:out></label> 
			
		</div>
		<div class="form-group">
			<label>Tipo de Sugerencia</label> 
			<input type="text" name="tipoSugerencia"class="form-control" /><br>
		</div>
		<div class="form-group">
			<label>Sede</label> <select class="form-control" name="sedeId">
				<option value=""></option>
				<c:forEach var="sede" items="${sedes}">
					<option value="${sede.id }">${sede.nombre }</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<textarea class="form-control" name="message" rows="10" cols="30"></textarea>
		</div>
		<input type="submit" value="Enviar"
			class="form-control btn btn-success">
	</form>
</div>