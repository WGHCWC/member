package com.servlet;

import com.Bean.Meeting;
import com.Bean.MemberInfo;
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

@WebServlet("/CreateMeetServlet")
public class CreateMeetServlet extends HttpServlet {

    private Meeting meeting;

    /**
     * Constructor of the object.
     */
    public CreateMeetServlet() {
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

        // String meet= InputStreamUtils.getInputString(request.getInputStream());

        //  Meeting meeting=DB.gson().fromJson(meet,Meeting.class);
        Meeting meeting = new Meeting();
        meeting.setAddress("苏州");
        meeting.setIntroduce("ss00");
        meeting.setMail("1@1.com");
        meeting.setName("kaihui");

        int a = MemUtils.insertMeeting(meeting, SQL.insertMeeting);


        out.println(a);


        out.flush();
        out.close();

    }


}