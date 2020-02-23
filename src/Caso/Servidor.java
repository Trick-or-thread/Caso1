package Caso;

public class Servidor extends Thread {
	
	Buffer buffer;
	
	public Servidor(Buffer pBuffer) {
		
		buffer = pBuffer;
	}
	
	public void leer() {
		Mensaje msj;
		while((msj = buffer.sacarMensaje()) == null) {	
			yield();
		}
		msj.setMensaje(msj.getMensaje() + 1);
		msj.notify();
	}
	
	public void run() {
		while(buffer.existenClientes()) {
			leer();
		}
	}
}
