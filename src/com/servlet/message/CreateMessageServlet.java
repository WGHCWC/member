package com.servlet.message;

import com.Bean.Meeting;
import com.Bean.Message;
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

@WebServlet("/CreateMessageServlet")
public class CreateMessageServlet extends HttpServlet {

    private Meeting meeting;

    /**
     * Constructor of the object.
     */
    public CreateMessageServlet() {
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
        MyResult myResult = new MyResult();
        Message msg = null;
        String a = "";
        try {
            a = InputStreamUtils.getInputString(request.getInputStream());
            msg = DB.gson().fromJson(a, Message.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (msg != null) {
            int col = MemUtils.updateSQL(msg, SQL.insertMessage);
            if (col == 1) {
                myResult.code = 200;

            } else {
                myResult.code = 400;
                myResult.msg = "添加失败";
            }
        }
        a = DB.gson().toJson(myResult, MyResult.class);
        out.println(a);


        out.flush();
        out.close();

    }


}