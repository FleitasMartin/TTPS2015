<%@ tag%>
<%@ attribute name="id" fragment="true"%>
<ul class="nav nav-pills nav-stacked navbar navbar-default text-center">
	<li><a id="sede"
		href="${pageContext.request.contextPath}/sede/usuariosHabilitados"><strong>Usuarios
			habilitados</strong></a></li>
	<li><a id="sugerencia"
		href="${pageContext.request.contextPath}/sugerencia/buzonVirtualDeSede"><strong>Buz&oacute;n
			virtual</strong></a></li>
	<li><a id="pago"
		href="${pageContext.request.contextPath}/pago/listadoSemanal"><strong>Pagos
			semanales</strong></a></li>
	<!-- <li><a
		href="${pageContext.request.contextPath}/responsable/registroTickets">Registro
			tickets</a></li>-->
</ul>
<script>
	$('#body').css('background-image', 'url(${pageContext.request.contextPath}/img/verduras02.jpg)');
	
	var splitPath = location.pathname.split('/');
	
	$(function() {
		$('#' + splitPath[2]).parent()
		.addClass('active');
	});
</script>