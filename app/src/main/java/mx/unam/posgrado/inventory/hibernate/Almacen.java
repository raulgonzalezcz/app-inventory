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

@Entity 
@Table(name = "almacen")
public class Almacen implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private int almacen_id;
	private String nombre;
	private String ubicacion;
	private int dimension;
	private Date fecha_creacion;

	
	/**
	 * @return the almacen_id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "almacen_id" )
	public int getId() {
		return almacen_id;
	}
	/**
	 * @param almacen_id the almacen_id to set
	 */
	public void setId(int almacen_id) {
		this.almacen_id = almacen_id;
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
	 * @return the ubicacion
	 */
	@Column (name="ubicacion", nullable = false, length = 500)
	public String getUbicacion() {
		return ubicacion;
	}
	/**
	 * @param ubicacion the ubicacion to set
	 */
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	/**
	 * @return the dimension
	 */
	@Column (name="dimension", nullable = false)
	public int getDimension() {
		return dimension;
	}
	/**
	 * @param dimension the dimension to set
	 */
	public void setDimension(int dimension) {
		this.dimension = dimension;
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
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Almacen [\n\tid=");
		stringBuilder.append(almacen_id);
		stringBuilder.append(", \n\tnombre=");
		stringBuilder.append(nombre);
		stringBuilder.append(", \n\tfecha=");
		stringBuilder.append(fecha_creacion);
		stringBuilder.append(", \n\tubicacion=");
		stringBuilder.append(ubicacion);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
}
