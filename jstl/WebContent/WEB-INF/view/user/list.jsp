<%@page import="com.iot.test.vo.UserInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
String param = request.getParameter("param");
%>
<body>
<!-- useBean도 알아봥 -->
유저리스트<br>
<form>
	<input type="text" name="param" value="<%=param%>"> <input type="submit" value="검색">
</form>
<table border="1">
	<tr>
		<th>이름</th>
		<th>나이</th>
	</tr>
	<c:forEach items="${userList}" var="ui">
	<tr>
		<td>${ui.uiName}</td>
		<td>${ui.uiAge}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>