package Caso;

public class Main {
	
	public static void main(String[] args) {
		
		Buffer buffer = new Buffer(2);
		for(int i = 0; i < 10; i++) {
			Cliente cliente = new Cliente(buffer, 5);
			cliente.start();
		}
		for(int i = 0; i < 5; i++) {
			Servidor servidor = new Servidor(buffer);
			servidor.start();
		}
	}

}
