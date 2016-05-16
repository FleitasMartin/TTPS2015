<%@ tag%>
<%@ attribute name="body" fragment="true"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<html >

<head>

<tags:headTemplate />

</head>

<body id="body" background="${pageContext.request.contextPath}/img/puerta.jpg" style="background-repeat: no-repeat; 
		background-position: center center;background-attachment : fixed;background-size: cover; "> 

	<jsp:invoke fragment="body" />

</body>

</html>