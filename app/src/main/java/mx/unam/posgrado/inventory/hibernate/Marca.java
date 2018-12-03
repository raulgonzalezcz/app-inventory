package mx.unam.posgrado.inventory.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import java.util.Date;

 /**
 * Class to model Alamcen object
 * @author Andric Valdez Valenzuela
 * @version 1.0 
 * @since 24/11/2018
 *
 */
 
@Entity 
@Table(name = "marca")
public class Marca implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private int marca_id;
	private String nombre;
	private Date fecha_creacion;
	private String descripcion;
	
	/**
	 * @return the marca_id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "marca_id" )
	public int getId() {
		return marca_id;
	}
	/**
	 * @param marca_id the marca_id to set
	 */
	public void setId(int marca_id) {
		this.marca_id = marca_id;
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
	 * @return the fecha
	 */
	@Column (name="fecha_creacion", nullable = false, insertable=false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getFecha() {
		return fecha_creacion;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	/**
	 * @return the descripcion
	 */
	@Column (name="descripcion", nullable = false, length = 100)
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Marca [\n\tid=");
		stringBuilder.append(marca_id);
		stringBuilder.append(", \n\tnombre=");
		stringBuilder.append(nombre);
		stringBuilder.append(", \n\tfecha=");
		stringBuilder.append(fecha_creacion);
		stringBuilder.append(", \n\tdescripcion=");
		stringBuilder.append(descripcion);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
}
