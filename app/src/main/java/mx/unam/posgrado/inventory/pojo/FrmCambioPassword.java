package mx.unam.posgrado.inventory.pojo;

/**
 * POJO para almacenar los parámetros de la forma de 
 * cambio de contraseña
 * 
 * @author Gabriel Gonzalez
 *
 */
public class FrmCambioPassword {
	private String passwdAnterior;
	private String passwdNuevo;
	private String passwdConfirmacion;
	
	/**
	 * @return the passwdAnterior
	 */
	public String getPasswdAnterior() {
		return passwdAnterior;
	}
	/**
	 * @param passwdAnterior the passwdAnterior to set
	 */
	public void setPasswdAnterior(String passwdAnterior) {
		this.passwdAnterior = passwdAnterior;
	}
	/**
	 * @return the passwdNuevo
	 */
	public String getPasswdNuevo() {
		return passwdNuevo;
	}
	/**
	 * @param passwdNuevo the passwdNuevo to set
	 */
	public void setPasswdNuevo(String passwdNuevo) {
		this.passwdNuevo = passwdNuevo;
	}
	/**
	 * @return the passwdConfirmacion
	 */
	public String getPasswdConfirmacion() {
		return passwdConfirmacion;
	}
	/**
	 * @param passwdConfirmacion the passwdConfirmacion to set
	 */
	public void setPasswdConfirmacion(String passwdConfirmacion) {
		this.passwdConfirmacion = passwdConfirmacion;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FrmCambioPassword [passwdAnterior=");
		builder.append(passwdAnterior);
		builder.append(", passwdNuevo=");
		builder.append(passwdNuevo);
		builder.append(", passwdConfirmacion=");
		builder.append(passwdConfirmacion);
		builder.append("]");
		return builder.toString();
	}
}
