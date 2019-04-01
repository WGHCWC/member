<%@ page import="com.Bean.MemberInfo" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    List<MemberInfo> memberInfo = (List<MemberInfo>) session.getAttribute("memberInfos");

%>
<html>
<head>
    <title>会员管理</title>
</head>
<center>
    <body>
    <div align="" style="width:1000px; height:450px; overflow:scroll;">

        <table border="1" cellspacing="1" cellpadding="5" width="950">

            <tr bgcolor="#cd853f">
                <td>姓名</td>
                <td>id</td>
                <td>邮箱</td>
                <td>电话</td>
                <td>职业</td>
                <td>性别</td>
                <td>操作</td>

            </tr>
            <%
                for (MemberInfo info : memberInfo) {
                    if (info.getMember_id() == 0) {
                        continue;
                    }
            %>
            <tr>
                <td>
                    <%=info.getMember_name()%>
                </td>
                <td>
                    <%=info.getMember_id()%>
                </td>
                <td>
                    <%=info.getMember_mail()%>
                </td>
                <td>
                    <%=info.getMember_phone()%>
                </td>
                <td>
                    <%=info.getMember_job()%>
                </td>
                <td>
                    <%=info.getMember_sexual()%>
                </td>
                <td>
                    <a href=<%=request.getContextPath()+"/FindEditMemberServlet?member_mail"%>=<%=info.getMember_mail()%>>
                        修改</a>
                </td>


            </tr>
            <%
                }
            %>
        </table>
    </div>

    </body>
</center>
</html>
