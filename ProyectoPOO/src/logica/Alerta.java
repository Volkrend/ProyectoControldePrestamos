package logica;

import java.time.LocalDateTime;

public class Alerta {
	private String mensaje;
	private boolean esRecurrente;
	private int intervalo;
	private LocalDateTime fechaActivacion;
	
	public Alerta(String mensaje, boolean esRecurrente, int intervalo, LocalDateTime fechaActivacion) {
		this.mensaje = mensaje;
        this.esRecurrente = esRecurrente;
        this.intervalo = intervalo;
        this.fechaActivacion = fechaActivacion;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public boolean isEsRecurrente() {
		return esRecurrente;
	}

	public void setEsRecurrente(boolean esRecurrente) {
		this.esRecurrente = esRecurrente;
	}

	public int getIntervalo() {
		return intervalo;
	}

	public void setIntervalo(int intervalo) {
		this.intervalo = intervalo;
	}

	public LocalDateTime getFechaActivacion() {
		return fechaActivacion;
	}
	
   
}
