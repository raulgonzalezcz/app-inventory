package mx.unam.posgrado.inventory.actions;

import java.util.List;

import org.apache.log4j.Logger;

import mx.unam.posgrado.inventory.hibernate.Proveedor;
import mx.unam.posgrado.inventory.hibernate.ProveedorDAO;;

/**
 * Class to establish actions for Proveedor object
 * @author Raul Gonzalez Cruz
 * @version 1.0 
 * @since 24/11/2018
 */
public class ProveedorAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ProveedorAction.class);
	
	private Proveedor proveedor;
	private List<Proveedor> proveedores;

	/**
	 * Get all the proveedor objects from database
	 * @return "success" to display the home page for Proveedor class
	 */
	public String showProveedorHome() {
		logger.debug("showProveedorHome()");
		
		ProveedorDAO proveedorDAO = new ProveedorDAO();
		proveedores = proveedorDAO.getAllProveedores();
		logger.info(proveedores);
		
		return "success";
	}
	
	/**
	 * Add a new proveedor object to database
	 * @param proveedor the new proveedor to add
	 * @return "success" to display the home page for Proveedor class
	 */
	public String agregarProveedor() {
		logger.info("agregarProveedor()");
		
		ProveedorDAO dao = new ProveedorDAO();
		logger.info("New proveedor object");
		logger.info(proveedor.toString());
		dao.saveProveedor(proveedor);
		
		return "success";
	}
	
	/**
	 * Delete an specific proveedor object 
	 * @param proveedor the specific proveedor to delete
	 * @return "success" to display the home page for Proveedor class
	 */
	public String bajarProveedor() {
		logger.info("bajarProveedor()");
		
		ProveedorDAO dao = new ProveedorDAO();
		logger.info("Object information");
		logger.info(proveedor.toString());
		Proveedor completeProveedor = dao.getProveedorById(proveedor.getProveedor_id());
		logger.info(completeProveedor);
		
		dao.deleteProveedor(completeProveedor);
		
		return "success";
	}
	
	/**
	 * Update the data for a specific proveedor object
	 * @param proveedor the specific proveedor to update with new data
	 * @return "success" to display the home page for Proveedor class
	 */
	public String cambiarProveedor() {
		logger.info("cambiarProveedor()");
		
		ProveedorDAO dao = new ProveedorDAO();
		logger.info("Info object");
		logger.info(proveedor.toString());
		dao.updateProveedor(proveedor);
		
		return "success";
	}
	
	/* Acciones de formularios --------------------------------------------------- */
	/**
	 * Show the form to add proveedor object
	 * @return "success" to display new page
	 */
	public String showAltaProveedorForm() {
		logger.debug("showAltaProveedorForm()");
		proveedor = new Proveedor();
		return "success";
	}
	/**
	 * Show the form to edit proveedor object
	 * @return "success" to display new page
	 */
	public String showEditarProveedorForm() {
		logger.info("showEditarProveedorForm()");
		
		ProveedorDAO dao = new ProveedorDAO();
		logger.info("Actual object");
		logger.info(proveedor.toString());

		Proveedor completeProveedor = dao.getProveedorById(proveedor.getProveedor_id());
		proveedor = completeProveedor;
		logger.info("New object");
		logger.info(proveedor.toString());
		
		return "success";
	}
	
	/**
	 * @return the proveedor object
	 */
	public Proveedor getProveedor() {
		return proveedor;
	}

	/**
	 * @param proveedor the new proveedor to set
	 */
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
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

}
