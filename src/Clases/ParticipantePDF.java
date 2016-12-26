package Clases;

public class ParticipantePDF {
	private String dni_paarticipante;
	private String nombre_participante;
	private String apellido_participante;
	private String cargo_participante;
	private String nombre_tipo_proceso;
	private String nombre_fase_proceso;
	
	public ParticipantePDF(String dni_paarticipante, String nombre_participante, String apellido_participante,
			String cargo_participante, String nombre_tipo_proceso, String nombre_fase_proceso) {
		this.dni_paarticipante = dni_paarticipante;
		this.nombre_participante = nombre_participante;
		this.apellido_participante = apellido_participante;
		this.cargo_participante = cargo_participante;
		this.nombre_tipo_proceso = nombre_tipo_proceso;
		this.nombre_fase_proceso = nombre_fase_proceso;
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
	public String getNombre_tipo_proceso(){
		return nombre_tipo_proceso;
	}
	public void setNombre_tipo_proceso(String nombre_tipo_proceso){
		this.nombre_tipo_proceso = nombre_tipo_proceso;
	}
	public String getNombre_fase_proceso(){
		return nombre_fase_proceso;
	}
	public void setNombre_fase_proceso(String nombre_fase_proceso){
		this.nombre_fase_proceso = nombre_fase_proceso;
	}
}