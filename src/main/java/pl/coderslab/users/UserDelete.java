package pl.coderslab.users;

import pl.coderslab.jeeusercrud.UserDao;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserDelete", value = "/user/delete")
public class UserDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("user", new UserDao().read(Integer.parseInt(request.getParameter("id"))));

        getServletContext()
                .getRequestDispatcher("/users/confirmRemove.jsp")
                .forward(request, response);
    }
}