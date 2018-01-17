<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>인덱스</title>
</head>
<body>
<%
String uri = request.getRequestURI();
if(uri.equals(root+"/")){
	response.sendRedirect(root+"/view/index");
}
%>
</body>
</html>