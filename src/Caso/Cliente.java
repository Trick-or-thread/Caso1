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
	 * Metodo para enviar un mensaje al buffer, si no lo logra permanece en espera activa.
	 */	
	public void enviar(Mensaje mensaje) {
				
		while (!buffer.dejarMensaje(mensaje)) {
			
			System.out.println("CLIENTE>> Esperando para enviar: "+mensaje);
			yield();	
			
		}
		try	{
			
			System.out.println("CLIENTE>> Enviado: "+mensaje+" | Valor: "+mensaje.getMensaje());
			
			synchronized (mensaje) {
				
				mensaje.wait();
				
			}	
			
			
			System.out.println("CLIENTE>> Recibido: "+mensaje+"| Valor: "+mensaje.getMensaje());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que ejecuta el thread al hacer start 
	 */
	@Override
	public void run() {
		buffer.entrarCliente();
		for(int i = 0; i < cantidadMensajes; i++) {
			
			Mensaje mensaje = new Mensaje(new Random().nextInt(), this);
			enviar(mensaje);
		}
		buffer.salirCliente();
	}

}
