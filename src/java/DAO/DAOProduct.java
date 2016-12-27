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

public class DAOProduct {
    
    PreparedStatement pstmt;
    ResultSet rs;
    InitialContext ctx;
    DataSource ds;
    Connection con;
    Statement stmt;

    public DAOProduct() throws NamingException, SQLException {
        ArrayList<Product> products;
        ctx = new InitialContext();
        ds = (DataSource) ctx.lookup("java:comp/env/jdbc/company");
        con = ds.getConnection();
    }       

    public void UpDate(String Name, String Material) throws SQLException {
        pstmt = con.prepareStatement("UPDATE Product set Material  = ? WHERE Name = ?;");
        pstmt.setString(2, Material);
        pstmt.setString(1, Name);
        pstmt.executeUpdate();
    }
    
     public ArrayList<Product> Show() throws SQLException, IOException{
        ArrayList<Product> products = new ArrayList<Product>();
        String query = "select * from Product";
        pstmt = con.prepareStatement(query);
        rs = pstmt.executeQuery();
        System.out.println("Name Material Location Description");
        Product product;
        while (rs.next()) {
            product = new Product();
            product.setName(rs.getString(1)); 
            product.setMaterial(rs.getString(2));
            product.setLocation(rs.getString(3));
            product.setDescription(rs.getString(4));
            products.add(product);
        }
        return products;
    }
    
    public void Insert(String Name, String Material,
                        String Location, String Description) throws SQLException, IOException
    { 
        pstmt = con.prepareStatement("INSERT INTO Product VALUES (? ,?, ?, ?);");
        pstmt.setString(1, Name);
        pstmt.setString(2,Material);
        pstmt.setString(3,Location);
        pstmt.setString(4,Description);
        pstmt.executeUpdate();
    }
    
    public void Delete(String Name) throws SQLException, IOException
    {
        pstmt = con.prepareStatement("DELETE FROM Product WHERE Name = ?;");
        pstmt.setString(1, Name);
        pstmt.executeUpdate();
    }  
}
