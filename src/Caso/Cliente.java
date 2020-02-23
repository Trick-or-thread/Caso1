package Caso;

import java.util.Random;

public class Cliente extends Thread {
	
	/**
	 * Buffer para enviar mensaje a los servidores
	 */
	Buffer buffer;

	/**
	 * Cantidad de mensajes a ser enviados
	 */
	int cantidadMensajes;

	/**
	 * Metodo constructor del cliente	
	 * @param pBuffer Buffer para enviar mensaje a los servidores
	 */
	public Cliente(Buffer pBuffer, int pCantidadMensajes) {
		buffer = pBuffer;
		cantidadMensajes = pCantidadMensajes;
	}

	/**
	 * Metodo que ejecuta el thread al hacer start 
	 */
	@Override
	public void run() {
		buffer.entrarCliente();
		for(int i = 0; i < cantidadMensajes; i++) {
			Mensaje mensaje = new Mensaje(new Random().nextInt());
			while (!buffer.dejarMensaje(mensaje)) {
				yield();		
				
				System.out.println("CLIENTE >> INTENTO FALLIDO DE DEJAR EN EL BUFFER EL MENSAJE "+mensaje.getMensaje()+"  |  "+mensaje);
			}
			try	{
				synchronized(mensaje) {
					
					mensaje.esperar();
					System.out.println("CLIENTE >> A LA ESPERA DE RECEPCION DE RESPUESTA DE MENSAJE "+mensaje.getMensaje()+"  |  "+mensaje);
					mensaje.wait();
					System.out.println("CLIENTE >> RESPUESTA DEL SERVIDOR MEDIANTE EL BUFFER "+mensaje.getMensaje()+"  |  "+mensaje);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		buffer.salirCliente();
	}

}
