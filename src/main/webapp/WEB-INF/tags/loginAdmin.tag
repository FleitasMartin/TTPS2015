<%@ tag language="java" pageEncoding="ISO-8859-1"%>


<div class="form">
	<form action="${pageContext.request.contextPath}/login/admin"
		method="POST">
		<label>DNI</label> <input type="text" name="dni"><br> <label>Password</label>
		<input type="password" name="contrasena"><br> <input type="submit"
			value="Ingresar" class="form-control btn btn-primary">
	</form>
</div>
