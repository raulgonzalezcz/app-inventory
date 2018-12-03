package mx.unam.posgrado.inventory.actions;

import org.apache.log4j.Logger;

import mx.unam.posgrado.inventory.hibernate.Usuario;
import mx.unam.posgrado.inventory.hibernate.UsuarioDAO;
import mx.unam.posgrado.inventory.pojo.FrmCambioPassword;
import mx.unam.posgrado.inventory.pojo.FrmLogin;

/**
 * Acciones que un usuario con sesión iniciada puede hacer sobre ella:<br/>
 * <ul>
 * 	<li>Cambiar contraseña</li>
 *	<li>Cerrar sesión</li>
 * </ul>
 * @author Gabriel Gonzalez
 *
 */
public class CambioPasswdAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(CambioPasswdAction.class);
	private FrmCambioPassword frmCambioPasswd;
	
	/**
	 * 
	 * @return
	 */
	public String cambiarPassword() {
		logger.info("cambiarPassword()");
	
		String correo = getSession().get("correo").toString();
		
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			
			logger.info("Verificando contraseña anterior");
			Usuario usuario = usuarioDAO.login( 
					new FrmLogin( correo, frmCambioPasswd.getPasswdAnterior() ) 
				);
			
			if( usuario != null ) {
				usuario.setContrasena( frmCambioPasswd.getPasswdNuevo() );
				logger.info("Actualizando contraseña");
				usuarioDAO.updateUsuario(usuario);
				addActionMessage( "Contraseña cambiada exitosamente" );
				logger.info("Contraseña cambiada exitosamente");
				return "success";
			}else {
				addActionError( "La contraseña anterior no es correcta" );
				return "passwd-no-cambiado";
			}
		}catch(Exception e) {
			logger.error("Error desconocido", e);
			addActionError( e.getMessage() );
			return "error";
		}
	}
	
	public void validate(){
		logger.info("validate()");
		
		logger.info("Evaluando el POJO: " + frmCambioPasswd);
		
		if( frmCambioPasswd.getPasswdAnterior() == null || frmCambioPasswd.getPasswdAnterior().isEmpty() ) {
			addFieldError("frmCambioPasswd.passwdAnterior", "Contraseña anterior requerida");
		}
		
		if( frmCambioPasswd.getPasswdNuevo() == null || frmCambioPasswd.getPasswdNuevo().isEmpty() ) {
			addFieldError("passwordConfirn", "Contraseña nueva requerida");
		}
		
		// Si la contraseña y su confirmación no coinciden
		if( !frmCambioPasswd.getPasswdNuevo().equals( frmCambioPasswd.getPasswdConfirmacion() ) ) {
			addFieldError("usuario.password", "La contraseña y su confirmación no coinciden");
		}
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
