package com.servlet.reword;

import com.Bean.Article;
import com.Bean.Meeting;
import com.utils.MemUtils;
import com.utils.SQL;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PushArticleServlet")
public class PushArticleServlet extends HttpServlet {

    private Meeting meeting;

    /**
     * Constructor of the object.
     */
    public PushArticleServlet() {
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
        Article article = new Article();
        article.setTitle("苏州");
        article.setAuthor("ss00");
        article.setMain("1@1.com");
        article.setStatus("0");
        article.setId(null);

        int a = MemUtils.updateSQL(article, SQL.insertArticle);


        out.println(a);


        out.flush();
        out.close();

    }


}