<%@ page import="com.Bean.MemberInfo" %><%--
  Created by IntelliJ IDEA.
  User: wghcwc
  Date: 19-2-18
  Time: 下午5:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    function transLevel(level) {
        var l;
        switch (level) {
            case '1':
                l = "正式会员";
                break;
            case '99':
                l = "管理员";
                break;
            case '999':
                l = "会长";
                break;
            case '0':
                l = "预备会员(等待管理员认证)";
                break;
            case '-1':
                l = "预备会员(认证未通过)";
                break;

        }
        document.getElementById("level").innerHTML = l;

    }


</script>

<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    MemberInfo memberInfo = (MemberInfo) session.getAttribute("memberInfo");
%>
<table border="1" align="center" cellspacing="1" cellpadding="5" width="550" height="150">
    <tr>
        <td colspan="7">
            &nbsp;欢迎您:<font color="red"><%=memberInfo.getMember_name()%>
        </font>
            &nbsp; 级别：<a id="level">
            <script> transLevel("<%=memberInfo.getLevel()%>")</script>
        </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </td>
    </tr>
    <tr>
        <td align="right" bgcolor="yellow" width="10%">
            id:
        </td>
        <td align="left" width="90%">
            <%=memberInfo.getMember_id()%>
        </td>
    </tr>
    <tr>
        <td align="right" bgcolor="yellow" width="10%">
            电话:
        </td>
        <td align="left" width="90%">
            <%=memberInfo.getMember_phone()%>
        </td>
    </tr>

    <tr>
        <td align="right" bgcolor="yellow" width="10%">
            邮箱:
        </td>
        <td align="left" width="90%">
            <%=memberInfo.getMember_mail()%>
        </td>
    </tr>
    <tr>
        <td align="right" bgcolor="yellow" width="10%">
            性别:
        </td>
        <td align="left" width="90%">
            <%=memberInfo.getMember_sexual()%>
        </td>
    </tr>
    <tr>
        <td align="right" bgcolor="yellow" width="10%">
            职务:
        </td>
        <td align="left" width="90%">
            <%=memberInfo.getMember_job() %>
        </td>
    </tr>
    <tr>
        <td align="right" bgcolor="yellow">
            地址:
        </td>
        <td align="left" width="90%">
            <%=memberInfo.getMember_address()%>
        </td>
    </tr>
    <tr>
        <td align="right" bgcolor="yellow" width="10%">
            个人简介:
        </td>
        <td align="left" width="90%">

            <%=memberInfo.getMember_introduce()%>
        </td>
    </tr>

</table>
<br><br>
</body>
</html>
