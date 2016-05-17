<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag language="java" pageEncoding="UTF-8"%>

<div class="row">
	<div class="col-md-6">
		<div class="row">
			<h2 class="col-md-offset-3 col-md-6">
				<span class="label label-info"> <span
					class="glyphicon glyphicon-user" aria-hidden="true"></span> Datos de <c:out
						value="${usuario.tipo }" /> </span>
			</h2>
		</div>
		<div class="col-md-6 text-right">
			<h3>
				<span class="label label-default">Nombre completo</span>
			</h3>
			<h3>
				<span class="label label-default">D.N.I.</span>
			</h3>
			<h3>
				<span class="label label-default">Facultad</span>
			</h3>
			<h3>
				<span class="label label-default">Tel&eacute;fono</span>
			</h3>
			<h3>
				<span class="label label-default">Email</span>
			</h3>
			<h3>
				<span class="label label-default">Domicilio</span>
			</h3>
			<h3>
				<span class="label label-default">Saldo</span>
			</h3>
		</div>
		<div class="col-md-6 text-left">
			<h3>
				<span class="label label-success"> <c:out
						value="${usuario.nombre }" /> <c:out value="${usuario.apellido }" />
				</span>
			</h3>
			<h3>
				<span class="label label-success"> <c:out
						value="${usuario.dni }" />
				</span>
			</h3>
			<h3>
				<span class="label label-success"> <c:out
						value="${usuario.facultad }" />
				</span>
			</h3>
			<h3>
				<span class="label label-success"> <c:out
						value="${usuario.telefono }" />
				</span>
			</h3>
			<h3>
				<span class="label label-success"> <c:out
						value="${usuario.email }" />
				</span>
			</h3>
			<h3>
				<span class="label label-success"><c:out
						value="${usuario.domicilio }" /> </span>
			</h3>
			<h3>
				<span class="label label-success"> <span
					class="glyphicon glyphicon-usd" aria-hidden="true"></span> <c:out
						value="${usuario.saldo }" />
				</span>
			</h3>
		</div>
	</div>
	<div class="col-md-offset-1 col-md-4">
		<div class="row">
			<h2 class="text-left col-md-12">
				<span class="label label-info">Caracter&iacute;sticas <span
					class="glyphicon glyphicon-leaf" aria-hidden="true"></span>
				</span>
			</h2>
		</div>
		<c:forEach var="caracteristica" items="${usuario.caracteristica}">
			<div class="row">
				<h3 class="text-left col-md-offset-1 col-md-12">
					<span class="label label-success"><c:out
							value="${caracteristica.nombre }" /> <span
						class="glyphicon glyphicon-ok"> </span> </span>
				</h3>
			</div>
		</c:forEach>
		<div class="row">
			<a href="${pageContext.request.contextPath}/user/editarPreferencias"
				class="btn btn-warning col-md-4 col-md-offset-2" role="button"
				style="margin-top: 5%;"> <strong>Modificar</strong> <span
				class="glyphicon glyphicon-pencil" aria-hidden="true"> </span>
			</a>
		</div>
	</div>

	<div class="row ">
		<div class="form">
			<form method="post"
				action="${pageContext.request.contextPath}/user/saldo">
				<div class="form-group col-md-12" style="margin-top: 2%;">
					<h3 class="text-right control-label col-md-2">
						<label> <span class="label label-default"> Cargar
								saldo </span>
						</label>
					</h3>
					<div class="col-md-2" style="margin-top: 1%;">
						<input type="text" name="saldo" class="form-control" />
					</div>
					<div class="col-md-1" style="margin-top: 1%;">
						<button type="submit" class="form-control btn btn-warning ">
							<span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span>
						</button>
					</div>
				</div>
			</form>
		</div>
	</div>

</div>