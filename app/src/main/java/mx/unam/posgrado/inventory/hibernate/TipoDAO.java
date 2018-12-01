package mx.unam.posgrado.inventory.hibernate;

import java.util.List;
import org.apache.log4j.Logger;

/**
 * Objeto DAO para manipular la información de objetos tipo {@link Tipo}
 * @author Raul Gonzalez Cruz
 * @version 1.0 
 * @since 24/11/2018
 *
 */
@SuppressWarnings("unchecked")
public class TipoDAO extends BaseHibernateDAO{
	private static final Logger logger = Logger.getLogger(TipoDAO.class);
	
	/**
	 * Query all tipo objects
	 * @return List<Tipo> object
	 */
	public List<Tipo> getAllTipos(){
		return (List<Tipo>)(List<?>)findAll(Tipo.class);
	}
	
	/**
	 * Query to add a new tipo object
	 * @param tipo
	 */
	public void saveTipo(Tipo tipo) {
		super.save(tipo);
	}
	
	/**
	 * Query to delete a specific tipo object
	 * @param tipo
	 */
	public void deleteTipo(Tipo tipo) {
		super.delete(tipo);
	}
	
	/**
	 * Query to get a specific tipo object
	 * @param tipo_id
	 * @return tipo object
	 */
	public Tipo getTipoById(int tipo_id){
		return (Tipo) findById(Tipo.class, tipo_id);
	}
	
	/**
	 * Query to update a specific tipo object
	 * @param tipo
	 */
	public void updateTipo(Tipo tipo) {
		super.saveOrUpdate(tipo);
	}
	
	/**
	 * Query for the primary key
	 * @param id
	 * @return
	 */
	public Tipo findById(int id) {
		return (Tipo) findById(Tipo.class, id);
	}
}
