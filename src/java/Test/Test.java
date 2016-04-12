package Test;

import Modelo.LogginDaoHibernate;
import Modelo.UsuarioDaoHibernate;
import DAO.Loggin;
import DAO.Usuarios;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author INE
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//         Set loggins = new HashSet(0);
//       loggins.add(10);
//      Usuarios usuarios = new Usuarios(10, "Carlos ", "Navarro", "Escalona", loggins);
//      
        UsuarioDaoHibernate daoU = new UsuarioDaoHibernate();
//      daoU.save(usuarios);
//          System.out.println("Todo salio bien =P");    
//      Loggin log = new Loggin(10, usuarios, "caen", "hola123");
//      
//      
//      
//      LogginDaoHibernate dao = new LogginDaoHibernate();
//      dao.save(log);
//        System.out.println("Todo salio bien =P");
//  

        System.out.println("***************************************");
        List<Usuarios> lista = daoU.findAll();
        for (Usuarios user : lista) {
            System.out.println(user.toString());
        }
        System.out.println("***************************************");
        System.out.println("***************************************");

        SessionFactory factory;
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String sql = "SELECT * FROM usuarios";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Usuarios.class);
            List userList = query.list();

            for (Iterator iterator = userList.iterator(); iterator.hasNext();) {
                Usuarios user = (Usuarios) iterator.next();
                System.out.print("Nombre : " + user.getNombre());
                System.out.print("Apellido Paterno: " + user.getApellidopaterno());
                System.out.println("Apellido Materno: " + user.getApellidopaterno());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
}
