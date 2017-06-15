<%@ page  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<%
	String str = request.getParameter("flag");
%>
<h1><%=str == null%></h1>
<h1><%=str%></h1>
<body>
	<form action="NewFile.jsp" method="post">
		设为组长: <input type="checkbox" name="flag" id="flag"> 
		<input type="submit" id="subBut" name="subBut" value="提交">
	</form>
</body>
</html>