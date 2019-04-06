package com.servlet.reword;

import com.Bean.Article;
import com.Bean.Meeting;
import com.utils.DB;
import com.utils.InputStreamUtils;
import com.utils.MemUtils;
import com.utils.MyResult;
import com.utils.SQL;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
        Article article =null;
        MyResult<List<Article>> myResult=new MyResult();

        try {
            String a= InputStreamUtils.getInputString(request.getInputStream());
            article = DB.gson().fromJson(a, Article.class);
        } catch (Exception e) {
            e.printStackTrace();
        }



        if (article != null) {
            int a = MemUtils.updateSQL(article, SQL.insertArticle);
            if (a == 1) {
                myResult.code = 200;

            } else {
                myResult.code = 400;
                myResult.msg = "添加论文失败";
            }
        }
        String a = DB.gson().toJson(myResult, MyResult.class);
        out.println(a);
        out.flush();
        out.close();

    }


}