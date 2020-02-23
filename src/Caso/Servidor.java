package Caso;

public class Servidor extends Thread {

	/**
	 * Buffer desde el cual se reciben peticiones.
	 */
	private Buffer buffer;

	/**
	 * Constructor del Servidor.
	 * @param pBuffer buffer del cual se reciben peticiones.
	 */
	public Servidor(Buffer pBuffer) {
		buffer = pBuffer;
	}

	/**
	 * Método run del thread. Saca mensajes y los resuelve hasta que no haya más clientes.
	 */
	public void run() {
		Mensaje msj;
		while((msj = buffer.sacarMensaje()) != null || buffer.existenClientes()) {
			if(msj == null) {
				yield();
			} else { 
				msj.setMensaje(msj.getMensaje() + 1);

				while(!msj.estaEsperando()) {}

				synchronized(msj) {

					msj.notify();

					msj.despertar();

				}
			}
		}
	}
}
