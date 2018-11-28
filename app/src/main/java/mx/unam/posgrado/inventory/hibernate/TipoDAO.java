package mx.unam.posgrado.inventory.hibernate;

import java.util.List;
import org.apache.log4j.Logger;

import org.hibernate.Criteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 * Objeto DAO para manipular la información de objetos tipo {@link Tipo}
 * @author Raul Gonzalez Gonzalez
 * @version 1.0 
 * @since 24/11/2018
 *
 */
@SuppressWarnings("unchecked")
public class TipoDAO extends BaseHibernateDAO{
	/**
	 * Query by Example (QBE)
	 * @param tipo
	 * @return
	 */
	private static final Logger logger = Logger.getLogger(TipoDAO.class);
	
	/**
	 * 
	 * @return
	 */
	public List<Tipo> getAllTipos(){
		return (List<Tipo>)(List<?>)findAll(Tipo.class);
	}
	
	public void saveTipo(Tipo tipo) {
		super.save(tipo);
	}
	
	public void deleteTipo(Tipo tipo) {
		super.delete(tipo);
	}
	
	public Tipo getTipoById(int tipo_id){
		return (Tipo) findById(Tipo.class, tipo_id);
	}
	
	public void updateTipo(Tipo tipo) {

		super.saveOrUpdate(tipo);
	}
}
