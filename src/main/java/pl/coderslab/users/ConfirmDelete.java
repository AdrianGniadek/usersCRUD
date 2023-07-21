package pl.coderslab.users;

import pl.coderslab.jeeusercrud.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ConfirmDelete", value = "/accept/remove")

public class ConfirmDelete extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("Remove".equals(request.getParameter("submit"))) {
            new UserDao().delete(Integer.parseInt(request.getParameter("id")));
            response.sendRedirect("/user/list");
        } else {
            response.sendRedirect("/user/list");
        }
    }
}