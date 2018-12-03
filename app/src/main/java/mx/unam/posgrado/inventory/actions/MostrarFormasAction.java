package mx.unam.posgrado.inventory.actions;

import org.apache.log4j.Logger;
import java.util.List;
import mx.unam.posgrado.inventory.pojo.FrmCambioPassword;
import mx.unam.posgrado.inventory.pojo.FrmLogin;
import mx.unam.posgrado.inventory.pojo.FrmUsuario;
import mx.unam.posgrado.inventory.hibernate.Usuario;
import mx.unam.posgrado.inventory.hibernate.UsuarioDAO;

public class MostrarFormasAction {
	private static final Logger logger = Logger.getLogger(MostrarFormasAction.class);
	
	private FrmLogin frmLogin;
	private FrmUsuario usuarioFrm;
	private FrmCambioPassword frmCambioPasswd;
	private List<Usuario> usuarios;
	private Usuario usuario;
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
		
		usuarioFrm = new FrmUsuario();
		
		return "success";
	}	
	
	public String showChangePasswordForm(){
		logger.info("showChangePasswordForm()"); 
		frmCambioPasswd = new FrmCambioPassword();
		return "success";
	}


	public String showUsuariosHome(){
		logger.debug("getAllUsuarios()");

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarios = usuarioDAO.getAllUsuarios();

		return "success";
	}
	
	public String showHome(){

		return "success";
	}

	/**
	 * @return the usuarios
	 */

	public List<Usuario> getUsuarios() {
		return usuarios;
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
	 * @return the usuarioFrm
	 */
	public FrmUsuario getUsuario() {
		return usuarioFrm;
	}

	/**
	 * @param usuarioFrm the usuarioFrm to set
	 */
	public void setUsuario(FrmUsuario usuarioFrm) {
		this.usuarioFrm = usuarioFrm;
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
