package Caso;

import java.util.Random;

public class Cliente extends Thread {
	
	Mensaje mensaje;
	
	Buffer buffer;
	
	public Cliente(Buffer pBuffer) {
		
		mensaje = new Mensaje( new Random().nextInt());
		
		buffer = pBuffer;
		
	}
	
	public void enviar() {
		
		
	}
		
		
}
