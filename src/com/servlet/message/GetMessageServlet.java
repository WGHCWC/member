package com.servlet.message;

import com.Bean.Message;
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

@WebServlet("/GetMessageServlet")
public class GetMessageServlet extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public GetMessageServlet() {
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
        MyResult<List<Message>> myResult=new MyResult();

        List<String> msg=MemUtils.searchAll(SQL.searchAllMessage, Message.class);

        if(msg!=null){
            myResult.code=200;
            List<Message> msgs=new ArrayList<>();
            for (int i=msg.size()-1;i>=0;i--){
                Message msge=DB.gson().fromJson(msg.get(i),Message.class);
                msgs.add(msge);

            }
            myResult.setData(msgs);
        }else {
            myResult.code=400;
            myResult.msg="暂无数据";
        }


        String a=DB.gson().toJson(myResult, MyResult.class);
        out.println(a);


        out.flush();
        out.close();

    }


}