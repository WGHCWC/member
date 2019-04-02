package com.servlet;

import com.Bean.MemberInfo;
import com.utils.DB;
import com.Bean.LoginInfo;
import com.utils.MemUtils;
import com.utils.SQL;
import com.utils.InputStreamUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            info = DB.gson().fromJson(InputStreamUtils.getInputString(request.getInputStream()), LoginInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (MemUtils.checkPassword(info.getEmail(), info.getPassword())) {
            List<String> infos = MemUtils.searchByMail(info.getEmail());
            out.println(infos.get(0));
        }

        out.flush();
        out.close();

    }


}