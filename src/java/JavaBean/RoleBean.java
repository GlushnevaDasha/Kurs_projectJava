package JavaBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class RoleBean {

    private String Namerole;
    private String Login;

    public String getNamerole() {
        return Namerole;
    }

    public void setNamerole(String Namerole) {
        this.Namerole = Namerole;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }
    
    public RoleBean() {
    }
    
}
