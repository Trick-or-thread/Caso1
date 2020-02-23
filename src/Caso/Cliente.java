package Caso;

import java.util.Random;

public class Cliente extends Thread {
	
	int consulta;
	
	Buffer buffer;
	
	public Cliente(Buffer pBuffer) {
		
		consulta = new Random().nextInt();
		
		buffer = pBuffer;
		
	}
	
	public void enviar() {
		
		
	}
		
		
}
