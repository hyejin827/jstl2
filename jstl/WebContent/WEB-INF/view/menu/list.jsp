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
		<th>Menu Name</th>
		<th>Menu URL</th>
		<th>Menu Desc</th>
	</tr>
	<c:forEach items="${menuList}" var="m">
	<tr>
		<td>${m.mName}</td>
		<td>${m.mUrl}</td>
		<td>${m.mDesc}</td>
	</tr>
	</c:forEach>
</table>

<form>
	<input type="text" name="deleteStr" id="deleteStr" placeholder="삭제할 이름">
	<input type="submit" value="삭제"> <br>
</form>

<input type="text" placeholder="Menu Name">
<input type="text" placeholder="Menu URL">
<input type="text" placeholder="Menu Desc">
<input type="submit" value="추가"> <br>

</body>
</html>