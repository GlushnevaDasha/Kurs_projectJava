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

public class DAORole {
 
    PreparedStatement pstmt;
    ResultSet rs;
    InitialContext ctx;
    DataSource ds;
    Connection con;
    Statement stmt;

    public DAORole() throws NamingException, SQLException {
        ArrayList<Role> roles;
        ctx = new InitialContext();
        ds = (DataSource) ctx.lookup("java:comp/env/jdbc/company");
        con = ds.getConnection();
    }       

    public void UpDate(String Login, String Namerole) throws SQLException {
        pstmt = con.prepareStatement("UPDATE Role set Namerole  = ? WHERE Login = ?;");
        pstmt.setString(2, Namerole);
        pstmt.setString(1, Login);
        pstmt.executeUpdate();
    }
    
     public ArrayList<Role> Show() throws SQLException, IOException{
        ArrayList<Role> roles = new ArrayList<Role>();
        String query = "select * from Role";
        pstmt = con.prepareStatement(query);
        rs = pstmt.executeQuery();
        System.out.println("Login Role");
        Role role;
        while (rs.next()) {
            role = new Role();
            role.setNamerole(rs.getString(3));
            role.setLogin(rs.getString(4));
            roles.add(role);
        }
        return roles;
    }
    
    public void Insert(String Namerole, String Login) throws SQLException, IOException
    { 
        pstmt = con.prepareStatement("INSERT INTO Role VALUES (?, ?);");
        pstmt.setString(1,Namerole);
        pstmt.setString(2,Login);
        pstmt.executeUpdate();
    }
    
    public void Delete(String Login) throws SQLException, IOException
    {
        pstmt = con.prepareStatement("DELETE FROM Role WHERE Login = ?;");
        pstmt.setString(1, Login);
        pstmt.executeUpdate();
    }
}
