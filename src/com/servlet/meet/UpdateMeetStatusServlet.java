package com.servlet.meet;

import com.Bean.Meeting;
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
@WebServlet("/UpdateMeetStatusServlet")
public class UpdateMeetStatusServlet extends HttpServlet {


    /**
     * Constructor of the object.
     */
    public UpdateMeetStatusServlet() {
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
        Meeting info = null;
        try {
            String a=InputStreamUtils.getInputString(request.getInputStream());
            info = DB.gson().fromJson(a, Meeting.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(info!=null) {
      //      int i = MemUtils.updateStatus(info.getId(),info.getStatus(), SQL.updateMeetById);
//            if(i==1){
//                out.println("success");
//            }

        }
        out.flush();
        out.close();

    }


}