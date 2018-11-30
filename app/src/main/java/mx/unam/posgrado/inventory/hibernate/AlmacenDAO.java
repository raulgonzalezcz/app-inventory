package mx.unam.posgrado.inventory.hibernate;

import org.apache.log4j.Logger; 
import java.util.List;
 
@SuppressWarnings("unchecked")
public class AlmacenDAO extends BaseHibernateDAO{ 
	private static final Logger logger = Logger.getLogger(AlmacenDAO.class);
	/**
	 * Listado de todos las marcas almacenados en la tabla
	 * @return
	 */
	public List<Almacen> getAllAlmacenes(){
		return (List<Almacen>)(List<?>)findAll(Almacen.class);
	}

	public void saveAlmacen(Almacen almacen) {
		super.save(almacen);
	}

	public Almacen getAlmacenById(int id){
		return (Almacen) findById(Almacen.class, id);
	}

	public void deleteAlmacenById(Almacen almacen) {

		super.deleteById(almacen);
	}

	public void updateAlmacen(Almacen almacen) {

		super.saveOrUpdate(almacen);
	}

	/**
	 * Query for the primary key
	 * @param id
	 * @return
	 */
	public Almacen findById(int id) {
		return (Almacen) findById(Almacen.class, id);
	}
}