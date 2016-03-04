<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<tags:template>
	<jsp:attribute name="body">
<div class="container">
<div class="page-header well">
  <h1>Comedor Universitario UNLP <small> Bienvenido!</small>
				</h1>
</div>
<div class="row">
<br>
<div class="col-sm-offset-3 col-sm-8">
	<form action="${pageContext.request.contextPath}/login"
						method="POST" class="form-horizontal">
		<div class="form-group">
		<label class="col-sm-2 control-label">DNI</label> 
		<div class="col-sm-6">
								<input type="text" name="dni" class="form-control">
								</div>
		</div>
		<div class="form-group"> <label class="col-sm-2 control-label">Password</label>
		<div class="col-sm-6">
								<input type="password" name="contrasena" class="form-control">
							</div>
		</div>  
		<div class="form-group">
    		<div class="col-sm-offset-2 col-sm-4">
		<input type="submit" value="Ingresar"
									class="form-control btn btn-primary ">
							</div>
							</div>
	</form>
</div>
</div>
</div>
</jsp:attribute>
</tags:template>