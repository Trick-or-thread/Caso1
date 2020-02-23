package Caso;

public class Mensaje {
	
	/**
	 * Valor de la consulta.
	 */
	private int consulta;
	
	/**
	 * Determina si ya el cliente se puede despertar desde el mensaje.
	 */
	private boolean esperando;
	
	
	/**
	 * Constructor del mensaje
	 * @param pConsulta Valor de la consulta
	 */
	public Mensaje(int pConsulta) {
		
		consulta = pConsulta;
		
		esperando = false;
	}	
	
	/**
	 * M�todo que asegura que ya se puede despertar.
	 */
	public void esperar() {
		
		esperando = true;		
	}
	
	/**
	 * M�todo a invocar cuando ya se despert�.
	 */
	public void despertar() {
		
		esperando = false;
	}
	
	/**
	 * M�todo que determina si se est� esperando para ser despertado.
	 * @return true si est� esperando, false si no.
	 */
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
	
	/**
	 * M�todo que retorna el contenido mensaje.
	 * @return el contenido del mensaje.
	 */
	public int getMensaje() {
		
		return consulta;
	}

}
