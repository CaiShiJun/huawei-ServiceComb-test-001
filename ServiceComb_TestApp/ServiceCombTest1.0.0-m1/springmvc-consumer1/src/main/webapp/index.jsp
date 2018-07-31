<html>
<body>
<h2>Hello World!</h2>

<%
    String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>

<li><a href="<%=contextPath%>/springMVCTest/testRestTemplatePost" target="_blank">springMVCTest-testRestTemplatePost</a></li>
<li><a href="<%=contextPath%>/springMVCTest/testRpcReference" target="_blank">springMVCTest-testRpcReference</a></li>
<li><a href="<%=contextPath%>/jaxrsTest/testRestTemplatePost" target="_blank">jaxrsTest-testRestTemplatePost</a></li>
<li><a href="<%=contextPath%>/jaxrsTest/testRpcReference" target="_blank">jaxrsTest-testRpcReference</a></li>
<li><a href="<%=contextPath%>/transparentRPCAnnotationTest/testRpcReference" target="_blank">transparentRPCAnnotationTest-testRpcReference</a></li>
<li><a href="<%=contextPath%>/transparentRPCAnnotationTest/testXmlBeanUtils" target="_blank">transparentRPCAnnotationTest-testXmlBeanUtils</a></li>
<li><a href="<%=contextPath%>/transparentRPCXmlTest/testRpcReference" target="_blank">transparentRPCXmlTest-testRpcReference</a></li>
<li><a href="<%=contextPath%>/transparentRPCXmlTest/testXmlBeanUtils" target="_blank">transparentRPCXmlTest-testXmlBeanUtils</a></li>

</body>
</html>
