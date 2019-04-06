package com.servlet.info;

import com.Bean.MemberInfo;
import com.utils.MyResult;
import com.utils.DB;
import com.utils.MemUtils;
import com.utils.SQL;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetMemberServlet")
public class GetMemberServlet extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public GetMemberServlet() {
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
        MyResult<List<MemberInfo>> myResult = new MyResult<>();

        List<String> infos = MemUtils.searchAll(SQL.searchAllMember, MemberInfo.class);
        if (infos != null) {
            List<MemberInfo> memberInfos = new ArrayList<>();
            for (String info : infos) {
                MemberInfo memberInfo = DB.gson().fromJson(info, MemberInfo.class);
                memberInfos.add(memberInfo);
            }
            myResult.code = 200;
            myResult.setData(memberInfos);
        } else {
            myResult.code=400;
            myResult.msg="空";
        }
        out.println(DB.gson().toJson(myResult, MyResult.class));

        out.flush();
        out.close();

    }


}