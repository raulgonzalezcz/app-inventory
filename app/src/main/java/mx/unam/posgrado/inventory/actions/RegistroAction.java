package mx.unam.posgrado.inventory.actions;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

import mx.unam.posgrado.inventory.hibernate.Usuario;
import mx.unam.posgrado.inventory.hibernate.UsuarioDAO;
import mx.unam.posgrado.inventory.pojo.FrmUsuario;

public class RegistroAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(RegistroAction.class);

	/**
	 * POJO
	 */
	private Usuario usuario;
	/**
	 * Objeto tipo string para recibir la confirmación de la contraseña
	 */
	private String passwordConfirn;
	
	/**
	 * Simulación de registro de usuario
	 * @return
	 */
	public String registroUsuarioAdmin() {
		logger.info("registroUsuario()");
		
		logger.info("Datos recibidos: " + usuario);
		
		
		Usuario newUsuario = new Usuario();
		newUsuario.setAdmin(true);
		newUsuario.setActivo(true);
		newUsuario.setNombre( usuario.getNombre() );
		newUsuario.setApellidos( usuario.getApellidos() );
		newUsuario.setCorreo( usuario.getCorreo() );
		newUsuario.setContrasena( usuario.getContrasena() );
		
		
		UsuarioDAO dao = new UsuarioDAO();
		dao.saveUsuario(newUsuario);
		
		
		logger.info("Usuario guardado exitosamente");
		return "success";
	}
	
	
	/**
	 * Forma más básica para la validación de los campos de una forma.
	 * Struts ejecutará de forma automática esta función, si alguno de los 
	 * valores recibidos no cumple con los criterios de validez requeridos, 
	 * entonces es necesario llamar a la función {@link ActionSupport#addFieldError(String, String)}.
	 * Si se agrego algún error, Struts no continuará con el procesamiento de la forma y
	 * en vez de eso, regresara el valor de <code>input</code> indicando que 
	 * hay un error en los datos de entrada.<br/>
	 * Para manejar este evento, es necesario que en el archivo de configuración 
	 * <code>struts.xml</code> se agregue el resultado a la acción de la siguiente 
	 * forma <br/>
	 * <pre><result name="input">/registro.jsp</result></pre>
	 * 
	 */
	public void validate(){
		logger.info("validate()");
		
		// if( usuario.getCorreo() == null || usuario.getCorreo().isEmpty() ) {
		// 	logger.error("No se recibió correo");
		// 	addFieldError("usuario.correo", "El correo es requerido");
		// }
		
		// if( !usuario.getCorreo().matches(EMAIL_REGEX) ) {
		// 	logger.error("Correo mal formado");
		// 	addFieldError("usuario.correo", "Correo electrónico inválido");
		// }
		
		// if( usuario.getNombre() == null || usuario.getNombre().isEmpty() ) {
		// 	addFieldError("usuario.nombre", "Nombre es requerido");
		// }
		
		// // Si el nombre tiene caracteres especiales o números
		// if( !usuario.getNombre().matches(SOLO_TEXTO_REGEX) ) {
		// 	addFieldError("usuario.nombre", "Nombre inválido");
		// }
		
		// if( usuario.getApellidos() == null || usuario.getApellidos().isEmpty() ) {
		// 	addFieldError("usuario.apellidos", "Apellido paterno requerido");
		// }
		
		// if( !usuario.getApellidos().matches(SOLO_TEXTO_REGEX) ) {
		// 	addFieldError("usuario.apellidos", "Apellido paterno inválido");
		// }

		// if( usuario.getContrasena() == null || usuario.getContrasena().isEmpty() ) {
		// 	addFieldError("usuario.password", "Contraseña requerida");
		// }
		
		// if( getPasswordConfirn() == null || getPasswordConfirn().isEmpty() ) {
		// 	addFieldError("passwordConfirn", "Confirmación de la contraseña requerida");
		// }
		
		// // Si la contraseña y su confirmación no coinciden
		// if( !usuario.getContrasena().equals( getPasswordConfirn() ) ) {
		// 	addFieldError("usuario.password", "La contraseña y su confirmación no coinciden");
		// }
		
		// if( !usuario.getContrasena().matches( PASSWD_REGEX ) ) {
		// 	addFieldError("usuario.password", "La contraseña no cumple la complejidad requerida");
		// }
	}
	
	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	/**
	 * @return the passwordConfirn
	 */
	public String getPasswordConfirn() {
		return passwordConfirn;
	}
	
	/**
	 * @param passwordConfirn the passwordConfirn to set
	 */
	public void setPasswordConfirn(String passwordConfirn) {
		this.passwordConfirn = passwordConfirn;
	}
	
	
}
