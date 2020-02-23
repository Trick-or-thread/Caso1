package Caso;

public class Mensaje {
	
	/**
	 * Valor de la consulta.
	 */
	int consulta;
	
	/**
	 * Constructor del mensaje
	 * @param pConsulta Valor de la consulta
	 */
	public Mensaje(int pConsulta) {
		
		consulta = pConsulta;
	}
	
	/**
	 * Cambia el valor de consulta al parametro pValor
	 * @param pValor Valor que va a tomar consulta
	 */	
	public void setMensaje(int pValor) {
		
		consulta = pValor;
	}

}
