package mx.unam.posgrado.inventory.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.Id;
import javax.persistence.Table; 
import javax.persistence.Transient;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

 
/**
 * 
 * @author Gabriel Gonzalez
 *
 */
@Entity
@Table( name = "usuario" )
public class Usuario implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private short user_id;
	private String correo;
	private String contrasena;
	private String nombre;
	private String apellidos;
	private boolean admin; 
	private boolean activo; 
	private String fecha_creacion; 
	
	public Usuario() {} 
	
	/**
	 * Constructor atributos obligatorios
	 * @param correo
	 * @param contrasena
	 * @param nombre
	 * @param apellidos
	 * @param fecha_creacion
	 */
	public Usuario(String correo, String contrasena, String nombre, String apellidos,  String fecha_creacion) {
		this.correo = correo;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha_creacion = fecha_creacion;
	}
 


	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "user_id" )
	public short getId() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setId(short user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the correo
	 */
	@Column( name = "correo", unique = true, nullable = false, length = 100 )
	public String getCorreo() {
		return correo;
	}
	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	/**
	 * @return the contrasena
	 */
	@Column ( name = "contrasena", nullable = false, length = 45 )
	public String getContrasena() {
		return contrasena;
	}
	
	/**
	 * @param contrasena the contrasena to set
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	/**
	 * @return the nombre
	 */
	@Column ( name = "nombre", nullable = false, length = 45 )
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @return the apellidos
	 */
	@Column ( name = "apellidos", nullable = false, length = 45 )
	public String getApellidos() {
		return apellidos;
	}
	
	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	
	/**
	 * @return the admin
	 */
	@Column ( name = "admin")
	public boolean isAdmin() {
		return admin;
	}
	
	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	/**
	 * @return the activo
	 */
	@Column ( name = "activo")
	public boolean isActivo() {
		return activo;
	}
	
	/**
	 * @param activo the activo to set
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	/**
	 * @return the fecha_creacion
	 */
	@Column ( name = "fecha_creacion", nullable = false, length = 45 )
	public String getFecha() {
		return fecha_creacion;
	} 
	
	/**
	 * @param fecha_creacion the fecha_creacion to set
	 */
	public void setFecha(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	@Transient
	public String getNombreCompleto() {
		return new StringBuffer()
				.append( nombre ).append(" ").append(apellidos).toString();
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Usuario [user_id=");
		stringBuilder.append(user_id);
		stringBuilder.append(", correo=");
		stringBuilder.append(correo);
		stringBuilder.append(", contrasena=");
		stringBuilder.append(contrasena);
		stringBuilder.append(", admin=");
		stringBuilder.append(admin);
		stringBuilder.append(", nombreCompleto=");
		stringBuilder.append(getNombreCompleto());
		stringBuilder.append("]");
		return stringBuilder.toString();
	}	
}