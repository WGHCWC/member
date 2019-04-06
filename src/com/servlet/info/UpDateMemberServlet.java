package com.servlet.info;

import com.Bean.MemberInfo;
import com.utils.MyResult;
import com.utils.DB;
import com.utils.InputStreamUtils;
import com.utils.MemUtils;
import com.utils.SQL;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpDateMemberServlet")
public class UpDateMemberServlet extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public UpDateMemberServlet() {
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
        MyResult<String> myResult =new MyResult<>();
        try {
            String a= InputStreamUtils.getInputString(request.getInputStream());
            info = DB.gson().fromJson(a, MemberInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
            int num=MemUtils.insertMember(info,SQL.updateMemberInfo);
            if(num==0){
                myResult.code=400;
                myResult.msg=" 操作失误，联系管理员...";
            }else {
                myResult.code=200;
                List<String> a=MemUtils.searchByMail(info.getMail(),SQL.checkEmail,MemberInfo.class);
                myResult.setData(a.get(0));

        }
        out.println(DB.gson().toJson(myResult));
        out.flush();
        out.close();
    }

}