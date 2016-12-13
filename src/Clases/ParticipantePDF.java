package Clases;

public class ParticipantePDF {
	private String dni_paarticipante;
	private String nombre_participante;
	private String apellido_participante;
	private String cargo_participante;
	
	public ParticipantePDF(String dni_paarticipante, String nombre_participante, String apellido_participante,
			String cargo_participante) {
		this.dni_paarticipante = dni_paarticipante;
		this.nombre_participante = nombre_participante;
		this.apellido_participante = apellido_participante;
		this.cargo_participante = cargo_participante;
	}
	public String getDni_paarticipante() {
		return dni_paarticipante;
	}
	public void setDni_paarticipante(String dni_paarticipante) {
		this.dni_paarticipante = dni_paarticipante;
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
	public String getCargo_participante() {
		return cargo_participante;
	}
	public void setCargo_participante(String cargo_participante) {
		this.cargo_participante = cargo_participante;
	}
}