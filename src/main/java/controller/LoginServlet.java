package controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        if(password.equals("123")){

            pw.println("Logined as"+ userName);

            Cookie cookie = new Cookie("cookieName", userName);
           // resp.addCookie(cookie);

            req.getRequestDispatcher("index.jsp").include(req, resp);


        }
        else{
            pw.println("Password Worng!");
            resp.sendRedirect("login.jsp");
        }


    }
}
