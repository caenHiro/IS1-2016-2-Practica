package MB;

import Modelo.LogginDaoHibernate;
import Modelo.UsuarioDaoHibernate;
import DAO.Loggin;
import DAO.Usuarios;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean

public class LoginBean implements Serializable {

    private static final long serialVersionUID = -2152389656664659476L;
    private String nombre ;
    private String clave;
    private String saludo ; 

    /**
     *
     * @return
     */
    public String valida() {
        FacesMessage msg = null;
         FacesContext context = FacesContext.getCurrentInstance();
        LogginDaoHibernate user = new LogginDaoHibernate();
        List<Loggin> listUser = user.findAll();
        UsuarioDaoHibernate userU = new UsuarioDaoHibernate();
        List<Usuarios> listUserU = userU.findAll();
        boolean bandera = false ; 
        Loggin tmp = new Loggin();
         for (Loggin tmpUser : listUser) {
          if (nombre != null && nombre.equals(tmpUser.getLogin()) && clave != null && clave.equals(tmpUser.getPass())){
              bandera = true;
              tmp = tmpUser;
              for (Usuarios listUserU1 : listUserU) {
                  if (listUserU1.getIdu() == tmpUser.getUsuarios().getIdu()) {
                     saludo = listUserU1.getNombre();
                      break;
                  }
              }
              break;
         }else{
                 bandera = false;
                 }
        
         }
         
        if (bandera) {
          
           context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenida", nombre));
                return "adentro";
        } else {
            
            context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Credenciales no válidas"));
            return "index";
        }
      
    }

    public String salir() {
        return "index";
    }
    
    
    
    


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the saludo
     */
    public String getSaludo() {
        return saludo;
    }

    /**
     * @param saludo the saludo to set
     */
    public void setSaludo(String saludo) {
        this.saludo = saludo;
    }

    
}
