package com.servlet;

import com.utils.DB;
import com.Bean.SQL;
import com.Bean.SignUpInfo;
import com.utils.InputStreamUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpServlet extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public SignUpServlet() {
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

        SignUpInfo info = null;
        try {
            info = DB.gson().fromJson(InputStreamUtils.getInputString(request.getInputStream()), SignUpInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        PreparedStatement pstm = DB.getPrepareStmt(SQL.checkEmail);
        try {
            pstm.setString(1, info.getEmail());

            ResultSet rs = DB.executeQuery(pstm);
            List<SignUpInfo> infos=new ArrayList<>();
            for(int i=0;i<3;i++)
                infos.add(info);
            if (rs.next()) {
                out.println(DB.gson().toJson(infos));
                out.flush();
                out.close();
            } else {
                out.println("成功");
                out.flush();
                out.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        out.flush();
        out.close();

    }


}