package mx.unam.posgrado.inventory.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.Transient;

@Entity
@Table(name = "autor")
public class Autor implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private short id;
	private String nombre;
	private String apellido;
	
	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id" )
	public short getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(short id) {
		this.id = id;
	}
	/**
	 * @return the nombre
	 */
	@Column (name = "nombre", nullable = false, length = 45)
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
	 * @return the apelido
	 */
	@Column (name="apellido", nullable = false, length = 45)
	public String getApelido() {
		return apellido;
	}
	/**
	 * @param apelido the apelido to set
	 */
	public void setApelido(String apelido) {
		this.apellido = apelido;
	}
	
	/**
	 * Devuelve la concatenación del nombre y el apellido. La etiqueta Transient 
	 * indica que no es una función <code>get< que corresponda, por lo tanto
	 * en el proceso de serialización será ignorada 
	 * @return
	 */
	@Transient
	public String getNombreCompleto() {
		return new StringBuffer().append(nombre).append(" ").append(apellido).toString();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Autor [\n\tid=");
		stringBuilder.append(id);
		stringBuilder.append(", \n\tnombre=");
		stringBuilder.append(nombre);
		stringBuilder.append(", \n\tapelido=");
		stringBuilder.append(apellido);
		stringBuilder.append(", \n\tnombreCompleto=");
		stringBuilder.append(getNombreCompleto());
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
}
