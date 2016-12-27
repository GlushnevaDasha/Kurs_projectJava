package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAOUser {
    
    PreparedStatement pstmt;
    ResultSet rs;
    InitialContext ctx;
    DataSource ds;
    Connection con;
    Statement stmt;

    public DAOUser(Connection con) throws NamingException, SQLException {
        this.con = con;
//        ArrayList<User> users;
//        ctx = new InitialContext();
//        ds = (DataSource) ctx.lookup("java:comp/env/jdbc/company");
//        con = ds.getConnection();
    }       

    public void UpDate(String Login, String password) throws SQLException {
        pstmt = con.prepareStatement("UPDATE User set password  = ? WHERE Login = ?;");
        pstmt.setString(2, password);
        pstmt.setString(1, Login);
        pstmt.executeUpdate();
    }
    
    public ArrayList<User> Show() throws SQLException, IOException{
        ArrayList<User> users = new ArrayList<User>();
        String query = "select * from User";
        pstmt = con.prepareStatement(query);
        rs = pstmt.executeQuery();
        System.out.println("Surname Name Login Password");
        User user;
        while (rs.next()) {
            user = new User();
            user.setSurname(rs.getString(1)); 
            user.setName(rs.getString(2));
            user.setLogin(rs.getString(3));
            user.setPassword(rs.getString(4));
            users.add(user);
        }
        return users;
    }
    
     public User getUser(String name) throws SQLException, IOException{
        User user = new User();
        String query = "select * from User where Login = ?";
        pstmt = con.prepareStatement(query);
        pstmt.setString(1, name);        
        rs = pstmt.executeQuery();
        while (rs.next()) {
            user.setLogin(rs.getString(1));
            user.setPassword(rs.getString(2));
        }
        return user;
    }
    public void Insert(String Surname, String Name,
                        String Login, String password) throws SQLException, IOException
    { 
        pstmt = con.prepareStatement("INSERT INTO User VALUES (? ,?, ?, ?);");
        pstmt.setString(1, Surname);
        pstmt.setString(2,Name);
        pstmt.setString(3,Login);
        pstmt.setString(4,password);
        pstmt.executeUpdate();
    }
    
    public void Delete(String Login) throws SQLException, IOException
    {
        pstmt = con.prepareStatement("DELETE FROM User WHERE Login = ?;");
        pstmt.setString(1, Login);
        pstmt.executeUpdate();
    }   
    
}
