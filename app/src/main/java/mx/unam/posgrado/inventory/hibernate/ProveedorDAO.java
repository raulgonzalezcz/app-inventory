package mx.unam.posgrado.inventory.hibernate;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Objeto DAO para manipular la información de objetos tipo {@link Proveedor}
 * @author Raul Gonzalez Cruz
 * @version 1.0 
 * @since 24/11/2018
 *
 */
@SuppressWarnings("unchecked")
public class ProveedorDAO extends BaseHibernateDAO{
	private static final Logger logger = Logger.getLogger(ProveedorDAO.class);
	
	/**
	 * Query all proveedor objects
	 * @return List<Proveedor> object
	 */
	public List<Proveedor> getAllProveedores(){
		return (List<Proveedor>)(List<?>)findAll(Proveedor.class);
	}
	
	/**
	 * Query to add a new proveedor object
	 * @param proveedor
	 */
	public void saveProveedor(Proveedor proveedor) {
		super.save(proveedor);
	}
	
	/**
	 * Query to delete a specific proveedor object
	 * @param proveedor
	 */
	public void deleteProveedor(Proveedor proveedor) {
		super.delete(proveedor);
	}
	
	/**
	 * Query to get a specific proveedor object
	 * @param proveedor_id
	 * @return proveedor object
	 */
	public Proveedor getProveedorById(int proveedor_id){
		return (Proveedor) findById(Proveedor.class, proveedor_id);
	}
	
	/**
	 * Query to update a specific proveedor object
	 * @param proveedor
	 */
	public void updateProveedor(Proveedor proveedor) {
		super.saveOrUpdate(proveedor);
	}
}

