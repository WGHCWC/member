package com.servlet;

import com.utils.DB;
import com.utils.FiledsName;
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


        List<String> allInfo=MemUtils.searchAll(SQL.serachAllMember, FiledsName.getMemberName());
        if(allInfo==null){
            out.println("null");
        }else{
            String a=DB.gson().toJson(allInfo);
            out.println(a);
        }
        out.flush();
//        MemberInfo memberInfo1=new MemberInfo();
//        memberInfo1.setMail("1@3.com");
//        int a=MemUtils.insertMember(memberInfo1, SQL.insertMember);
  //      out.println(a);


        out.flush();
        out.close();

    }


}