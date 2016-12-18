package Clases;

public class Historial {
	
	String dni_participante;
	int id_tipo_proceso;
	int id_fase_proceso;
	int anio_proceso;
	int id_cargo_proceso;
	int experiencia_historial_proceso;
	String observacion_historial_proceso;
	
	public Historial(String dni_participante, int id_tipo_proceso, int id_fase_proceso, int anio_proceso,
			int id_cargo_proceso, int experiencia_historial_proceso, String observacion_historial_proceso) {
		super();
		this.dni_participante = dni_participante;
		this.id_tipo_proceso = id_tipo_proceso;
		this.id_fase_proceso = id_fase_proceso;
		this.anio_proceso = anio_proceso;
		this.id_cargo_proceso = id_cargo_proceso;
		this.experiencia_historial_proceso = experiencia_historial_proceso;
		this.observacion_historial_proceso = observacion_historial_proceso;
	}

	public String getDni_participante() {
		return dni_participante;
	}

	public void setDni_participante(String dni_participante) {
		this.dni_participante = dni_participante;
	}

	public int getId_tipo_proceso() {
		return id_tipo_proceso;
	}

	public void setId_tipo_proceso(int id_tipo_proceso) {
		this.id_tipo_proceso = id_tipo_proceso;
	}

	public int getId_fase_proceso() {
		return id_fase_proceso;
	}

	public void setId_fase_proceso(int id_fase_proceso) {
		this.id_fase_proceso = id_fase_proceso;
	}

	public int getAnio_proceso() {
		return anio_proceso;
	}

	public void setAnio_proceso(int anio_proceso) {
		this.anio_proceso = anio_proceso;
	}

	public int getId_cargo_proceso() {
		return id_cargo_proceso;
	}

	public void setId_cargo_proceso(int id_cargo_proceso) {
		this.id_cargo_proceso = id_cargo_proceso;
	}

	public int getExperiencia_historial_proceso() {
		return experiencia_historial_proceso;
	}

	public void setExperiencia_historial_proceso(int experiencia_historial_proceso) {
		this.experiencia_historial_proceso = experiencia_historial_proceso;
	}

	public String getObservacion_historial_proceso() {
		return observacion_historial_proceso;
	}

	public void setObservacion_historial_proceso(String observacion_historial_proceso) {
		this.observacion_historial_proceso = observacion_historial_proceso;
	}

	@Override
	public String toString() {
		return "HistorialOut [dni_participante=" + dni_participante + ", id_tipo_proceso=" + id_tipo_proceso
				+ ", id_fase_proceso=" + id_fase_proceso + ", anio_proceso=" + anio_proceso + ", id_cargo_proceso="
				+ id_cargo_proceso + ", experiencia_historial_proceso=" + experiencia_historial_proceso
				+ ", observacion_historial_proceso=" + observacion_historial_proceso + "]";
	}
}
