import DAO.DAOUser;
import DAO.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

public class NFilter implements Filter {
    
    private static final boolean debug = true;
    private PreparedStatement pstmt;
    InitialContext ctx;
    DataSource ds;
    Connection con;
    Statement stmt;
    ResultSet rs;
    DAOUser userDao;
    User user;
    
    private FilterConfig filterConfig = null;
    
    public NFilter() {
    }    
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {  
        if (((HttpServletRequest) request).getSession().getAttribute("name_user") == null) {
            String username = ((HttpServletRequest) request).getRemoteUser(); 
            if (username != null) {        
                user = new User();
                try {
                    user = userDao.getUser(username);
                } catch (SQLException ex) {
                    Logger.getLogger(NFilter.class.getName()).log(Level.SEVERE, null, ex);
                }
                    ((HttpServletRequest) request).getSession()
                        .setAttribute("name_user", user);                          
            }         
        }
        chain.doFilter(request, response); 
    }    
   @Override
    public void destroy() {      
        this.filterConfig = null;    
    }
    @Override
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        try {
            ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Company");
            con = ds.getConnection();
            userDao = new DAOUser(con);
        } catch (NamingException ex) {
//            Logger.getLogger(Filter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
//            Logger.getLogger(Filter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }        
    
}
