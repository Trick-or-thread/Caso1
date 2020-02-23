package Caso;

public class Mensaje {
	
	/**
	 * Valor de la consulta.
	 */
	private int consulta;
	
	private boolean esperando;
	
	
	/**
	 * Constructor del mensaje
	 * @param pConsulta Valor de la consulta
	 */
	public Mensaje(int pConsulta) {
		
		consulta = pConsulta;
		
		esperando = false;
	}	
	
	public void esperar() {
		
		esperando = true;		
	}
	
	public void despertar() {
		
		esperando = false;
	}
	
	public boolean estaEsperando() {
		
		return esperando;
	}
	
	/**
	 * Cambia el valor de consulta al parametro pValor
	 * @param pValor Valor que va a tomar consulta
	 */	
	public void setMensaje(int pValor) {
		consulta = pValor;
	}
	
	public int getMensaje() {
		
		return consulta;
	}

}
