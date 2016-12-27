package JavaBean;

import DAO.Client;
import DAO.DAOClient;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@ManagedBean(name="client")
@SessionScoped
public class ClientBean {
    
    private int ID;
    private String Surname;
    private String Name;
    private String Middlename;
    private String NameCompany  ;
    private String LegalData ;
    
    DAOClient dao;
    DAOClient ri;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getMiddlename() {
        return Middlename;
    }

    public void setMiddlename(String Middlename) {
        this.Middlename = Middlename;
    }

    public String getNameCompany() {
        return NameCompany;
    }

    public void setNameCompany(String NameCompany) {
        this.NameCompany = NameCompany;
    }

    public String getLegalData() {
        return LegalData;
    }

    public void setLegalData(String LegalData) {
        this.LegalData = LegalData;
    }
    
    public ClientBean() throws NamingException, SQLException 
    {
        this.dao = new DAOClient();
        
    }
    
    public void Insert() throws SQLException, IOException
    {
        dao.Insert(ID,Surname,Name,Middlename,NameCompany,LegalData);
    }
    
    public ArrayList<Client> Show() throws SQLException, IOException
    {
        return dao.Show();
    } 
    @PostConstruct
    public void init() {
        try 
        {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/company");
            Connection conn = ds.getConnection();
            ri = new DAOClient(conn);
        } 
        catch (NamingException | SQLException e)
        {}
    }
}
