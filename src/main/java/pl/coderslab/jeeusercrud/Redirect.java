package pl.coderslab.jeeusercrud;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//create a servlet that redirects localhost:8080 address to localhost:8080/appropriateAddress
@WebServlet(name = "Redirect", value = "/")
public class Redirect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/dashboard");
    }
}