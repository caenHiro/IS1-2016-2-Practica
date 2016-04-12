package Modelo;

import DAO.Loggin;
import java.util.List;


/**
 *
 * @author 
 */
public class LogginDaoHibernate extends AbstractDao {

    public LogginDaoHibernate() {
        super();
    }

    /**
     * Insert a new Usuario into the database.
     *
     * @param login
     */
    public void save(Loggin login) throws DataAccessLayerException {
        super.save(login);
    }

    /**
     * Updates a new Usuario into the database.
     *
     * @param usuario
     */
    public void update(Loggin usuario) throws DataAccessLayerException {
        super.update(usuario);
    }

    /**
     * Delete a detached Usuario from the database.
     *
     * @param login
     */
    public void delete(Loggin login) throws DataAccessLayerException {
        super.delete(login);
    }

 
   

    /**
     * Lista todos los usuarios de la base de datos
     *
     * @return
     */
    public List findAll() throws DataAccessLayerException {
        return super.findAll(Loggin.class);
    }
}
