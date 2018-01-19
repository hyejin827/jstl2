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
<%
String param = request.getParameter("param");
%>
<body>
고객리스트

<script>
function getEl(id){
	return document.getElementById(id);
}
function checkValue(){
	var searchType = getEl("searchType").value.trim(); 
	var searchStr = getEl("searchStr").value.trim();
	
	if(searchType.length==0){
		alert("검색 종류 선택행");
		getEl("searchType").focus();
		return false;
	}
	if(searchStr.length<2){
		alert("2글자 이상 검색행");
		getEl("searchStr").focus();
		return false;
	}
	return true;
}
</script>

<form onsubmit="return checkValue()">
	<select name="searchType" id="searchType">
		<option value="">선택</option>
		<option value="customerName" ${param.searchType eq "customerName" ? "selected":""}>고객이름</option>
		<option value="city" ${param.searchType eq "city" ? "selected":""}>도시</option>
		<option value="country" ${param.searchType eq "country" ? "selected":"" }>나라</option>
	</select>
	<input type="text" name="searchStr" id="searchStr" value="${param.searchStr}">
	<input type="submit" value="검색">
</form>

<table border="1" cellspacing="0" cellpadding="0">
	<tr>
		<th><a href="${root}/view/customer/list?order=customerid">CustomerID</a></th>
		<th><a href="${root}/view/customer/list?order=customername">CustomerName</a></th>
		<th><a href="${root}/view/customer/list?order=city">City</a></th>
		<th><a href="${root}/view/customer/list?order=country">Country</a></th>
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