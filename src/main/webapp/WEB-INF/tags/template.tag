<%@ tag%>
<%@ attribute name="body" fragment="true"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<html >
<head>

<style>
#map {
	width: 600px;
	height: 500px;
}
</style>
<tags:headTemplate />
</head>
<body background="${pageContext.request.contextPath}/img/fondo2.jpg" style="background-repeat: no-repeat; 
		background-position: center center;background-attachment : fixed;background-size: cover; "> 
	<jsp:invoke fragment="body" />
</body>
</html>