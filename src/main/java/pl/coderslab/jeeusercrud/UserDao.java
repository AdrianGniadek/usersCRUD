package pl.coderslab.jeeusercrud;

import pl.coderslab.jeeusercrud.User;
import pl.coderslab.utils.DbUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static final String CREATE_USER_QUERY =
            "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
    private static final String READ_USER_QUERY =
            "SELECT * FROM users WHERE id = ?";
    private static final String UPDATE_USER_QUERY =
            "UPDATE users SET username = ?, email = ?, password = ? WHERE id = ?";
    private static final String DELETE_USER_QUERY =
            "DELETE FROM users WHERE id = ?";
    private static final String FIND_ALL_USERS_QUERY =
            "SELECT * FROM users";

    public User create(User user) throws SQLException {
        PreparedStatement preStmt =
                DbUtil.connect().prepareStatement(CREATE_USER_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
        preStmt.setString(1, user.getUserName());
        preStmt.setString(2, user.getEmail());
        preStmt.setString(3, user.getPassword());
        preStmt.executeUpdate();
        ResultSet rs = preStmt.getGeneratedKeys();
        if (rs.next()) {
            user.setId(rs.getInt(1));
        }
        return user;

    }

    public User read(int userId) {
        try (PreparedStatement preStmt = DbUtil.connect().prepareStatement(READ_USER_QUERY)) {
            preStmt.setInt(1, userId);
            ResultSet rs = preStmt.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                return user;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(User user) {
        try (PreparedStatement preStmt = DbUtil.connect().prepareStatement(UPDATE_USER_QUERY)) {
            preStmt.setString(1, user.getUserName());
            preStmt.setString(2, user.getEmail());
            preStmt.setString(3, user.getPassword());
            preStmt.setInt(4, user.getId());
            preStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User delete(int userId) {
        try (PreparedStatement preStmt = DbUtil.connect().prepareStatement(DELETE_USER_QUERY)) {
            User userToDelete = read(userId);
            preStmt.setInt(1, userId);
            preStmt.executeUpdate();
            return userToDelete;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<User> findAll() {
        try (PreparedStatement preStmt = DbUtil.connect().prepareStatement(FIND_ALL_USERS_QUERY)) {
            ResultSet rs = preStmt.executeQuery();
            List<User> users = new ArrayList<>();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}