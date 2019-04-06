package com.servlet.info;

import com.utils.MyResult;
import com.utils.DB;
import com.utils.MemUtils;
import com.utils.SQL;
import com.Bean.MemberInfo;
import com.utils.InputStreamUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpServlet extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public SignUpServlet() {
        super();
    }

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    /**
     * The doGet method of the servlet. <br>
     * <p>
     * This method is called when a form has its tag value method equals to get.
     *
     * @param request  the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws IOException if an error occurred
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        doPost(request, response);

    }

    /**
     * The doPost method of the servlet. <br>
     * <p>
     * This method is called when a form has its tag value method equals to post.
     *
     * @param request  the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws IOException if an error occurred
     */

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {


        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        MemberInfo info = null;
        try {
            String a = InputStreamUtils.getInputString(request.getInputStream());
            info = DB.gson().fromJson(a, MemberInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        MyResult<String> myResult = new MyResult<>();

        List<String> infos = MemUtils.searchByMail(info.getMail(),SQL.checkEmail,MemberInfo.class);
        if (infos != null) {
            myResult.setCode(400);
            myResult.msg = "用户已存在";
        } else {
            int num = MemUtils.insertMember(info, SQL.insertMember);
            if (num != 1) {
                myResult.setCode(500);
                myResult.msg = "注册失败，联系管理员。。";
            } else {
                myResult.setCode(200);
                myResult.setData(MemUtils.searchByMail(info.getMail(),SQL.checkEmail,MemberInfo.class).get(0));
            }

        }
        String a=DB.gson().toJson(myResult, MyResult.class);
        out.println(a);
        out.flush();
        out.close();

    }


}
