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

public class DAOClient {
    PreparedStatement pstmt;
    ResultSet rs;
    InitialContext ctx;
    DataSource ds;
    Connection con;
    Statement stmt;

    public DAOClient() throws NamingException, SQLException {
        //this.con = con;
        ArrayList<Client> clients;
        ctx = new InitialContext();
        ds = (DataSource) ctx.lookup("java:comp/env/jdbc/company");
        con = ds.getConnection();
    }       

    public DAOClient(Connection conn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void UpDate(int id, String Company) throws SQLException {
        //Scanner in = new Scanner(System.in);
        //System.out.println("\nВведите поля idordering, Quartity");
        pstmt = con.prepareStatement("UPDATE Client set Name_Company  = ? WHERE idclient = ?;");
        pstmt.setInt(2, id);
        pstmt.setString(1, Company);
        pstmt.executeUpdate();
    }
    
     public ArrayList<Client> Show() throws SQLException, IOException{
        ArrayList<Client> clients = new ArrayList<Client>();
        String query = "select * from Client";
        pstmt = con.prepareStatement(query);
        rs = pstmt.executeQuery();
        System.out.println("ID Surname Name Middlename Company Legal_data ");
        Client client;
        while (rs.next()) {
            client = new Client();
            client.setIDClient(rs.getInt(1)); 
            client.setSurnameClient(rs.getString(2));
            client.setNameClient(rs.getString(3));
            client.setMiddlenameClient(rs.getString(4));
            client.setName_Company(rs.getString(5));
            client.setLegal_data(rs.getString(6));
            clients.add(client);
        }
        return clients;
    }
    
    public void Insert(int ID, String Surname, String Name, String Middlename,
                        String Company, String Legal_data) throws SQLException, IOException
    { 
        pstmt = con.prepareStatement("INSERT INTO Client VALUES (?,?, ?, ?, ?, ?);");
        pstmt.setInt(1,ID);
        pstmt.setString(2,Surname);
        pstmt.setString(3, Name);
        pstmt.setString(4,Middlename);
        pstmt.setString(5,Company);
        pstmt.setString(6,Legal_data);
        pstmt.executeUpdate();
    }
    
    public void Delete(int id) throws SQLException, IOException
    {
        Scanner in = new Scanner(System.in);
        //System.out.println("\nВведите поле idordering");
        pstmt = con.prepareStatement("DELETE FROM Client WHERE idclient = ?;");
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }
}
