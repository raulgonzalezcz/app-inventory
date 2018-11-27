package mx.unam.posgrado.inventory.actions;

import org.apache.log4j.Logger;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import mx.unam.posgrado.inventory.hibernate.MarcaDAO;
import mx.unam.posgrado.inventory.hibernate.Tipo;
import mx.unam.posgrado.inventory.hibernate.TipoDAO;
import mx.unam.posgrado.inventory.hibernate.UsuarioDAO;

public class RegistroTipoAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(RegistroTipoAction.class);
	
	private Tipo tipo;
	
	public String agregarTipo() {
		logger.info("agregarTipo()");
		
		TipoDAO dao = new TipoDAO();
		logger.info("Info1");
		logger.info(tipo.getNombre());
		logger.info(tipo.toString());
		dao.saveTipo(tipo);
		
		return "success";
	}
	
	public String bajarTipo() {
		logger.info("bajarTipo()");
		
		TipoDAO dao = new TipoDAO();
		logger.info("Info ID");
		logger.info(tipo);
		Tipo completeTipo = dao.getTipoById(tipo.getTipo_id());
		logger.info(completeTipo);
		
		dao.deleteTipo(completeTipo);
		
		return "success";
	}
	
	/*
	public String deleteMarcaByIdAction() {
		logger.info("Datos recibidos: " + marca);
		MarcaDAO dao = new MarcaDAO();
		dao.deleteMarcaById(marca.getId());
		return "success";
	}
	*/
	
	public String cambiarTipo() {
		logger.info("cambiarTipo()");
		
		TipoDAO dao = new TipoDAO();
		logger.info("Info object");
		logger.info(tipo);

		Tipo completeTipo = dao.getTipoById(tipo.getTipo_id());
		tipo = completeTipo;
		logger.info("Info object");
		logger.info(tipo);
		
		//dao.saveTipo(tipo);
		return "input";
	}
	
	/**
	 * @return the tipo
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

}

