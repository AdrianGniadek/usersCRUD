package pl.coderslab.users;

import pl.coderslab.jeeusercrud.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "UserView", value = "/user/view/{id}")
@WebServlet(name = "UserView", value = "/user/view")
public class UserView extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("user", new UserDao().read(Integer.parseInt(request.getParameter("id"))));

        getServletContext()
                .getRequestDispatcher("/users/view.jsp")
                .forward(request, response);
    }
}