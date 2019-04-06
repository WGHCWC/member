package com.servlet.reword;

import com.Bean.Article;
import com.utils.DB;
import com.utils.InputStreamUtils;
import com.utils.MemUtils;
import com.utils.MyResult;
import com.utils.SQL;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetMyArticleServlet")
public class GetMyArticleServlet extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public GetMyArticleServlet() {
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
        MyResult<List<Article>> myResult=new MyResult();
        String a="";
        try {
            a = InputStreamUtils.getInputString(request.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(!a.isEmpty()){

            List<String> arts = MemUtils.searchByMail(a, SQL.selectArtByEmail,Article.class);
            if(arts!=null){
                myResult.code=200;
                List<Article> art=new ArrayList<>();
                for (int i=arts.size()-1;i>=0;i--){
                    Article msge=DB.gson().fromJson(arts.get(i),Article.class);
                    art.add(msge);
                }
                myResult.setData(art);
            }else {
                myResult.code=400;
                myResult.msg="暂无数据";
            }


        }

        a=DB.gson().toJson(myResult, MyResult.class);
        out.println(a);


        out.flush();
        out.close();

    }


}