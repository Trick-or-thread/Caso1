package Caso;

public class Servidor extends Thread {
	
	Buffer buffer;
	
	public Servidor(Buffer pBuffer) {
		
		buffer = pBuffer;
	}
	
	public void leer() {
		
		Mensaje msj = null;
		
		while((msj = buffer.sacarMensaje()) == null) {
			
			System.out.println("SERVIDOR>> Intento fallido de sacar un mensaje.");
			
			yield();			
		}
		
		System.out.println("SERVIDOR>> Lectura del mensaje:"+msj);
		
		msj.setMensaje(msj.getMensaje() + 1);
		msj.notify();
	}
	
	public void run() {
		while(buffer.existenClientes()) {
			leer();
		}
	}
}
