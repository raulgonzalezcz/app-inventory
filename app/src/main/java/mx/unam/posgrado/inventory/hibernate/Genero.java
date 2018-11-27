package mx.unam.posgrado.inventory.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad o POJO que representa a la tabla generos dentro de 
 * Java. La conveción de nombrado es en singular 
 * @author Gabriel Gonzalez
 *
 */
@Entity
@Table(name = "genero")
public class Genero implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private short id;
	private String nombre;
	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_generos")
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
	@Column(name = "nombre", nullable = false, length = 45)
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Genero [\n\tid=");
		stringBuilder.append(id);
		stringBuilder.append(", \n\tnombre=");
		stringBuilder.append(nombre);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

}
