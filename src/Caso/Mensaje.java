package Caso;

public class Mensaje {
	
	/**
	 * Valor de la consulta.
	 */
	private int consulta;
	
	private Cliente cliente;	
	
	/**
	 * Constructor del mensaje
	 * @param pConsulta Valor de la consulta
	 */
	public Mensaje(int pConsulta, Cliente pCliente) {
		consulta = pConsulta;
		cliente = pCliente;
	}	
	
	public Cliente getCliente() {
		
		return cliente;
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
