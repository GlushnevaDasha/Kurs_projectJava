package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAOOrdering {
    PreparedStatement pstmt;
    ResultSet rs;
    InitialContext ctx;
    DataSource ds;
    Connection con;
    Statement stmt;

    public DAOOrdering() throws NamingException, SQLException {
        //this.con = con;
        ArrayList<Ordering> orderings;
        ctx = new InitialContext();
        ds = (DataSource) ctx.lookup("java:comp/env/jdbc/company");
        con = ds.getConnection();
    }       

    public void UpDate(int id, int Number) throws SQLException {
        Scanner in = new Scanner(System.in);
        //System.out.println("\nВведите поля idordering, Quartity");
        pstmt = con.prepareStatement("UPDATE Ordering set Number = ? WHERE idordering = ?;");
        pstmt.setInt(2, id);
        pstmt.setInt(1, Number);
        pstmt.executeUpdate();
    }
    
     public ArrayList<Ordering> Show() throws SQLException, IOException{
        ArrayList<Ordering> orderings = new ArrayList<Ordering>();
        String query = "select * from Ordering";
        pstmt = con.prepareStatement(query);
        rs = pstmt.executeQuery();
        System.out.println("ID Start Stop Client Product Number");
        Ordering ordering;
        while (rs.next()) {
            ordering = new Ordering();
            ordering.setIDOrdering(rs.getInt(1)); 
            ordering.setStartDate(rs.getDate(2));
            ordering.setStopDate(rs.getDate(3));
            ordering.setClient(rs.getInt(4));
            ordering.setProduct(rs.getString(5));
            ordering.setNumber(rs.getInt(6));
            orderings.add(ordering);
        }
        return orderings;
    }
    
    public void Insert(String start, String stop, int client, String product, 
                        int Number) throws SQLException, IOException
    { 
        pstmt = con.prepareStatement("INSERT INTO Ordering (StartDate, StopDate, Client, Product, Number) VALUES (?, ?, ?, ?, ?);");
        pstmt.setDate(1,java.sql.Date.valueOf(start));
        pstmt.setDate(2,java.sql.Date.valueOf(stop));
        pstmt.setInt(3, client);
        pstmt.setString(4,product);
        pstmt.setInt(5, Number);
        pstmt.executeUpdate();
    }
    
    public void Delete(int id) throws SQLException, IOException
    {
        Scanner in = new Scanner(System.in);
        //System.out.println("\nВведите поле idordering");
        pstmt = con.prepareStatement("DELETE FROM Ordering WHERE idordering = ?;");
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }
}
