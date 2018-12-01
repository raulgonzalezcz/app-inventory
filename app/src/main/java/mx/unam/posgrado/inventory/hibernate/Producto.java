package mx.unam.posgrado.inventory.hibernate;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Class to model Producto object
 * @author Raul Gonzalez Cruz
 * @version 1.0 
 * @since 24/11/2018
 */
@Entity
@Table(name = "producto")
public class Producto implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	private int producto_id;
	private Tipo tipo;
	private Marca marca;
	private Almacen almacen;
	private Proveedor proveedor;
	private double precio_venta;
	private String descripcion;
	private Date fecha_creacion;
	private int cantidad;
	private String foto;
	private int descuento;
	
	/**
	 * @return the producto_id
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "producto_id", unique = true, nullable = false)
	public Integer getProducto_id() {
		return producto_id;
	}
	
	/**
	 * @param producto_id the new producto_id to set
	 */
	public void setProducto_id(int producto_id) {
		this.producto_id = producto_id;
	}
	
	/**
	 * Manejo del campo que servir� como llave for�nea, la cual
	 * hace referencia a la tabla marca
	 * @return the marca
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "marca_id", nullable = false)
	public Marca getMarca() {
		return marca;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	/**
	 * Manejo del campo que servir� como llave for�nea, la cual
	 * hace referencia a la tabla almacen
	 * @return the almacen
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "almacen_id", nullable = false)
	public Almacen getAlmacen() {
		return almacen;
	}

	/**
	 * @param almacen the almacen to set
	 */
	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}
	
	/**
	 * Manejo del campo que servir� como llave for�nea, la cual
	 * hace referencia a la tabla proveedor
	 * @return the proveedor
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "proveedor_id", nullable = false)
	public Proveedor getProveedor() {
		return proveedor;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	/**
	 * Manejo del campo que servir� como llave for�nea, la cual
	 * hace referencia a la tabla tipo
	 * @return the tipo
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_id", nullable = false)
	public Tipo getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the precio_venta
	 */
	@Column(name = "precio_venta", nullable = false)
	public Double getPrecio_venta() {
		return precio_venta;
	}

	/**
	 * @param precio_venta the new precio_venta to set
	 */
	public void setPrecio_venta(Double precio_venta) {
		this.precio_venta = precio_venta;
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
	
	/**
	 * @return the cantidad
	 */
	@Column(name = "cantidad", nullable = false)
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the new cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	/**
	 * @return the foto
	 */
	@Column(name = "foto", nullable = false, length = 500)
	public String getFoto() {
		return foto;
	}

	/**
	 * @param foto the new foto to set
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}

	/**
	 * @return the descuento
	 */
	@Column(name = "descuento", nullable = false)
	public int getDescuento() {
		return descuento;
	}

	/**
	 * @param descuento the new descuento to set
	 */
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/**
	 * Method to explain the producto object
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Producto [producto_id=");
		stringBuilder.append(producto_id);
		stringBuilder.append(", \n\ttipo=");
		stringBuilder.append(tipo);
		stringBuilder.append(", \n\tmarca=");
		stringBuilder.append(marca);
		stringBuilder.append(", \n\tdescripcion=");
		stringBuilder.append(descripcion);
		stringBuilder.append(", \n\tfecha_creacion=");
		stringBuilder.append(fecha_creacion);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}	
}

