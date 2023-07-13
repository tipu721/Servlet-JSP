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
        PrintWriter  pw = resp.getWriter();

        req.getRequestDispatcher("link.jsp").include(req, resp);


        String userName = req.getParameter("userName");
        String pass = req.getParameter("password");

        if(pass.equals("admin123")){
            pw.print("You are successfully loged in");
            pw.print("<br> Wellcome "+userName);

            Cookie ck = new Cookie("name", userName);
            resp.addCookie(ck);
        }
        else{
            pw.print("User name or password is worng!");
            req.getRequestDispatcher("login.jsp").include(req, resp);
        }
        pw.close();
    }
}
