<%@ tag%>
<%@ attribute name="id" fragment="true"%>
<ul class="nav nav-pills nav-stacked navbar navbar-default text-center">
	<li class="text-center"><a id="user" href="${pageContext.request.contextPath}/user/perfil"><strong>Perfil</strong></a></li>
	<li class="text-center"><a id="compra" href="${pageContext.request.contextPath}/compra/listar"><strong>Compras</strong>
			</a></li>
	<li class="text-center"><a id="sugerencia" href="${pageContext.request.contextPath}/sugerencia/comentar"><strong>Sugerir</strong></a></li>
	<li class="text-center"><a id="sede" href="${pageContext.request.contextPath}/sede/listar"><strong>Sedes</strong></a></li>
</ul>
<script>
	$('#body').css('background-image', 'url(${pageContext.request.contextPath}/img/salon.jpeg)');
	
	var splitPath = location.pathname.split('/');
	
	$(function() {
		$('#' + splitPath[2]).parent()
		.addClass('active');
	});
</script>