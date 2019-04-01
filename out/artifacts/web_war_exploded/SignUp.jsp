<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/header.jsp" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<SCRIPT LANGUAGE="JavaScript">
    function validate_required(field, alertTxt) {
        with (field) {
            if (value == null || value == "") {
                alert(alertTxt);
                return true;
            } else {
                return false
            }
        }
    }

    function validate_email(field, alertTxt) {
        with (field) {
            apos = value.indexOf("@")
            dotpos = value.lastIndexOf(".")
            if (apos < 1 || dotpos - apos < 2) {
                alert(alertTxt);
                return true
            } else {
                return false
            }
        }
    }

    function validate_password(field, field2, alertTxt) {
        var ps = field.value;
        var ps2 = field2.value;
        if (ps == ps2 && ps != null) {
            return false;
        } else {
            alert(alertTxt);

            return true;
        }

    }


    function validate_form(thisform) {
        with (thisform) {
            if (validate_required(member_name, "Name must be filled out!")) {
                member_name.focus();
                return false
            } else if (validate_email(member_mail, "Illegal mail-address!") ) {
                member_mail.focus();
                return false
            } else if (validate_required(member_address, "Adress must be filled out!") ) {
                member_address.focus();
                return false
            } else if (validate_required(member_phone, "Phone must be filled out!")) {
                member_phone.focus();
                return false
            } else if (validate_required(member_job, "Position must be filled out!")) {
                member_job.focus();
                return false
            } else if (validate_required(member_password, "Password must be filled out!") ) {
                member_password.focus();
                return false
            } else if (validate_password(member_password, member_RePassword, "Bad Re-input Password ") ) {
                member_RePassword.focus();
                return false
            }
        }
        return true;
    }
</SCRIPT>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>生物学会会员注册</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

</head>


<body>
<center>

    <%--onsubmit="return validate_form(this)"--%>
    <br> <%--换行--%>
    <form method="post" action="SignUpServlet" onsubmit="return validate_form(this)" name="form1">
        <a>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;邮箱： <input type="text" name="member_mail"><br></a><br>
        <a>&nbsp;&nbsp;&nbsp;&nbsp;姓名： <input type="text" name="member_name"></a><br><br>

        <a>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;地址： <input type="text"
                                                     name="member_address"><br></a><br>
        <a>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;电话： <input type="text"
                                                     name="member_phone"><br></a><br>
        <a>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;工作： <input type="text" name="member_job"><br></a><br>

        <a>&nbsp;&nbsp;&nbsp; 男： <input type="checkbox" name="member_sexual" checked></a>&nbsp;&nbsp;&nbsp;
        <a>&nbsp;&nbsp;&nbsp; 女： <input type="checkbox" name="member_sexual"><br></a><br>
        <a>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;密码： <input type="password" name="member_password"><br></a><br>
        <a> 确认密码： <input type="password" name="member_RePassword"><br></a><br>
        自我简介： <textarea cols="22" rows="4" maxlength="450" type="text"

                        name="member_introduce"></textarea><br><br>

        <p><input type="submit" value="注册" name="login">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="reset" value="重置" name="reset"></p>
    </form>
    <br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/001.jpg" width="175" height="47"
                                                     alt=""
/>


</center>

</body>
</html>
