<%@page import="com.iot.test.vo.Customer"%>
<%@page import="java.util.ArrayList"%>
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
<body>
<%
String orderStrs = request.getParameter("orderStrs");
String orderTypes = request.getParameter("orderTypes");
if(orderStrs==null){
	orderStrs = "cutomerid, customername, city, country";
	orderTypes = "asc, asc, asc, asc";
}
String params = "&orderStrs="+orderStrs + "&orderTypes="+orderTypes;
%>
고객리스트
<table border="1" cellspacing="0" cellpadding="0">
	<tr>
		<th><a href="${root}/view/customer/list?order=customerid<%=params%>">CustomerID</a></th>
		<th><a href="${root}/view/customer/list?order=customername<%=params%>">CustomerName</a></th>
		<th><a href="${root}/view/customer/list?order=city<%=params%>">City</a></th>
		<th><a href="${root}/view/customer/list?order=country<%=params%>">Country</a></th>
	</tr>
	<c:if test="${customerList eq null}">
		<tr>
			<td colspan="4" align="center">고객리스트가 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach items="${customerList}" var="customer">
		<tr>
			<td>${customer.customerID}</td>
			<td>${customer.customerName}</td>
			<td>${customer.city}</td>
			<td>${customer.country}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>