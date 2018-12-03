package mx.unam.posgrado.inventory.hibernate;

import org.apache.log4j.Logger;
import java.util.List;
 

 /**
 * Objeto DAO para manipular la información de objetos tipo {@link Marca}
 * @author Andric Valdez Valenzuela
 * @version 1.0 
 * @since 24/11/2018
 *
 */

@SuppressWarnings("unchecked")
public class MarcaDAO extends BaseHibernateDAO{ 
	private static final Logger logger = Logger.getLogger(MarcaDAO.class);
	/**
	 * Listado de todos las marcas almacenados en la tabla
	 * @return
	 */
	public List<Marca> getAllMarcas(){
		return (List<Marca>)(List<?>)findAll(Marca.class);
	}

	public void saveMarca(Marca marca) {
		super.save(marca);
	}

	public Marca getMarcaById(int id){
		return (Marca) findById(Marca.class, id);
	}

	public void deleteMarcaById(Marca marca) {

		super.deleteById(marca);
	}

	public void updateMarca(Marca marca) {

		super.saveOrUpdate(marca);
	}

	/**
	 * Query for the primary key
	 * @param id
	 * @return
	 */
	public Marca findById(int id) {
		return (Marca) findById(Marca.class, id);
	}

}