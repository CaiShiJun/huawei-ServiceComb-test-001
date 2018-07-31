<html>
<body>

<%
    String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>

<li><a href="<%=contextPath%>/startServiceCombServlet" target="_blank">startServiceCombServlet</a></li>

</body>
</html>
