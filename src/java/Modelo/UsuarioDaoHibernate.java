package Modelo;

import DAO.Usuarios;
import java.util.List;


/**
 *
 * @author 
 */
public class UsuarioDaoHibernate extends AbstractDao {

    public UsuarioDaoHibernate() {
        super();
    }

    /**
     * Insert a new Usuario into the database.
     *
     * @param usuario
     */
    public void save(Usuarios usuario) throws DataAccessLayerException {
        super.save(usuario);
    }

    /**
     * Updates a new Usuario into the database.
     *
     * @param usuario
     */
    public void update(Usuarios usuario) throws DataAccessLayerException {
        super.update(usuario);
    }

    /**
     * Delete a detached Usuario from the database.
     *
     * @param usuario
     */
    public void delete(Usuarios usuario) throws DataAccessLayerException {
        super.delete(usuario);
    }

 
   

    /**
     * Lista todos los usuarios de la base de datos
     *
     * @return
     */
    public List findAll() throws DataAccessLayerException {
        return super.findAll(Usuarios.class);
    }
}
