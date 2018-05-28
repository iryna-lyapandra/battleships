package battleshipsJava.mvc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * Created by a on 5/28/2018.
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Properties prop = PropertyReader.readGameProperties();
        String allowedLoginName = prop.getProperty("login");
        String allowedPassword = prop.getProperty("password");

        PrintWriter out = response.getWriter();
        out.print(allowedLoginName + " " + allowedPassword);

//        if (username.equals(allowedLoginName) && password.equals(allowedPassword)) {
//            out.print("true");
//        }
//        else {
//            out.print("false");
//        }
    }
}
