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
				System.out.println("SERVIDOR >> INTENTO FALLIDO DE SACAR MENSAJE, EL BUFFER ESTA VACIO");
			} else { 
				msj.setMensaje(msj.getMensaje() + 1);

				//Esto asegura que el cliente haya hecho wait antes de hacer notify				
				while(!msj.estaEsperando()) {System.out.println("SERVIDOR >> ESPERANDO QUE EL CLIENTE ESTE A LA ESPERA DE LA RESPUESTA "+msj.getMensaje()+"  |  "+msj);}

				synchronized(msj) {

					msj.notify();

					msj.despertar();
					
					System.out.println("SERVIDOR >> ENVIADA RESPUESTA AL CLIENTE "+msj.getMensaje()+"  |  "+msj);

				}
			}
		}
	}
}
