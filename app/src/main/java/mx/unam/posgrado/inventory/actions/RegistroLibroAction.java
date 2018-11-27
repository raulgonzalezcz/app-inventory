package mx.unam.posgrado.inventory.actions;

import org.apache.log4j.Logger;

import mx.unam.posgrado.inventory.hibernate.Genero;
import mx.unam.posgrado.inventory.hibernate.GeneroDAO;
import mx.unam.posgrado.inventory.hibernate.Libro;
import mx.unam.posgrado.inventory.hibernate.LibroDAO;
import mx.unam.posgrado.inventory.hibernate.UsuarioDAO;

public class RegistroLibroAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(RegistroLibroAction.class);
	
	private Libro libro;
	private String idGeneroSeleccionado;
	
	public String addBook() {
		logger.info("addBook()");
		
		Genero genero = new Genero();
		GeneroDAO dao = new GeneroDAO();
		genero  = dao.findById( Short.parseShort( idGeneroSeleccionado ) );
		
		libro.setGenero(genero);
		
		LibroDAO daoL = new LibroDAO();
		logger.info("Inf1");
		logger.info(libro.toString());
		daoL.saveLibro(libro);
		
		return "success";
	}
	
	/**
	 * @return the libro
	 */
	public Libro getLibro() {
		return libro;
	}

	/**
	 * @param libro the libro to set
	 */
	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	/**
	 * @return the idGeneroSeleccionado
	 */
	public String getIdGeneroSeleccionado() {
		return idGeneroSeleccionado;
	}

	/**
	 * @param idGeneroSeleccionado the idGeneroSeleccionado to set
	 */
	public void setIdGeneroSeleccionado(String idGeneroSeleccionado) {
		this.idGeneroSeleccionado = idGeneroSeleccionado;
	}
}
