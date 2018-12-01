package mx.unam.posgrado.inventory.hibernate;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Objeto DAO para manipular la información de objetos tipo {@link Producto}
 * @author Raul Gonzalez Cruz
 * @version 1.0 
 * @since 24/11/2018
 *
 */
@SuppressWarnings("unchecked")
public class ProductoDAO extends BaseHibernateDAO{
	private static final Logger logger = Logger.getLogger(ProductoDAO.class);
	
	/**
	 * Query all producto objects
	 * @return List<Producto> object
	 */
	public List<Producto> getAllProductos(){
		return (List<Producto>)(List<?>)findAll(Producto.class);
	}
	
	/**
	 * Query to add a new producto object
	 * @param producto
	 */
	public void saveProducto(Producto producto) {
		super.save(producto);
	}
	
	/**
	 * Query to delete a specific producto object
	 * @param producto
	 */
	public void deleteProducto(Producto producto) {
		super.delete(producto);
	}
	
	/**
	 * Query to get a specific producto object
	 * @param producto_id
	 * @return producto object
	 */
	public Producto getProductoById(int producto_id){
		return (Producto) findById(Producto.class, producto_id);
	}
	
	/**
	 * Query to update a specific producto object
	 * @param producto
	 */
	public void updateProducto(Producto producto) {
		super.saveOrUpdate(producto);
	}
}

