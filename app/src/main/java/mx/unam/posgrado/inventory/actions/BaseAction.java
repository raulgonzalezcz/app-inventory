package mx.unam.posgrado.inventory.actions;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Acción que implementa caracteristicas generales empleadas 
 * por cualquier acción definida en el controlador:
 * <br/>
 * <ul>
 * 	<li>Herencia de {@link ActionSupport}</li>
 * 	<li>Implementación de {@link SessionAware}</li>
 * </ul>
 * @author Gabriel Gonzalez
 *
 */
public class BaseAction extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Expresión regular para verificar la fortaleza de la contraseña
	 */
	public static final String PASSWD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{5,}$";
	
	/**
	 * Expresión regular para validar el correo electrónico
	 */
	public static final String EMAIL_REGEX = "(?i)^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
	
	/**
	 * Expresión regular para validar que la cadena sean letras de la A a la Z incluyendo ñ y acentos
	 */
	public static final String SOLO_TEXTO_REGEX = "^[\\pL\\pM\\p{Zs}.-]+$";
	
	// variable para almacenar el objeto session
	private SessionMap<String, Object> session;
	
	public void setSession(Map<String, Object> session) {
		this.session = (SessionMap<String, Object>) session;
	}
	
	protected SessionMap<String, Object> getSession(){
		return this.session;
	}
	
	protected void cerrarrSesion(){
		for (Map.Entry<String, Object> entry : session.entrySet()) {
			session.remove( entry.getKey() );
		}
		session.invalidate();
	}
}
