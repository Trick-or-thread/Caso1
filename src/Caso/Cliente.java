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
	public Cliente(Buffer pBuffer) {
				
		buffer = pBuffer;
		
	}
	
	/**
	 * Metodo para enviar un mensaje al buffer, si no lo logra permanece en espera activa.
	 */	
	public void enviar(Mensaje mensaje) {
		
		while (!buffer.dejarMensaje(mensaje)) {
			
			yield();
			
		}
		
		try	{
			
		mensaje.wait();
		
		} catch (InterruptedException e) {}
	}
	
	/**
	 * Metodo que ejecuta el thread al hacer start 
	 */
	@Override
	public void run() {
		
		for(int i = 0; i < cantidadMensajes; i++) {
			
			Mensaje mensaje = new Mensaje(new Random().nextInt());
			
			enviar(mensaje);

		}		

	}
		
}
