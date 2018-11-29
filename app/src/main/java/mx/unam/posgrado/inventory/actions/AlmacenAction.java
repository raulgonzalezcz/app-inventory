
package mx.unam.posgrado.inventory.actions;
 
import java.util.List;
import org.apache.log4j.Logger;

import mx.unam.posgrado.inventory.hibernate.Almacen; 
import mx.unam.posgrado.inventory.hibernate.AlmacenDAO;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class AlmacenAction {
	private static final Logger logger = Logger.getLogger(AlmacenAction.class);
	
	private List<Almacen> almacenes;
	private Almacen almacen;

	
	public String showAlmacenHome() {
		logger.info("Almacen()");

		// almacen = new Almacen();
		AlmacenDAO almacenesDAO = new AlmacenDAO();
		almacenes = almacenesDAO.getAllAlmacenes();
 
		return "success";
	}


 	public String showAltaAlmacenForm() {
		logger.info("showAlmacenForm()");
		almacen = new Almacen();
		return "success";
	}

	public String altaAlmacenAction() {
		logger.info("registroAlmacen()");
		logger.info("Datos recibidos: " + almacen);

		Almacen newAlmacen = new Almacen();
		newAlmacen.setNombre( almacen.getNombre() );
		newAlmacen.setUbicacion( almacen.getUbicacion() );
		newAlmacen.setDimension( almacen.getDimension() );
		AlmacenDAO dao = new AlmacenDAO();
		dao.saveAlmacen(newAlmacen);
		
		logger.info("Almacen guardada exitosamente");
		return "success";
	}

	public String showEditarAlmacenForm() {
		AlmacenDAO dao = new AlmacenDAO();
		Almacen completeAlmacen = dao.getAlmacenById(almacen.getId());
		almacen = completeAlmacen;
		return "success";
	}

	public String editarAlmacenAction() {
		logger.info("Datos recibidos: " + almacen);
		AlmacenDAO dao = new AlmacenDAO();
		dao.updateAlmacen(almacen);
		return "success";
	}

	public String deleteAlmacenByIdAction() {
		logger.info("Datos recibidos: " + almacen);

		AlmacenDAO dao = new AlmacenDAO();
		Almacen completeAlmacen = dao.getAlmacenById(almacen.getId());
		dao.deleteAlmacenById(completeAlmacen);
		return "success";
	}


	/**
	 * @return the almacenes
	 */

	public List<Almacen> getAlmacenes() {
		return almacenes;
	}

	/**
	 * @return the almacen
	 */
	public Almacen getAlmacen() {
		return almacen;
	}

	/**
	 * @param almacen the almacen to set
	 */
	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}


	
}

