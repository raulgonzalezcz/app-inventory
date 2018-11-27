package mx.unam.posgrado.inventory.pojo;

public class FrmUsuario {
	private String mail;
	private String password;
	private String nombre;
	private String apPaterno;
	private String apMaterno;
	private boolean admin;
	
	public FrmUsuario() {}
	
	/**
	 * Constructor atributos obligatorios
	 * @param mail
	 * @param password
	 * @param nombre
	 * @param apPaterno
	 */
	public FrmUsuario(String mail, String password, String nombre, String apPaterno) {
		super();
		this.mail = mail;
		this.password = password;
		this.nombre = nombre;
		this.apPaterno = apPaterno;
	}

	/**
	 * Constructor completo
	 * @param mail
	 * @param password
	 * @param nombre
	 * @param apPaterno
	 * @param apMaterno
	 * @param admin
	 */
	public FrmUsuario(String mail, String password, String nombre, String apPaterno, String apMaterno, boolean admin) {
		super();
		this.mail = mail;
		this.password = password;
		this.nombre = nombre;
		this.apPaterno = apPaterno;
		this.apMaterno = apMaterno;
		this.admin = admin;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return the nombre
	 */
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
	 * @return the apPaterno
	 */
	public String getApPaterno() {
		return apPaterno;
	}
	
	/**
	 * @param apPaterno the apPaterno to set
	 */
	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}
	
	/**
	 * @return the apMaterno
	 */
	public String getApMaterno() {
		return apMaterno;
	}
	
	/**
	 * @param apMaterno the apMaterno to set
	 */
	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}
	
	/**
	 * @return the admin
	 */
	public boolean isAdmin() {
		return admin;
	}
	
	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	public String getNombreCompleto() {
		return new StringBuffer().append( nombre ).append(" ")
				.append( apPaterno ).append(
							( apMaterno != null ) ? " " + apMaterno : ""
						).toString();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Usuario [mail=");
		stringBuilder.append(mail);
		stringBuilder.append(", password=");
		stringBuilder.append(password);
		stringBuilder.append(", nombre=");
		stringBuilder.append(nombre);
		stringBuilder.append(", apPaterno=");
		stringBuilder.append(apPaterno);
		stringBuilder.append(", apMaterno=");
		stringBuilder.append(apMaterno);
		stringBuilder.append(", admin=");
		stringBuilder.append(admin);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
}
