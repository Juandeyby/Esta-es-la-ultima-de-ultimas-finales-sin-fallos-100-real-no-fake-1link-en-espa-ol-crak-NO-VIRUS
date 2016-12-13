package Clases;

public class Usuario {
	 
	int id_usuario;
	String nombre_usuario;
	String contrasenia_usuario;
	String pregunta_secreta_usuario;
	String respuesta_pregunta_secreta_usuario;
	int anio_cuenta_generada_usuario;
	int mes_cuenta_generada_usuario;
	int dia_cuenta_generada_usuario;
	int id_tipo_usuario;

	public Usuario(int id_usuario, int anio_cuenta_generada_usuario, int mes_cuenta_generada_usuario,
			int dia_cuenta_generada_usuario) {
		super();
		this.id_usuario = id_usuario;
		this.anio_cuenta_generada_usuario = anio_cuenta_generada_usuario;
		this.mes_cuenta_generada_usuario = mes_cuenta_generada_usuario;
		this.dia_cuenta_generada_usuario = dia_cuenta_generada_usuario;
	}

	public Usuario(int id_usuario, String nombre_usuario, String contrasenia_usuario, String pregunta_secreta_usuario,
			String respuesta_pregunta_secreta_usuario, int anio_cuenta_generada_usuario,
			int mes_cuenta_generada_usuario, int dia_cuenta_generada_usuario, int id_tipo_usuario) {
		super();
		this.id_usuario = id_usuario;
		this.nombre_usuario = nombre_usuario;
		this.contrasenia_usuario = contrasenia_usuario;
		this.pregunta_secreta_usuario = pregunta_secreta_usuario;
		this.respuesta_pregunta_secreta_usuario = respuesta_pregunta_secreta_usuario;
		this.anio_cuenta_generada_usuario = anio_cuenta_generada_usuario;
		this.mes_cuenta_generada_usuario = mes_cuenta_generada_usuario;
		this.dia_cuenta_generada_usuario = dia_cuenta_generada_usuario;
		this.id_tipo_usuario = id_tipo_usuario;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getContrasenia_usuario() {
		return contrasenia_usuario;
	}

	public void setContrasenia_usuario(String contrasenia_usuario) {
		this.contrasenia_usuario = contrasenia_usuario;
	}

	public String getPregunta_secreta_usuario() {
		return pregunta_secreta_usuario;
	}

	public void setPregunta_secreta_usuario(String pregunta_secreta_usuario) {
		this.pregunta_secreta_usuario = pregunta_secreta_usuario;
	}

	public String getRespuesta_pregunta_secreta_usuario() {
		return respuesta_pregunta_secreta_usuario;
	}

	public void setRespuesta_pregunta_secreta_usuario(String respuesta_pregunta_secreta_usuario) {
		this.respuesta_pregunta_secreta_usuario = respuesta_pregunta_secreta_usuario;
	}

	public int getAnio_cuenta_generada_usuario() {
		return anio_cuenta_generada_usuario;
	}

	public void setAnio_cuenta_generada_usuario(int anio_cuenta_generada_usuario) {
		this.anio_cuenta_generada_usuario = anio_cuenta_generada_usuario;
	}

	public int getMes_cuenta_generada_usuario() {
		return mes_cuenta_generada_usuario;
	}

	public void setMes_cuenta_generada_usuario(int mes_cuenta_generada_usuario) {
		this.mes_cuenta_generada_usuario = mes_cuenta_generada_usuario;
	}

	public int getDia_cuenta_generada_usuario() {
		return dia_cuenta_generada_usuario;
	}

	public void setDia_cuenta_generada_usuario(int dia_cuenta_generada_usuario) {
		this.dia_cuenta_generada_usuario = dia_cuenta_generada_usuario;
	}

	public int getId_tipo_usuario() {
		return id_tipo_usuario;
	}

	public void setId_tipo_usuario(int id_tipo_usuario) {
		this.id_tipo_usuario = id_tipo_usuario;
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", nombre_usuario=" + nombre_usuario + ", contrasenia_usuario="
				+ contrasenia_usuario + ", pregunta_secreta_usuario=" + pregunta_secreta_usuario
				+ ", respuesta_pregunta_secreta_usuario=" + respuesta_pregunta_secreta_usuario
				+ ", anio_cuenta_generada_usuario=" + anio_cuenta_generada_usuario + ", mes_cuenta_generada_usuario="
				+ mes_cuenta_generada_usuario + ", dia_cuenta_generada_usuario=" + dia_cuenta_generada_usuario
				+ ", id_tipo_usuario=" + id_tipo_usuario + "]";
	}
}
