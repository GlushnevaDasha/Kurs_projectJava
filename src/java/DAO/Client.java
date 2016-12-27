
package DAO;

public class Client {
    
    private int IDClient;
    private String SurnameClient;
    private String NameClient;
    private String MiddlenameClient;
    private String Name_Company  ;
    private String Legal_data ;
    
    public Client() {
    }
    
    public int getIDClient() {
        return IDClient;
    }

    public void setIDClient(int IDClient) {
        this.IDClient = IDClient;
    }

    public String getSurnameClient() {
        return SurnameClient;
    }

    public void setSurnameClient(String SurnameClient) {
        this.SurnameClient = SurnameClient;
    }

    public String getNameClient() {
        return NameClient;
    }

    public void setNameClient(String NameClient) {
        this.NameClient = NameClient;
    }

    public String getMiddlenameClient() {
        return MiddlenameClient;
    }

    public void setMiddlenameClient(String MiddlenameClient) {
        this.MiddlenameClient = MiddlenameClient;
    }

    public String getName_Company() {
        return Name_Company;
    }

    public void setName_Company(String Name_Company) {
        this.Name_Company = Name_Company;
    }

    public String getLegal_data() {
        return Legal_data;
    }

    public void setLegal_data(String Legal_data) {
        this.Legal_data = Legal_data;
    }
}
