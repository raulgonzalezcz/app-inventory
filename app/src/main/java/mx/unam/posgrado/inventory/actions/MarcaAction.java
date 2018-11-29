
package mx.unam.posgrado.inventory.actions;
 
import java.util.List;
import org.apache.log4j.Logger;

import mx.unam.posgrado.inventory.hibernate.Marca; 
import mx.unam.posgrado.inventory.hibernate.MarcaDAO;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class MarcaAction {
	private static final Logger logger = Logger.getLogger(MarcaAction.class);
	
	// private Marca marca;
	private List<Marca> marcas;
	private Marca marca;
	/**
	 * POJO
	 */


	public String altaMarcaAction() {
		logger.info("registroMarca()");
		logger.info("Datos recibidos: " + marca);

		Marca newMarca = new Marca();
		newMarca.setNombre( marca.getNombre() );
		newMarca.setDescripcion( marca.getDescripcion() );
		MarcaDAO dao = new MarcaDAO();
		dao.saveMarca(newMarca);
		
		logger.info("Marca guardada exitosamente");
		return "success";
	}

	public String editarMarcaAction() {
		logger.info("Datos recibidos: " + marca);
		
		MarcaDAO dao = new MarcaDAO();
		dao.updateMarca(marca);
		return "success";
	}

	public String deleteMarcaByIdAction() {
		logger.info("Datos recibidos: " + marca);

		MarcaDAO dao = new MarcaDAO();
		Marca completeMarca = dao.getMarcaById(marca.getId());
		dao.deleteMarcaById(completeMarca);
		return "success";
	}
	
	public String showMarcaHome() {
		logger.debug("Marca()");

		// marca = new Marca();
		MarcaDAO marcaDAO = new MarcaDAO();
		marcas = marcaDAO.getAllMarcas();
 
		// logger.debug(marcas);
		return "success";
	}

	public String showAltaMarcaForm() {
		logger.info("showMarcaForm()");
		logger.debug("Instanciando POJO para la forma marca");
		// marcaFrm = new FrmMarca();
		marca = new Marca();
		return "success";
	}

 
	public String showEditarMarcaForm() {
		logger.info("showCambioMarcaForm()" + marca);
		logger.debug("Instanciando POJO para la forma cambio marca");
		// marcaFrm = new FrmMarca();
		MarcaDAO dao = new MarcaDAO();
		Marca completeMarca = dao.getMarcaById(marca.getId());
		logger.info("showCambioMarcaForm()" + completeMarca);
		marca = completeMarca;
		logger.info("nueva marca " + marca);
		return "success";
	}
 	
 	/**
	 * @return the marcas
	 */

	public List<Marca> getMarcas() {
		return marcas;
	}

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

