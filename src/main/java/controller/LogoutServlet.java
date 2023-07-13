package controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        req.getRequestDispatcher("link.jsp").include(req, resp);

        Cookie ck[] = req.getCookies();
        for(Cookie cookie: ck){
          if(cookie.getName().equals("name")){
              cookie.setMaxAge(0);
              resp.addCookie(cookie);
              break;
          }
        }

        pw.print("You are successfully logged out!");
    }
}
