<%@ tag%>
<%@ attribute name="id" fragment="true"%>
<ul class="nav nav-pills nav-stacked">
	<li><a
		href="${pageContext.request.contextPath}/sede/usuariosHabilitados">Usuarios
			habilitados a comprar</a></li>
	<li><a
		href="${pageContext.request.contextPath}/sugerencia/buzonVirtualDeSede">Buz&oacute;n
			virtual</a></li>
	<li><a
		href="${pageContext.request.contextPath}/pago/listadoSemanal">Compras
			de men&uacute;es semanales</a></li>
	<li><a
		href="${pageContext.request.contextPath}/responsable/registroTickets">Registro
			tickets</a></li>
</ul>
<script>
	$(function() {
		$('ul a[href^="' + location.pathname + '"]').parent()
				.addClass('active');
	});
</script>