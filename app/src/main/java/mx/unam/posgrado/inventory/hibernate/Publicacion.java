package mx.unam.posgrado.inventory.hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Gabriel Gonzalez
 *
 */
@Entity
@Table( name = "publicacion" )
public class Publicacion implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private Autor autor;
	private Libro libro;
	private Date anioPublicacion;
	
	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name="id" )
	public int getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the anioPublicacion
	 */
	@Column( name = "anio_publicacion", nullable = false )
	public Date getAnioPublicacion() {
		return anioPublicacion;
	}

	/**
	 * @param anioPublicacion the anioPublicacion to set
	 */
	public void setAnioPublicacion(Date anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}

	/**
	 * @return the autor
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "autores_id", nullable = false)
	public Autor getAutor() {
		return autor;
	}

	/**
	 * @param autor the autor to set
	 */
	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	/**
	 * @return the libro
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "libros_isbn", nullable = false)
	public Libro getLibro() {
		return libro;
	}

	/**
	 * @param libro the libro to set
	 */
	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Publicacion [\n\tid=");
		stringBuilder.append(id);
		stringBuilder.append(", \n\tautor=");
		stringBuilder.append(autor);
		stringBuilder.append(", \n\tlibro=");
		stringBuilder.append(libro);
		stringBuilder.append(", \n\tanioPublicacion=");
		stringBuilder.append(anioPublicacion);
		stringBuilder.append("\n]");
		return stringBuilder.toString();
	}	
}
