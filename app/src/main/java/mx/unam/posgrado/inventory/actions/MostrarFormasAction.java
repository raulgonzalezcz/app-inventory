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
	private Proveedor proveedor;
	
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
	

	
	/* --------------------------------------------------- */
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
	
	/* --------------------------------------------------- */
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
	 * @return the proveedor
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
