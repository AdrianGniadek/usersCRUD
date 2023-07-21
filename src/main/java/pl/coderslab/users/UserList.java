package pl.coderslab.users;

import pl.coderslab.jeeusercrud.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/user/list")
public class UserList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
//        userDao.create(new User( "test", "test", "test"));
//        List<User> users = List.of(
//                new User( "test", "test", "test"),
//                new User( "test1", "test1", "test1"),
//                new User( "test2", "test2", "test2")
//        );
        request.setAttribute("users", new UserDao().findAll());
        getServletContext().getRequestDispatcher("/users/list.jsp").forward(request, response);
    }
}