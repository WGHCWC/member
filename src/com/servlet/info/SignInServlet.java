package com.servlet.info;

import com.Bean.MemberInfo;
import com.Bean.MyResult;
import com.utils.DB;
import com.Bean.LoginInfo;
import com.utils.MemUtils;
import com.utils.InputStreamUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignInServlet extends HttpServlet {

    private PrintWriter out;

    /**
     * Constructor of the object.
     */
    public SignInServlet() {
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
        LoginInfo info = null;
        try {
            String a = InputStreamUtils.getInputString(request.getInputStream());
            info = DB.gson().fromJson(a, LoginInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        MyResult<MemberInfo> infoMyResult = new MyResult<>();
        if (MemUtils.checkPassword(info.getEmail(), info.getPassword())) {
            List<String> infos = MemUtils.searchByMail(info.getEmail());

            infoMyResult.setData(DB.gson().fromJson(infos.get(0),MemberInfo.class));
            infoMyResult.setCode(200);
            String a = DB.gson().toJson(infoMyResult, MyResult.class);
            out.println(a);
        } else {
            infoMyResult.setCode(400);
            infoMyResult.msg = "密码错误";
            out.println(DB.gson().toJson(infoMyResult, MyResult.class));
        }

        out.flush();
        out.close();

    }


}
