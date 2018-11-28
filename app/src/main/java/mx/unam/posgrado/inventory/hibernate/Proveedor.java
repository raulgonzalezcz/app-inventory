package mx.unam.posgrado.inventory.hibernate;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Class to model Proveedor object
 * @author Raul Gonzalez Cruz
 * @version 1.0 
 * @since 24/11/2018
 */
@Entity
@Table(name = "proveedor")
public class Proveedor implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	private int proveedor_id;
	private String nombre;
	private Date fecha_creacion;
	private String descripcion;
	
	/**
	 * @return the proveedor_id
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "proveedor", unique = true, nullable = false)
	public Integer getProveedor_id() {
		return proveedor_id;
	}
	
	/**
	 * @param proveedor_id the new proveedor_id to set
	 */
	public void setProveedor_id(int proveedor_id) {
		this.proveedor_id = proveedor_id;
	}
	
	/**
	 * @return the nombre
	 */
	@Column(name = "nombre", nullable = false, length = 100)
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the new nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @return the descripcion
	 */
	@Column(name = "descripcion", nullable = false, length = 300)
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the new descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	/**
	 * Method to explain the proveedor object
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Proveedor [proveedor_id=");
		stringBuilder.append(proveedor_id);
		stringBuilder.append(", \n\tnombre=");
		stringBuilder.append(nombre);
		stringBuilder.append(", \n\tdescripcion=");
		stringBuilder.append(descripcion);
		stringBuilder.append(", \n\tfecha_creacion=");
		stringBuilder.append(fecha_creacion);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}	
}

