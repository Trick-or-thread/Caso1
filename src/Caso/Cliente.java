package Caso;

import java.util.Random;

public class Cliente extends Thread {
	
	/**
	 * Mensaje que va a dejar el cliente
	 */
	Mensaje mensaje;
	
	/**
	 * Buffer para enviar mensaje a los servidores
	 */
	Buffer buffer;
	
	/**
	 * Metodo constructor del cliente	
	 * @param pBuffer Buffer para enviar mensaje a los servidores
	 */
	public Cliente(Buffer pBuffer) {
		
		mensaje = new Mensaje(new Random().nextInt());
		
		buffer = pBuffer;
		
	}
	
	/**
	 * Metodo para enviar un mensaje al buffer, si no lo logra permanece en espera activa.
	 */	
	public void enviar() {
		
		while (!buffer.dejarMensaje(mensaje)) {
			
			yield();
			
		}
		
		try	{
			
		mensaje.wait();
		
		} catch (InterruptedException e) {}
	}
	
		
}
