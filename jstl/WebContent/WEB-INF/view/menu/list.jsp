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
메뉴리스트

<table border="1" cellspacing="0" cellpadding="0">
	<tr>
		<th>Menu Number</th>
		<th>Menu Name</th>
		<th>Menu URL</th>
		<th>Menu Desc</th>
		<th></th>
	</tr>
	<c:forEach items="${menuList}" var="m">
	
	<tr>
		<form action="/view/update">
			<td>${m.mNum}</td>
			<td>${m.mName}</td>
			<td>${m.mUrl}</td>
			<td>${m.mDesc}</td>
			<td><input type="submit" value="수정" ></td>
		</form>
	</tr>
	</c:forEach>
</table>
<br>

<form>
	<input type="text" name="deleteStr" id="deleteStr" placeholder="삭제할 이름">
	<input type="submit" value="삭제">
</form>

<form>
	<input type="text" name="insertN" placeholder="Menu Name">
	<input type="text" name="insertU" placeholder="Menu URL">
	<input type="text" name="insertD" placeholder="Menu Desc">
	<input type="submit" value="추가">
</form>

<form>
	<input type="text" size="6" name="updateNum" placeholder="수정할 번호">
	<input type="text" name="updateN" placeholder="Menu Name">
	<input type="text" name="updateU" placeholder="Menu URL">
	<input type="text" name="updateD" placeholder="Menu Desc">
	<input type="submit" value="수정">
</form>

</body>
</html>