package controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ProfileServlet extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        PrintWriter pw = resp.getWriter();

        req.getRequestDispatcher("link.jsp").include(req, resp);

        Cookie ck[]=req.getCookies();

        int f=0;
        for(Cookie cookie: ck){

            if(cookie.getName().equals("name")){
                pw.println("<b> Welcome to Profile</b>");
                pw.print("<b>Welcome, "+ cookie.getValue());
                f=1;
                break;
            }


        }
        if(f==0){

            pw.print("PLease login first");
            req.getRequestDispatcher("loging.html").include(req, resp);

        }

        pw.close();



    }
}
