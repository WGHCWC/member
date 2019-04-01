<%@ page language="java" import="com.Bean.MemberInfo" pageEncoding="UTF-8" %>
<%@ include file="/header.jsp" %>
<%
    String path = request.getContextPath();
    String mail;
    String password;
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

    MemberInfo memberInfo = (MemberInfo) session.getAttribute("memberInfo");
    if (memberInfo == null) {
        mail = "";
        password = "";

    } else {
        mail = memberInfo.getMember_mail();
        password = memberInfo.getMember_password();
    }

%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>生物学会会员登录</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

</head>


<body>
<center>


    <br>
    <form method="post" action="SignInServlet" name="form1">
        <a>&nbsp;&nbsp;&nbsp;&nbsp;用户ID： <input id="name" type="text"
                                                value="<%=mail%>"
                                                name="member_mail"></a><br><br>
        <a>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;密码： <input id="password"
                                                     value="<%=password%>"
                                                     type="password"
                                                     name="member_password"><br></a><br>


        <p><input type="submit" value="登陆" name="login">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="reset" value="重置" name="reset"></p>

    </form>

    <br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/001.jpg" width="175" height="47"
                                                     alt=""
/>


</center>

</body>
</html>
