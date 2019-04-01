<%--
  Created by IntelliJ IDEA.
  User: wghcwc
  Date: 19-2-20
  Time: 下午5:59
  To change this template use File | Settings | File Templates.
--%>
<%
String name;
String password;
name=(String)session.getAttribute("12");
password=(String)session.getAttribute("13");


%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="MySignInServlet">
    用户名:<input type="text" value="<%=name%>" name="member_name"><br>
    密码:<input type="password" value="<%=password%>" name="member_password"><br>
    <input type="submit" value="提交">

</form>
</body>
</html>
