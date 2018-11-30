package mx.unam.posgrado.inventory.actions;

import java.util.List;

import org.apache.log4j.Logger;

import mx.unam.posgrado.inventory.hibernate.Almacen;
import mx.unam.posgrado.inventory.hibernate.AlmacenDAO;
import mx.unam.posgrado.inventory.hibernate.Marca;
import mx.unam.posgrado.inventory.hibernate.MarcaDAO;
import mx.unam.posgrado.inventory.hibernate.Producto;
import mx.unam.posgrado.inventory.hibernate.ProductoDAO;
import mx.unam.posgrado.inventory.hibernate.Proveedor;
import mx.unam.posgrado.inventory.hibernate.ProveedorDAO;
import mx.unam.posgrado.inventory.hibernate.Tipo;
import mx.unam.posgrado.inventory.hibernate.TipoDAO;

/**
 * Class to establish actions for Producto object
 * @author Raul Gonzalez Cruz
 * @version 1.0 
 * @since 24/11/2018
 */
public class ProductoAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ProductoAction.class);
	
	private Producto producto;
	private List<Producto> productos;
	
	private String idTipo;
	private String idMarca;
	private String idAlmacen;
	private String idProveedor;
	
	// catálogo tipos
	private List<Tipo> tipos;
	// catálogo marcas
	private List<Marca> marcas;
	// catálogo almacenes
	private List<Almacen> almacenes;
	// catálogo proveedores
	private List<Proveedor> proveedores;

	/**
	 * Get all the producto objects from database
	 * @return "success" to display the home page for Producto class
	 */
	public String showProductoHome() {
		logger.debug("showProductoHome()");
		
		ProductoDAO productoDAO = new ProductoDAO();
		productos = productoDAO.getAllProductos();
		
		return "success";
	}
	
	/**
	 * Add a new producto object to database
	 * @param producto the new producto to add
	 * @return "success" to display the home page for Producto class
	 */
	public String agregarProducto() {
		logger.info("agregarProducto()");
		
		Tipo tipo = new Tipo();
		TipoDAO tipoDAO = new TipoDAO();
		tipo = tipoDAO.findById(Integer.parseInt(idTipo));
		
		Marca marca = new Marca();
		MarcaDAO marcaDAO = new MarcaDAO();
		marca = marcaDAO.findById(Integer.parseInt(idMarca));

		Almacen almacen = new Almacen();
		AlmacenDAO almacenDAO = new AlmacenDAO();
		almacen = almacenDAO.findById(Integer.parseInt(idAlmacen));
		
		Proveedor proveedor = new Proveedor();
		ProveedorDAO proveedorDAO = new ProveedorDAO();
		proveedor = proveedorDAO.findById(Integer.parseInt(idProveedor));
		
		ProductoDAO dao = new ProductoDAO();
		producto.setAlmacen(almacen);
		producto.setTipo(tipo);
		producto.setMarca(marca);
		producto.setProveedor(proveedor);
		logger.info("New producto object");
		logger.info(producto.toString());
		dao.saveProducto(producto);
		
		return "success";
	}
	
	/**
	 * Delete an specific producto object 
	 * @param producto the specific producto to delete
	 * @return "success" to display the home page for Producto class
	 */
	public String bajarProducto() {
		logger.info("bajarProducto()");
		
		ProductoDAO dao = new ProductoDAO();
		logger.info("Object information");
		logger.info(producto.toString());
		Producto completeProducto = dao.getProductoById(producto.getProducto_id());
		logger.info(completeProducto);
		
		dao.deleteProducto(completeProducto);
		
		return "success";
	}
	
	/**
	 * Update the data for a specific producto object
	 * @param producto the specific producto to update with new data
	 * @return "success" to display the home page for Producto class
	 */
	public String cambiarProducto() {
		logger.info("cambiarProducto()");
		
		Tipo tipo = new Tipo();
		TipoDAO tipoDAO = new TipoDAO();
		tipo = tipoDAO.findById(Integer.parseInt(idTipo));
		
		Marca marca = new Marca();
		MarcaDAO marcaDAO = new MarcaDAO();
		marca = marcaDAO.findById(Integer.parseInt(idMarca));

		Almacen almacen = new Almacen();
		AlmacenDAO almacenDAO = new AlmacenDAO();
		almacen = almacenDAO.findById(Integer.parseInt(idAlmacen));
		
		Proveedor proveedor = new Proveedor();
		ProveedorDAO proveedorDAO = new ProveedorDAO();
		proveedor = proveedorDAO.findById(Integer.parseInt(idProveedor));
		
		ProductoDAO dao = new ProductoDAO();
		producto.setAlmacen(almacen);
		producto.setTipo(tipo);
		producto.setMarca(marca);
		producto.setProveedor(proveedor);
		
		logger.info("Info object");
		logger.info(producto.toString());
		dao.updateProducto(producto);
		
		return "success";
	}
	
	/* Acciones de formularios --------------------------------------------------- */
	/**
	 * Show the form to add producto object
	 * @return "success" to display new page
	 */
	public String showAltaProductoForm() {
		logger.debug("showAltaProductoForm()");
		producto = new Producto();
		
		TipoDAO tipoDAO = new TipoDAO();
		tipos = tipoDAO.getAllTipos();
		MarcaDAO marcaDAO = new MarcaDAO();
		marcas = marcaDAO.getAllMarcas();
		AlmacenDAO almacenDAO = new AlmacenDAO();
		almacenes = almacenDAO.getAllAlmacenes();
		ProveedorDAO proveedorDAO = new ProveedorDAO();
		proveedores = proveedorDAO.getAllProveedores();
		
		return "success";
	}
	/**
	 * Show the form to edit producto object
	 * @return "success" to display new page
	 */
	public String showEditarProductoForm() {
		logger.info("showEditarProductoForm()");
		
		ProductoDAO dao = new ProductoDAO();
		logger.info("Actual object");
		logger.info(producto.toString());
		
		TipoDAO tipoDAO = new TipoDAO();
		tipos = tipoDAO.getAllTipos();
		MarcaDAO marcaDAO = new MarcaDAO();
		marcas = marcaDAO.getAllMarcas();
		AlmacenDAO almacenDAO = new AlmacenDAO();
		almacenes = almacenDAO.getAllAlmacenes();
		ProveedorDAO proveedorDAO = new ProveedorDAO();
		proveedores = proveedorDAO.getAllProveedores();

		Producto completeProducto = dao.getProductoById(producto.getProducto_id());
		producto = completeProducto;
		logger.info("New object");
		logger.info(producto.toString());
		
		idMarca = String.valueOf(producto.getMarca().getId());
		idTipo = String.valueOf(producto.getTipo().getTipo_id());
		idAlmacen = String.valueOf(producto.getAlmacen().getId());
		idProveedor = String.valueOf(producto.getProveedor().getProveedor_id());
		
		return "success";
	}
	
	/**
	 * @return the producto object
	 */
	public Producto getProducto() {
		return producto;
	}

	/**
	 * @param producto the new producto to set
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	/**
	 * @return the productos object
	 */
	public List<Producto> getProductos() {
		return productos;
	}

	/**
	 * @param productos the new productos object to set
	 */
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	/**
	 * @return the tipos object
	 */
	public List<Tipo> getTipos() {
		return tipos;
	}

	/**
	 * @param tipos the new tipos object to set
	 */
	public void setTipos(List<Tipo> tipos) {
		this.tipos = tipos;
	}
	
	/**
	 * @return the marcas object
	 */
	public List<Marca> getMarcas() {
		return marcas;
	}

	/**
	 * @param marcas the new marcas object to set
	 */
	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}
	
	/**
	 * @return the almacenes object
	 */
	public List<Almacen> getAlmacenes() {
		return almacenes;
	}

	/**
	 * @param almacenes the new almacenes object to set
	 */
	public void setAlmacenes(List<Almacen> almacenes) {
		this.almacenes = almacenes;
	}
	
	/**
	 * @return the proveedores object
	 */
	public List<Proveedor> getProveedores() {
		return proveedores;
	}

	/**
	 * @param proveedores the new proveedores object to set
	 */
	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}
	
	/**
	 * @return the idTipo
	 */
	public String getIdTipo() {
		return idTipo;
	}
	
	/**
	 * @param idTipo the new idTipo to set
	 */
	public void setIdTipo(String idTipo) {
		this.idTipo = idTipo;
	}
	
	/**
	 * @return the idMarca
	 */
	public String getIdMarca() {
		return idMarca;
	}

	/**
	 * @param idMarca the new idMarca to set
	 */
	public void setIdMarca(String idMarca) {
		this.idMarca = idMarca;
	}
	
	/**
	 * @return the idAlmacen
	 */
	public String getIdAlmacen() {
		return idAlmacen;
	}

	/**
	 * @param idAlmacen the new idAlmacen to set
	 */
	public void setIdAlmacen(String idAlmacen) {
		this.idAlmacen = idAlmacen;
	}
	
	/**
	 * @return the idProveedor
	 */
	public String getIdProveedor() {
		return idProveedor;
	}

	/**
	 * @param idProveedor the new idProveedor to set
	 */
	public void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
	}
}
