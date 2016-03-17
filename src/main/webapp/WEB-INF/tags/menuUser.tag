<%@ tag%>
<%@ attribute name="id" fragment="true"%>
<ul class="nav nav-pills nav-stacked">
	<li><a href="${pageContext.request.contextPath}/user/perfil">Perfil</a></li>
	<li><a href="${pageContext.request.contextPath}/compra/listar">Mis compras
			</a></li>
	<li><a href="${pageContext.request.contextPath}/sugerencia/comentar">Comentar
			y sugerir</a></li>
	<li><a href="${pageContext.request.contextPath}/user/saldo">Saldo</a></li>
	<li><a href="${pageContext.request.contextPath}/user/mapa">Ubicacion
			sedes</a></li>
</ul>
<script>
	$(function() {
		//$('ul a[href^="/' + location.pathname.split("/")[1] + '"]').parent()
		$('ul a[href^="' + location.pathname+ '"]').parent()
				.addClass('active');
	});
</script>