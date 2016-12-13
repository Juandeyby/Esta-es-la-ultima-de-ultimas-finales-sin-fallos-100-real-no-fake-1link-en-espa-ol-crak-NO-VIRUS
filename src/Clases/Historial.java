package Clases;
public class Historial {
	int codigoAnioProceso;
	int codigoTipoProceso;
	int codigoCargoProceso;
	String observacion_historialProceso;
	int experiencia_historialProceso;
	String dni;
	public Historial(int codigoAnioProceso, int codigoTipoProceso, int codigoCargoProceso,
			String observacion_historialProceso, int experiencia_historialProceso, String dni) {
		super();
		this.codigoAnioProceso = codigoAnioProceso;
		this.codigoTipoProceso = codigoTipoProceso;
		this.codigoCargoProceso = codigoCargoProceso;
		this.observacion_historialProceso = observacion_historialProceso;
		this.experiencia_historialProceso = experiencia_historialProceso;
		this.dni = dni;
	}
	public int getCodigoAnioProceso() {
		return codigoAnioProceso;
	}
	public void setCodigoAnioProceso(int codigoAnioProceso) {
		this.codigoAnioProceso = codigoAnioProceso;
	}
	public int getCodigoTipoProceso() {
		return codigoTipoProceso;
	}
	public void setCodigoTipoProceso(int codigoTipoProceso) {
		this.codigoTipoProceso = codigoTipoProceso;
	}
	public int getCodigoCargoProceso() {
		return codigoCargoProceso;
	}
	public void setCodigoCargoProceso(int codigoCargoProceso) {
		this.codigoCargoProceso = codigoCargoProceso;
	}
	public String getObservacion_historialProceso() {
		return observacion_historialProceso;
	}
	public void setObservacion_historialProceso(String observacion_historialProceso) {
		this.observacion_historialProceso = observacion_historialProceso;
	}
	public int getExperiencia_historialProceso() {
		return experiencia_historialProceso;
	}
	public void setExperiencia_historialProceso(int experiencia_historialProceso) {
		this.experiencia_historialProceso = experiencia_historialProceso;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	@Override
	public String toString() {
		return "Historial [codigoAnioProceso=" + codigoAnioProceso + ", codigoTipoProceso=" + codigoTipoProceso
				+ ", codigoCargoProceso=" + codigoCargoProceso + ", observacion_historialProceso="
				+ observacion_historialProceso + ", experiencia_historialProceso=" + experiencia_historialProceso
				+ ", dni=" + dni + "]";
	}
}