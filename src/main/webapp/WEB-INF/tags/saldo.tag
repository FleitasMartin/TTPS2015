<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-md-12">
	<div class="row">
		<h2>
			<span class="label label-default">Tu saldo es: $<c:out
					value="${saldo }" /></span>
		</h2>
	</div>
	<div class="form">
		<div class="col-md-12">
			<form method="post"
				action="${pageContext.request.contextPath}/user/saldo">
				<div class="form-group col-md-12">
					<h4 class="control-label col-md-2">
						<label><span class="label label-default">Cargar
								saldo</span></label>
					</h4>
					<div class="col-md-4">
					<input type="text" name="saldo" class="form-control" />
					</div>
					<input type="submit" value="Cargar saldo" class="col-md-3 btn btn-success">
				</div>
			</form>
		</div>
	</div>
</div>