package DAO;
// Generated 12/04/2016 11:37:48 AM by Hibernate Tools 4.3.1



/**
 * Loggin generated by hbm2java
 */
public class Loggin  implements java.io.Serializable {


     private int idl;
     private Usuarios usuarios;
     private String login;
     private String pass;

    public Loggin() {
    }

	
    public Loggin(int idl) {
        this.idl = idl;
    }
    public Loggin(int idl, Usuarios usuarios, String login, String pass) {
       this.idl = idl;
       this.usuarios = usuarios;
       this.login = login;
       this.pass = pass;
    }
   
    public int getIdl() {
        return this.idl;
    }
    
    public void setIdl(int idl) {
        this.idl = idl;
    }
    public Usuarios getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPass() {
        return this.pass;
    }
    
    public void setPass(String pass) {
        this.pass = pass;
    }




}

