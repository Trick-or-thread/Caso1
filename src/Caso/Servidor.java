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
	 * M�todo run del thread. Saca mensajes y los resuelve hasta que no haya m�s clientes.
	 */
	public void run() {
		Mensaje msj;
		while((msj = buffer.sacarMensaje()) != null || buffer.existenClientes()) {
			if(msj == null) {
				System.out.println("SERVIDOR>> No hay mensajes");
				yield();
			} else { 
				System.out.println("SERVIDOR>> Se modifico el mensaje "+msj);				
				msj.setMensaje(msj.getMensaje() + 1);
				synchronized(msj) {
					msj.notify();
				}
			}
		}
	}
}
