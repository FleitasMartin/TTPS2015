<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2>Tu saldo es: $<c:out value="${saldo }" /></h2>
<br>
<br>
<h4>Cargar saldo</h4>
<form method="post" action="${pageContext.request.contextPath}/user/saldo">
	<div class="form-group">
		<label>Monto</label> <input type="text" name="saldo"
			class="form-control" /><br>
	</div>
	<!-- <div class="form-group">
		<label>Forma de pago</label> <select class="form-control">
			<option>Mercado pago</option>
			<option>Pago facil</option>
		</select>
	</div> -->
	<input type="submit" value="Cargar saldo" class=" btn btn-success">
</form>