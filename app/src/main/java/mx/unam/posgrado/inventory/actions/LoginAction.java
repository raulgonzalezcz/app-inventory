package mx.unam.posgrado.inventory.actions;

import org.apache.log4j.Logger;

import mx.unam.posgrado.inventory.pojo.FrmLogin;

/**
 * Acción web que procesará la autenticación de usuarios
 * @author Gabriel Gonzalez
 *
 */
public class LoginAction {
	private static final Logger logger = Logger.getLogger(LoginAction.class);
	
	private FrmLogin frmLogin;
	
	public String loginUsuario() {
		logger.info("loginUsuario()");
		
		logger.info("Información recibida: " + frmLogin);
		
		if( frmLogin.getCorreo().equals("admin@libreria.com") 
				&& frmLogin.getContrasena().equals("password123") ){
			logger.info("Usuario válido");
			return "autenticado";
		}else{
			logger.warn("Usuario y/o contraseña incorrectos");
			return "no-autenticado";
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
