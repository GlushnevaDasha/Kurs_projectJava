package JavaBean;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class OrderingBean {

    private int IDOrdering;
    private Date StartDate;
    private Date StopDate;
    private int Client;
    private String Product;
    private int Number; 
    
    public String getProduct() {
        return Product;
    }

    public void setProduct(String Product) {
        this.Product = Product;
    }
    
    public OrderingBean() {
    }
    
    public int getIDOrdering() {
        return IDOrdering;
    }

    public void setIDOrdering(int IDOrdering) {
        this.IDOrdering = IDOrdering;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    public Date getStopDate() {
        return StopDate;
    }

    public void setStopDate(Date StopDate) {
        this.StopDate = StopDate;
    }

    public int getClient() {
        return Client;
    }

    public void setClient(int Client) {
        this.Client = Client;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }
      
}
