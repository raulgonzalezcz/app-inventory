package mx.unam.posgrado.inventory.hibernate;

import org.apache.log4j.Logger;
import java.util.List;
 
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


}