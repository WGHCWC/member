<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<script >
    function alterName(formlogin) {
        var a;
        with (formlogin) {
            with (member_mail) {
                 if(value==null||value==""){
                   return false
                }
            }
            with(member_password){
                if(value==null||value==""){
                    return false
                }
            }

           return true

        }

    }




</script>
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>
<body>
<center>
    <a href="<%=basePath%>SignUp.jsp">注册</a><br/>
    <a href="<%=basePath%>SignIn.jsp">登录</a>


    <form method="post" action="<%=basePath%>MySignInServlet" onsubmit="return alterName(this)">
        用户名:<input type="text" value="zq" name="member_name"><br>
        密码:<input type="password" value="123" name="member_password"><br>
        <input type="submit" value="提交">
    </form>

</center>
</body>
</html>
