<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<div class="form">
	<form method="post"
		action="${pageContext.request.contextPath}/sugerencia/comentar">
		<div class="col-md-12">
			<div class="form-group col-md-8">
				<h3 class="text-center col-md-3 control-label">
					<label for="sedeId"><span class="label label-default">&iquest;Dirigida
							a qu&eacute; sede&#63; <span class="glyphicon glyphicon-tags"
							aria-hidden="true"></span> </span></label>
				</h3>
				<div class="col-md-offset-2 col-md-6" style="margin-top: 2%;">
					<select class="form-control" name="sedeId">
						<option value=""></option>
						<c:forEach var="sede" items="${sedes}">
							<option value="${sede.id }">${sede.nombre }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="col-md-2">
				<button type="submit" class="form-control btn btn-warning "
					style="margin-top: 10%;">
					<strong>Enviar</strong> <span class="glyphicon glyphicon-send"
						aria-hidden="true"></span>
				</button>
			</div>
			<div class="form-group col-md-8">
				<div>
					<h3 class="text-center col-md-4 control-label">
						<label><span class="label label-default">&iquest;Acerca
								de qu&eacute;&#63; <span class="glyphicon glyphicon-share-alt"
							aria-hidden="true"></span> </span></label>
					</h3>
					<div class="col-md-offset-1 col-md-7" style="margin-top: 2%;">
						<input type="text" name="tipoSugerencia" class="form-control" />
					</div>
				</div>
			</div>
		</div>
		<div class="form-group col-md-10">
			<h3 class="text-right col-md-3 control-label">
				<label><span class="label label-default">Sugerencia <span
						class="glyphicon glyphicon-comment" aria-hidden="true"></span></span></label>
			</h3>
			<div class="col-md-offset-1 col-md-8" style="margin-top: 2%;">
				<textarea class="form-control" name="message" rows="10" cols="30"></textarea>
			</div>
		</div>
	</form>
</div>

<script type="text/javascript">
	$('#tituloDePagina').append('<span class="glyphicon glyphicon-paperclip"></span> Realizar una sugerencia');
	$('#tituloDePagina').show();
</script>