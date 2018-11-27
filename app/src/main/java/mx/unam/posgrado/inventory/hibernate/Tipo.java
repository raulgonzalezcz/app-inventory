package mx.unam.posgrado.inventory.hibernate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Temporal;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.sql.Timestamp;

/**
 * 
 * @author Raul Gonzalez Cruz
 * @version 1.0 
 * @since 24/11/2018
 */
@Entity
@Table(name = "tipo")
public class Tipo implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	private int tipo_id;
	private String nombre;
	private Date fecha_creacion;
	
	/**
	 * @return the tipo_id
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "tipo_id", unique = true, nullable = false)
	public Integer getTipo_id() {
		return tipo_id;
	}
	
	/**
	 * @param tipo_id new tipo_id to set
	 */
	public void setTipo_id(int tipo_id) {
		this.tipo_id = tipo_id;
	}
	
	@Column(name = "nombre", nullable = false, length = 100)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @return the fecha_creacion
	 */
	@Column(name = "fecha_creacion", nullable = false, insertable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getFecha_creacion() {
		return this.fecha_creacion;
	}
	
	/**
	 * @param fecha_creacion the new fecha_creacion to set
	 */
	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Tipo [tipo_id=");
		stringBuilder.append(tipo_id);
		stringBuilder.append(", \n\tnombre=");
		stringBuilder.append(nombre);
		stringBuilder.append(", \n\tfecha_creacion=");
		stringBuilder.append(fecha_creacion);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}	
}
