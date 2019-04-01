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




</center>

</body>
</html>
