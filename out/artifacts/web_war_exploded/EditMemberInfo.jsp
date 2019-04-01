<%@ page import="com.Bean.MemberInfo" %>
<%@ page import="java.util.List" %><%--
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

    function validate_required(field, alertTxt) {
        with (field) {
            if (value == null || value == "") {
                alert(alertTxt);
                return false
            } else {
                return true
            }
        }
    }

    function validate_email(field, alertTxt) {
        with (field) {
            apos = value.indexOf("@")
            dotpos = value.lastIndexOf(".")
            if (apos < 1 || dotpos - apos < 2) {
                alert(alertTxt);
                return false
            } else {
                return true
            }
        }
    }


    function validate_form(thisform) {
        with (thisform) {
            if (validate_email(member_mail, "Illegal mail-address!") == false) {
                member_mail.focus();
                return false
            } else if (validate_required(member_address, "Adress must be filled out!") == false) {
                member_address.focus();
                return false
            } else if (validate_required(member_phone, "Phone must be filled out!") == false) {
                member_phone.focus();
                return false
            } else if (validate_required(member_job, "Position must be filled out!") == false) {
                member_job.focus();
                return false
            }
        }
    }

</script>

<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    MemberInfo memberInfo = (MemberInfo) session.getAttribute("EditMemberInfo");


%>
<form action="UpdateEditMemberServlet" onsubmit="return validate_form(this)">
    <table border="1" align="center" cellspacing="1" cellpadding="5" width="550" height="150">
        <tr>
            <td colspan="7">
                &nbsp;姓名:<font color="red"><%=memberInfo.getMember_name()%>
            </font>
                &nbsp; 级别：<a id="level">
                <script> transLevel("<%=memberInfo.getLevel()%>")</script>

                <select id="select">
                    <option value="-1">拒绝申请</option>
                    <option value="1">初级会员</option>
                    <option value="99">管理员</option>

                </select>
            </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="yellow" width="10%">
                id:
            </td>
            <td align="left" width="90%">
                <input type="text" value="<%=memberInfo.getMember_id()%>" name="member_id"
                       aria-selected="false" readonly="readonly">

            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="yellow" width="10%">
                电话:
            </td>
            <td align="left" width="90%">
                <input type="text" value="<%=memberInfo.getMember_phone()%>" name="member_phone">


            </td>
        </tr>

        <tr>
            <td align="right" bgcolor="yellow" width="10%">
                邮箱:
            </td>
            <td align="left" width="90%">
                <input type="text" value="<%=memberInfo.getMember_mail()%>" name="member_mail">


            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="yellow" width="10%">
                性别:
            </td>
            <td align="left" width="90%">
                <input type="text" value="<%=memberInfo.getMember_sexual()%>" name="member_sexual">

            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="yellow" width="10%">
                职务:
            </td>
            <td align="left" width="90%">
                <input type="text" value="<%=memberInfo.getMember_job()%>" name="member_job">

            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="yellow">
                地址:
            </td>
            <td align="left" width="90%">
                <input type="text" value="<%=memberInfo.getMember_address()%>"
                       name="member_address">

            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="yellow" width="10%">
                个人简介:
            </td>
            <td align="left" width="90%">
                <input type="text" value="<%=memberInfo.getMember_introduce()%>"
                       name="member_introduce">


            </td>
        </tr>
        <tr>
            <td>

            </td>
            <td>
                <p><input align="" type="submit" value="提交" name="login">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </p>
            </td>
        </tr>

    </table>
</form>
</body>
</html>
