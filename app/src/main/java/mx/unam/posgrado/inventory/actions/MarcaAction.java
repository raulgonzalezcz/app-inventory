
package mx.unam.posgrado.inventory.actions;
 
import java.util.List;
import org.apache.log4j.Logger;

import mx.unam.posgrado.inventory.hibernate.Marca; 
import mx.unam.posgrado.inventory.hibernate.MarcaDAO;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class MarcaAction {
	private static final Logger logger = Logger.getLogger(MostrarFormasAction.class);
	
	// private Marca marca;
	private List<Marca> marcas;
	private Marca marca;
	/**
	 * POJO
	 */


	public String altaMarcaAction() {
		logger.info("registroMarca()");
		logger.info("Datos recibidos: " + marca);
		// // Obtener fecha de hoy y para a setFecha()
		// // DATE - format YYYY-MM-DD.
		// // DATETIME - format: YYYY-MM-DD HH:MI:SS.
		// Marca newMarca = new Marca();
		// newMarca.setFecha("2018-11-26");
		// newMarca.setNombre( marcaFrm.getNombre() );
		// newMarca.setDescripcion( marcaFrm.getDescripcion() );
		// MarcaDAO dao = new MarcaDAO();
		// dao.saveMarca(newMarca);

		Marca newMarca = new Marca();
		// newMarca.setFecha("2018-11-26");
		newMarca.setNombre( marca.getNombre() );
		newMarca.setDescripcion( marca.getDescripcion() );
		MarcaDAO dao = new MarcaDAO();
		dao.saveMarca(newMarca);
		
		logger.info("Marca guardada exitosamente");
		return "success";
	}

	public String editarMarcaAction() {
		logger.info("Datos recibidos: " + marca);
		
		// marca.setFecha("2018-11-26");
		MarcaDAO dao = new MarcaDAO();
		// Marca competeMarca = dao.getMarcaById(marca.getId());

		dao.updateMarca(marca);
		return "success";
	}

	public String deleteMarcaByIdAction() {
		logger.info("Datos recibidos: " + marca);

		MarcaDAO dao = new MarcaDAO();
		Marca competeMarca = dao.getMarcaById(marca.getId());
		dao.deleteMarcaById(competeMarca);
		return "success";
	}

	public List<Marca> getMarcas() {
		return marcas;
	}
	
	public String showMarcaHome() {
		logger.debug("Marca()");

		marca = new Marca();
		MarcaDAO marcaDAO = new MarcaDAO();
		marcas = marcaDAO.getAllMarcas();
 
		// logger.debug(marcas);
		return "success";
	}
 

	// /**
	//  * @return the marcaFrm
	//  */
	// public FrmMarca getMarca() {
	// 	return marcaFrm;
	// }

	// /**
	//  * @param marcaFrm the marcaFrm to set
	//  */
	// public void setMarca(FrmMarca marcaFrm) {
	// 	this.marcaFrm = marcaFrm;
	// }

	/**
	 * @return the marca
	 */
	public Marca getMarca() {
		return marca;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(Marca marca) {
		this.marca = marca;
	}


	
}

