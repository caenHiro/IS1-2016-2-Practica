
package MB;

import Modelo.LogginDaoHibernate;
import DAO.Loggin;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 *
 * @author CAEN
 */

@ManagedBean
@RequestScoped
public class MBUsuarios {

    private String nombre = ""; 
    private String apellidoP = ""; 
    private String apellidoM =""; 
    private String pass ="";
    private String loggin ="";
    private String mensaje ="";
    private String tmpLoggin = "";
    private String tmpPass = "";
    /**
     * Creates a new instance of MBUsuarios
     */
    public MBUsuarios() {
       
    }
    
    
    public void actualizaCampos(){
    tmpLoggin = this.loggin;
    tmpPass = this.pass;        
    
    }
    
  public void compara(){
//    SessionFactory factory; 
//         try{
//         factory = new Configuration().configure().buildSessionFactory();
//      }catch (Throwable ex) { 
//         System.err.println("Failed to create sessionFactory object." + ex);
//         throw new ExceptionInInitializerError(ex); 
//      }
//        
//    
//       Session session = factory.openSession();
//      Transaction tx = null;
//      try{
//         tx = session.beginTransaction();
//         String sql = "SELECT * FROM loggin where login ='" + this.loggin + "' and pass = '" + this.pass +"'";
//         SQLQuery query = session.createSQLQuery(sql);
//         query.addEntity(Loggin.class);
//         List userList = query.list();
//         tx.commit();
//         
//         if (userList!= null) {
//              return true;
//          }else{
//             this.setMensaje("El usuario o la contraseña no es valido") ;
//          return false;
//          }
//         
//      }catch (HibernateException e) {
//         if (tx!=null) tx.rollback();
//        this.setMensaje("El usuario o la contraseña no es valido") ;
//        return false ; 
//      }finally {
//         session.close(); 
//      }
      System.out.println("aqui");
      LogginDaoHibernate user = new LogginDaoHibernate();
     
           System.out.println("aqui1");
          
      List<Loggin> listUser = user.findAll();
        System.out.println("finAll");
         for (Loggin tmpUser : listUser) {
            
             System.out.println(tmpUser.toString());
             System.out.println(tmpUser.getLogin());
             System.out.println(tmpLoggin);
             System.out.println(tmpUser.getLogin().equals(tmpLoggin));
              System.out.println(tmpUser.getPass());
             System.out.println(tmpUser.getPass().equals(tmpPass));
         }
         
      for (Loggin tmpUser : listUser) {
            System.out.println("fore");
          if (tmpUser.getLogin().equals(this.loggin) && tmpUser.getPass().equals(this.pass)) {
              System.out.println("dentro del if");
              this.mensaje = "El usuario fue valido";
//              return true;
          }
          
      }
        this.mensaje = "El usuario o la contraseña no es valido";
//        return false;
  }
  
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidoP
     */
    public String getApellidoP() {
        return apellidoP;
    }

    /**
     * @param apellidoP the apellidoP to set
     */
    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    /**
     * @return the apellidoM
     */
    public String getApellidoM() {
        return apellidoM;
    }

    /**
     * @param apellidoM the apellidoM to set
     */
    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the loggin
     */
    public String getLoggin() {
        return loggin;
    }

    /**
     * @param loggin the loggin to set
     */
    public void setLoggin(String loggin) {
        this.loggin = loggin;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
}
