package mx.unam.posgrado.inventory.actions;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import com.opensymphony.xwork2.ActionContext;

import mx.unam.posgrado.inventory.hibernate.Usuario;
import mx.unam.posgrado.inventory.hibernate.UsuarioDAO;
import mx.unam.posgrado.inventory.pojo.FrmLogin;

public class LoginValidacionAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(LoginValidacionAction.class);
	
	private FrmLogin frmLogin;
	
	public String loginUsuario() {
		logger.info("loginUsuario()");
		
		logger.info("Información recibida de la forma: " + frmLogin);
		
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			logger.info("Consultando la base de datos");
			Usuario usuario = usuarioDAO.login(frmLogin); 
			
			if( usuario != null ){
				logger.info("Usuario válido");
				logger.info("Información de usuario: " + usuario);
				
				logger.info("Iniciando sesión");
				// creación de la sesión de usuario
				getSession().put("nombreCompleto", usuario.getNombreCompleto());
				getSession().put("isAdmin", usuario.isAdmin());
				getSession().put("mail", usuario.getCorreo());
				
				return "autenticado";
			}else{
				final String msgError = "Usuario y/o contraseña incorrectos";
				logger.warn(msgError);
				addActionError(msgError);
				
				return "no-autenticado";
			}
		}catch(HibernateException e) {
			addActionError(e.getMessage());
			return "error";
		}catch(ExceptionInInitializerError e) {
			addActionError("Error en la conexión con la base de datos");
			return "error";
		}
	}
	
	public String logoutUsuario() {
		logger.info("Cerrando sesión de usuario");
		cerrarrSesion();
		addActionMessage("Su sesión ha sido cerrada");
		return "success";
	}
	
	/**
	 * Validación de los campos de la forma. Esta función es heredada de la clase
	 * ActionSupport
	 */
	public void validate(){
		logger.debug("validate()");
		
		String nombreAccion = ActionContext.getContext().getName();
		logger.debug("Acción solicitada: " + nombreAccion);
		
		if( nombreAccion.equals("login") ) {
			if( frmLogin.getCorreo() == null || frmLogin.getCorreo().isEmpty() ){
				logger.warn("El campo correo está vacio");
				addFieldError("frmLogin.mail", "----> Correo obligatorio");
			}
			
			if( frmLogin.getContrasena() == null || frmLogin.getContrasena().isEmpty() ) {
				logger.warn("El campo contraseña está vacio");
				addFieldError("frmLogin.password", "----> Contraseña obligatoria");
			}
		}
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
}
