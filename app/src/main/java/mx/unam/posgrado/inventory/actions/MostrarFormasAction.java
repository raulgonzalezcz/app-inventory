package mx.unam.posgrado.inventory.actions;

import java.util.List;

import org.apache.log4j.Logger;


import mx.unam.posgrado.inventory.hibernate.Tipo;
import mx.unam.posgrado.inventory.hibernate.TipoDAO;
import mx.unam.posgrado.inventory.hibernate.Marca;
import mx.unam.posgrado.inventory.hibernate.MarcaDAO;

import mx.unam.posgrado.inventory.pojo.FrmCambioPassword;
import mx.unam.posgrado.inventory.pojo.FrmLogin;
import mx.unam.posgrado.inventory.pojo.FrmUsuario;

public class MostrarFormasAction {
	private static final Logger logger = Logger.getLogger(MostrarFormasAction.class);
	
	private FrmLogin frmLogin;
	private FrmUsuario usuario;
	private FrmCambioPassword frmCambioPasswd;

	// catálogo tipos
	private Tipo tipo;
	private List<Tipo> tipos;
	
	private Marca marca;
	
	private String flag;
	
	/**
	 * Acción que preparará la forma web para el inicio de sesión
	 * del usuario. 
	 * 
	 * Esta función que será ejecutada por la acción showLoginForm definida en el
	 * archivo de configuración struts.xml.
	 * @return
	 */
	public String showLoginForm() {
		logger.info("showLoginForm()");
		
		logger.debug("Instanciando POJO para la forma login");
		frmLogin = new FrmLogin();
		
		return "success";
	}
	
	public String showRegisterForm() {
		logger.info("showRegisterForm()");
		
		usuario = new FrmUsuario();
		
		return "success";
	}
	

	
	public String showEditarTipoForm() {
		logger.info("showEditarTipoForm()");
		
		TipoDAO dao = new TipoDAO();
		logger.info("Info object");
		logger.info(tipo);

		Tipo completeTipo = dao.getTipoById(tipo.getTipo_id());
		tipo = completeTipo;
		logger.info("Info object");
		logger.info(tipo);
		
		//dao.saveTipo(tipo);
		return "success";
	}
	
	public String showNewTipoInfo() {
		logger.debug("showNewTipoInfo()");
		TipoDAO tipoDAO = new TipoDAO();
		tipo = new Tipo();
		tipos = tipoDAO.getAllTipos();
		return "success";
	}
	
	public String showNewTipoForm() {
		
		logger.debug("showNewTipoForm()");
		
		return "success";
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
	
	public String showChangePasswordForm(){
		logger.info("showChangePasswordForm()");
		frmCambioPasswd = new FrmCambioPassword();
		return "success";
	}
	
	public String showHome(){
		return "success";
	}

	/**
	 * @return the frmLogin
	 */
	public FrmLogin getFrmLogin() {
		return frmLogin;
	}

	/**
	 * @param frmLogin the frmLogin to set
	 */
	public void setFrmLogin(FrmLogin frmLogin) {
		this.frmLogin = frmLogin;
	}
	
	/**
	 * @return the usuario
	 */
	public FrmUsuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(FrmUsuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
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
	
	/**
	 * @return the tipos
	 */
	public List<Tipo> getTipos() {
		return tipos;
	}

	/**
	 * @param tipos the new generos to set
	 */
	public void setTipos(List<Tipo> tipos) {
		this.tipos = tipos;
	}




	/**
	 * @return the frmCambioPasswd
	 */
	public FrmCambioPassword getFrmCambioPasswd() {
		return frmCambioPasswd;
	}

	/**
	 * @param frmCambioPasswd the frmCambioPasswd to set
	 */
	public void setFrmCambioPasswd(FrmCambioPassword frmCambioPasswd) {
		this.frmCambioPasswd = frmCambioPasswd;
	}
	
	
}
