<%@ tag%>
<%@ attribute name="id" fragment="true"%>
<ul class="nav nav-pills nav-stacked">
	<li><a href="${pageContext.request.contextPath}/user/perfil">Perfil</a></li>
	<li><a href="${pageContext.request.contextPath}/compra/listar">Mis compras
			</a></li>
	<li><a href="${pageContext.request.contextPath}/sugerencia/comentar">Comentar
			y sugerir</a></li>
	<li><a href="${pageContext.request.contextPath}/user/saldo">Saldo</a></li>
	<li><a href="${pageContext.request.contextPath}/sede/listar">Ubicacion
			sedes</a></li>
</ul>
<script>
	$('#body').css('background-image', 'url(${pageContext.request.contextPath}/img/salon.jpeg)');
	$(function() {
		$('ul a[href^="' + location.pathname+ '"]').parent()
				.addClass('active');
	});
</script>