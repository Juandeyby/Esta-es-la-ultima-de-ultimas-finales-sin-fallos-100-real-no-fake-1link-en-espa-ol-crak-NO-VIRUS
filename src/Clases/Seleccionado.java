package Clases;

public class Seleccionado {
	String  dni_participante;
	int codigo_cargoProceso;
	int codigo_listaProceso;
	
	public Seleccionado(String dni_participante, int codigo_cargoProceso, int codigo_listaProceso) {
		super();
		this.dni_participante = dni_participante;
		this.codigo_cargoProceso = codigo_cargoProceso;
		this.codigo_listaProceso = codigo_listaProceso;
	}

	public String getDni_participante() {
		return dni_participante;
	}

	public void setDni_participante(String dni_participante) {
		this.dni_participante = dni_participante;
	}

	public int getCodigo_cargoProceso() {
		return codigo_cargoProceso;
	}

	public void setCodigo_cargoProceso(int codigo_cargoProceso) {
		this.codigo_cargoProceso = codigo_cargoProceso;
	}

	public int getCodigo_listaProceso() {
		return codigo_listaProceso;
	}

	public void setCodigo_listaProceso(int codigo_listaProceso) {
		this.codigo_listaProceso = codigo_listaProceso;
	}

	@Override
	public String toString() {
		return "Seleccionado [dni_participante=" + dni_participante + ", codigo_cargoProceso=" + codigo_cargoProceso
				+ ", codigo_listaProceso=" + codigo_listaProceso + "]";
	}
	
	
}
