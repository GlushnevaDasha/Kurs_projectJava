package JavaBean;

import DAO.User;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name="UMB")
@SessionScoped
public class UserBean {

//    private String Surname;
//    private String Name;
//    private String Login;
//    private String password;
//
//    public String getSurname() {
//        return Surname;
//    }
//
//    public void setSurname(String Surname) {
//        this.Surname = Surname;
//    }
//
//    public String getName() {
//        return Name;
//    }
//
//    public void setName(String Name) {
//        this.Name = Name;
//    }
//
//    public String getLogin() {
//        return Login;
//    }
//
//    public void setLogin(String Login) {
//        this.Login = Login;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
    
    public UserBean() {
    }
    
    public User getUser(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        User user = (User)session.getAttribute("name_user");
        return user;
    }
}
