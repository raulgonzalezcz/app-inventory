package mx.unam.posgrado.inventory.actions;

import org.apache.log4j.Logger;

import java.util.List;

import mx.unam.posgrado.inventory.hibernate.Tipo;
import mx.unam.posgrado.inventory.hibernate.TipoDAO;

/**
 * Class to establish actions for Tipo object
 * @author Raul Gonzalez Cruz
 * @version 1.0 
 * @since 24/11/2018
 */
public class TipoAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(TipoAction.class);
	
	private Tipo tipo;
	private List<Tipo> tipos;

	/**
	 * Get all the tipo objects from database
	 * @return "success" to display the home page for Tipo class
	 */
	public String showTipoHome() {
		logger.debug("showTipoHome()");
		
		TipoDAO tipoDAO = new TipoDAO();
		tipos = tipoDAO.getAllTipos();
		
		return "success";
	}
	
	/**
	 * Add a new tipo object to database
	 * @param tipo the new tipo to add
	 * @return "success" to display the home page for Tipo class
	 */
	public String agregarTipo() {
		logger.info("agregarTipo()");
		
		TipoDAO dao = new TipoDAO();
		logger.info("New tipo object");
		logger.info(tipo.toString());
		dao.saveTipo(tipo);
		
		return "success";
	}
	
	/**
	 * Delete an specific tipo object 
	 * @param tipo the specific tipo to delete
	 * @return "success" to display the home page for Tipo class
	 */
	public String bajarTipo() {
		logger.info("bajarTipo()");
		
		TipoDAO dao = new TipoDAO();
		logger.info("Object information");
		logger.info(tipo.toString());
		Tipo completeTipo = dao.getTipoById(tipo.getTipo_id());
		logger.info(completeTipo);
		
		dao.deleteTipo(completeTipo);
		
		return "success";
	}
	
	/**
	 * Update the data for a specific tipo object
	 * @param tipo the specific tipo to update with new data
	 * @return "success" to display the home page for Tipo class
	 */
	public String cambiarTipo() {
		logger.info("cambiarTipo()");
		
		TipoDAO dao = new TipoDAO();
		logger.info("Info object");
		logger.info(tipo.toString());
		dao.updateTipo(tipo);
		
		return "success";
	}
	
	/* Acciones de formularios --------------------------------------------------- */
	/**
	 * Show the form to add tipo object
	 * @return "success" to display new page
	 */
	public String showAltaTipoForm() {
		logger.debug("showAltaTipoForm()");
		tipo = new Tipo();
		return "success";
	}
	/**
	 * Show the form to edit tipo object
	 * @return "success" to display new page
	 */
	public String showEditarTipoForm() {
		logger.info("showEditarTipoForm()");
		
		TipoDAO dao = new TipoDAO();
		logger.info("Actual object");
		logger.info(tipo.toString());

		Tipo completeTipo = dao.getTipoById(tipo.getTipo_id());
		tipo = completeTipo;
		logger.info("New object");
		logger.info(tipo.toString());
		
		return "success";
	}
	
	/**
	 * @return the tipo object
	 */
	public Tipo getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the new tipo to set
	 */
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
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

}
