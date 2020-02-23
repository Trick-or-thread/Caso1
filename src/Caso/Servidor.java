package Caso;

public class Servidor extends Thread {
	
	Buffer buffer;
	
	public Servidor(Buffer pBuffer) {
		
		buffer = pBuffer;
	}
	
	public void leer() {

		Mensaje msj = null;
		
		while((msj = buffer.sacarMensaje()) == null) {
			
			yield();			
		}
		
		msj.setMensaje(msj.getMensaje() + 1);
		
		msj.notify();
		
	}

}
