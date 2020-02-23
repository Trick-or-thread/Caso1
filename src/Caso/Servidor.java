package Caso;

public class Servidor extends Thread {
	
	Buffer buffer;
	
	public Servidor(Buffer pBuffer) {
		
		buffer = pBuffer;
	}
	
	public void leer() {
<<<<<<< HEAD
=======

		Mensaje msj = null;
		
		while((msj = buffer.sacarMensaje()) == null) {
			
			yield();			
		}
		
		msj.setMensaje(msj.getMensaje() + 1);
		
		msj.notify();
		
	}
>>>>>>> 10f790ad7f7d1ee6cbbb1e5c48210353724fa4dc

		Mensaje msj = null;
		
		while((msj = buffer.sacarMensaje()) == null) {
			
			yield();			
		}
		
		msj.setMensaje(msj.getMensaje() + 1);
		
		msj.notify();
		
	}
}
