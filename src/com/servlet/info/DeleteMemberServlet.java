package com.servlet.info;

import com.utils.MyResult;
import com.utils.DB;
import com.utils.InputStreamUtils;
import com.utils.MemUtils;
import com.utils.SQL;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteMemberServlet")
public class DeleteMemberServlet extends HttpServlet {


    /**
     * Constructor of the object.
     */
    public DeleteMemberServlet() {
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
        String a="";
        MyResult myResult=new MyResult();
        try {
          a =InputStreamUtils.getInputString(request.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(!a.isEmpty()) {
            int i = MemUtils.deleteByMail(a, SQL.delMember);
            if(i!=0){
                myResult.code=200;

            }else {
                myResult.code=400;
                myResult.msg="删除失败";
            }

        }
        a=DB.gson().toJson(myResult,MyResult.class);
        out.println(a);
        out.flush();
        out.close();

    }


}