<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.Bean.*" %>
<%@ include file="/header.jsp" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>管理员页面</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>
<%@ include file="/SiteNavigator.jsp" %>

<body background="images/001.jpg">

<%@ include file="/memberInfo.jsp" %>


<center>日期：
    <%@ include file="/footer.jsp" %>
</center>
</body>
</html>
