package mx.unam.posgrado.inventory.pojo;

/**
 * POJO empleado para recibir los valores de una forma Web
 * @author Gabriel Gonzalez
 *
 */
public class FrmLogin {
	private String correo;
	private String contrasena;
	
	public FrmLogin() {}
	
	/**
	 * Constructor completo
	 * @param correo
	 * @param contrasena
	 */
	public FrmLogin(String correo, String contrasena) {
		this.correo = correo;
		this.contrasena = contrasena;
	}



	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo; 
	}
	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @return the contrasena
	 */
	public String getContrasena() {
		return contrasena;
	}
	/**
	 * @param contrasena the contrasena to set
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Login [correo=");
		stringBuilder.append(correo);
		stringBuilder.append(", contrasena=");
		stringBuilder.append(contrasena);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
}
