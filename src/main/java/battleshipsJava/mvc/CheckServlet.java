package battleshipsJava.mvc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "CheckServlet")
public class CheckServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String guess = request.getParameter("guess");
        ShipManager checker = new ShipManager();
        String result = checker.checkUserGuess(guess);
        PrintWriter out = response.getWriter();
        out.print(result);
    }
}
