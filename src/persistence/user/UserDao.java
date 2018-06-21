package persistence.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import persistence.connection.GenericDao;
import persistence.connection.iGenericDao;

public class UserDao implements iUserDao{

    private Connection connection;
    
    public UserDao () {
        iGenericDao gDao = new GenericDao();
        try {
            setConnection(gDao.getConnection());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void validar(User user, HttpServletRequest request,  HttpServletResponse response) throws SQLException, IOException {
        String sql = "SELECT * FROM user where user=? AND password=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, user.getUser());
        System.out.println(user.getUser());
        ps.setString(2, user.getPassword());
        System.out.println(user.getPassword());
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()) {
            HttpSession sessao = request.getSession();
            //sessao.setAttribute("usuario", user);
            //sessao.setAttribute("info", request.getRemoteAddr());
            String rd = (String) sessao.getAttribute("redirect");
            if(rd == null ) {
                //response.sendRedirect("http://localhost:8080/Chamados/Index.jsp");
                System.out.println("Valido");
            //}else {
                //response.sendRedirect(rd);
            }
        }else {
                    //response.sendRedirect("http://localhost:8080/Chamados/Login.jsp");
                    System.out.println("InValido");
        }
        rs.close();
        ps.close();
    }
    
    @Override
    public void inserir(User user) throws SQLException {
        String sql = "INSERT INTO user VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, user.getNome());
        ps.setString(2, user.getEmail());
        ps.setString(3, user.getUser());
        ps.setString(4, user.getPassword());
        ps.setString(5, user.getStatus());
        ps.execute();
        ps.close();
    }
    
    @Override
    public List<User> listar() throws SQLException{
        List<User> list = new ArrayList<User>();
        String sql = "SELECT * FROM user";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            User user = new User(rs.getString("nome"),rs.getString("email"), rs.getString("user"), rs.getString("password"), rs.getString("status"));
            list.add(user);
        }
        return list;
    }
    
    private void setConnection(Connection connection) {
        this.connection = connection;
        
    }

    
}



