package mx.unam.posgrado.inventory.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * 
 * @author Gabriel Gonzalez
 *
 */
@Entity
@Table(name = "libro")
public class Libro implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	private String isbn;
	private String titulo;
	private Genero genero;
	
	/**
	 * @return the isbn
	 */
	@Id
	// @GeneratedValue(strategy = IDENTITY) for auto-increment
	@Column(name = "isbn", unique = true, nullable = false, length=14)
	public String getIsbn() {
		return isbn;
	}
	
	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	/**
	 * @return the titulo
	 */
	@Column(name = "titulo", nullable = false, length = 255)
	public String getTitulo() {
		return this.titulo;
	}
	
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Manejo del campo que servirá como llave foránea, la cual
	 * hace referencia a la tabla generos
	 * @return the genero
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "generos_id_generos", nullable = false)
	public Genero getGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Libro [isbn=");
		stringBuilder.append(isbn);
		stringBuilder.append(", \n\ttitulo=");
		stringBuilder.append(titulo);
		stringBuilder.append(", \n\tgenero=");
		stringBuilder.append(genero);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}	
}
