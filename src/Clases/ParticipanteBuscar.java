package Clases;

public class ParticipanteBuscar {
	
	String dni_participante;
	String nombre_participante;
	String apellido_participante;
	String telefono_participante;
	int telefono_oficina_participante;
	int celular_participante;
	String correo_participante;
	String correo_institucional_participante;
	String direccion_participante;
	boolean estado_participante;
	String id_facultad;
	String id_especialidad;
	String id_tipo_condicion;
	String id_funcion;
	String id_tipo_participante;
	boolean buscar;
	public ParticipanteBuscar(String dni_participante, String nombre_participante, String apellido_participante,
			String telefono_participante, int telefono_oficina_participante, int celular_participante,
			String correo_participante, String correo_institucional_participante, String direccion_participante,
			boolean estado_participante, String id_facultad, String id_especialidad, String id_tipo_condicion,
			String id_funcion, String id_tipo_participante, boolean buscar) {
		super();
		this.dni_participante = dni_participante;
		this.nombre_participante = nombre_participante;
		this.apellido_participante = apellido_participante;
		this.telefono_participante = telefono_participante;
		this.telefono_oficina_participante = telefono_oficina_participante;
		this.celular_participante = celular_participante;
		this.correo_participante = correo_participante;
		this.correo_institucional_participante = correo_institucional_participante;
		this.direccion_participante = direccion_participante;
		this.estado_participante = estado_participante;
		this.id_facultad = id_facultad;
		this.id_especialidad = id_especialidad;
		this.id_tipo_condicion = id_tipo_condicion;
		this.id_funcion = id_funcion;
		this.id_tipo_participante = id_tipo_participante;
		this.buscar = buscar;
	}
	
	public ParticipanteBuscar(ParticipanteOut participanteOut, boolean buscar) {
		super();
		this.dni_participante = participanteOut.dni_participante;
		this.nombre_participante = participanteOut.nombre_participante;
		this.apellido_participante = participanteOut.apellido_participante;
		this.telefono_participante = participanteOut.telefono_participante;
		this.telefono_oficina_participante = participanteOut.telefono_oficina_participante;
		this.celular_participante = participanteOut.celular_participante;
		this.correo_participante = participanteOut.correo_participante;
		this.correo_institucional_participante = participanteOut.correo_institucional_participante;
		this.direccion_participante = participanteOut.direccion_participante;
		this.estado_participante = participanteOut.estado_participante;
		this.id_facultad = participanteOut.id_facultad;
		this.id_especialidad = participanteOut.id_especialidad;
		this.id_tipo_condicion = participanteOut.id_tipo_condicion;
		this.id_funcion = participanteOut.id_funcion;
		this.id_tipo_participante = participanteOut.id_tipo_participante;
		this.buscar = buscar;
	}
	
	public String getDni_participante() {
		return dni_participante;
	}
	public void setDni_participante(String dni_participante) {
		this.dni_participante = dni_participante;
	}
	public String getNombre_participante() {
		return nombre_participante;
	}
	public void setNombre_participante(String nombre_participante) {
		this.nombre_participante = nombre_participante;
	}
	public String getApellido_participante() {
		return apellido_participante;
	}
	public void setApellido_participante(String apellido_participante) {
		this.apellido_participante = apellido_participante;
	}
	public String getTelefono_participante() {
		return telefono_participante;
	}
	public void setTelefono_participante(String telefono_participante) {
		this.telefono_participante = telefono_participante;
	}
	public int getTelefono_oficina_participante() {
		return telefono_oficina_participante;
	}
	public void setTelefono_oficina_participante(int telefono_oficina_participante) {
		this.telefono_oficina_participante = telefono_oficina_participante;
	}
	public int getCelular_participante() {
		return celular_participante;
	}
	public void setCelular_participante(int celular_participante) {
		this.celular_participante = celular_participante;
	}
	public String getCorreo_participante() {
		return correo_participante;
	}
	public void setCorreo_participante(String correo_participante) {
		this.correo_participante = correo_participante;
	}
	public String getCorreo_institucional_participante() {
		return correo_institucional_participante;
	}
	public void setCorreo_institucional_participante(String correo_institucional_participante) {
		this.correo_institucional_participante = correo_institucional_participante;
	}
	public String getDireccion_participante() {
		return direccion_participante;
	}
	public void setDireccion_participante(String direccion_participante) {
		this.direccion_participante = direccion_participante;
	}
	public boolean isEstado_participante() {
		return estado_participante;
	}
	public void setEstado_participante(boolean estado_participante) {
		this.estado_participante = estado_participante;
	}
	public String getId_facultad() {
		return id_facultad;
	}
	public void setId_facultad(String id_facultad) {
		this.id_facultad = id_facultad;
	}
	public String getId_especialidad() {
		return id_especialidad;
	}
	public void setId_especialidad(String id_especialidad) {
		this.id_especialidad = id_especialidad;
	}
	public String getId_tipo_condicion() {
		return id_tipo_condicion;
	}
	public void setId_tipo_condicion(String id_tipo_condicion) {
		this.id_tipo_condicion = id_tipo_condicion;
	}
	public String getId_funcion() {
		return id_funcion;
	}
	public void setId_funcion(String id_funcion) {
		this.id_funcion = id_funcion;
	}
	public String getId_tipo_participante() {
		return id_tipo_participante;
	}
	public void setId_tipo_participante(String id_tipo_participante) {
		this.id_tipo_participante = id_tipo_participante;
	}
	public boolean isBuscar() {
		return buscar;
	}
	public void setBuscar(boolean buscar) {
		this.buscar = buscar;
	}
	
	public ParticipanteOut getParticipanteOut() {
		ParticipanteOut paticipanteOut = new ParticipanteOut(
				dni_participante,
				nombre_participante,
				apellido_participante,
				telefono_participante,
				telefono_oficina_participante,
				celular_participante,
				correo_participante,
				correo_institucional_participante,
				direccion_participante,
				estado_participante,
				id_facultad,
				id_especialidad,
				id_tipo_condicion,
				id_funcion,
				id_tipo_participante);
		return paticipanteOut;
	}
	
	@Override
	public String toString() {
		return "ParticipanteBuscar [dni_participante=" + dni_participante + ", nombre_participante="
				+ nombre_participante + ", apellido_participante=" + apellido_participante + ", telefono_participante="
				+ telefono_participante + ", telefono_oficina_participante=" + telefono_oficina_participante
				+ ", celular_participante=" + celular_participante + ", correo_participante=" + correo_participante
				+ ", correo_institucional_participante=" + correo_institucional_participante
				+ ", direccion_participante=" + direccion_participante + ", estado_participante=" + estado_participante
				+ ", id_facultad=" + id_facultad + ", id_especialidad=" + id_especialidad + ", id_tipo_condicion="
				+ id_tipo_condicion + ", id_funcion=" + id_funcion + ", id_tipo_participante=" + id_tipo_participante
				+ ", buscar=" + buscar + "]";
	}
}