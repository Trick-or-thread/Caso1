package Caso;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Main {

	public static void main(String[] args) {

		File seleccionado = new File("./data/datos.properties");

		Properties propiedades = new Properties( );
		
		try {
			
			FileInputStream x = new FileInputStream(seleccionado);
			
			propiedades.load(x);
			
			x.close();
			
		} catch (Exception e) {
			
		}
		
		int buffersize = Integer.parseInt(propiedades.getProperty("caso.buffersize"));

		int clientes = Integer.parseInt(propiedades.getProperty("caso.clientes"));
		
		int mensajesporcliente = Integer.parseInt(propiedades.getProperty("caso.mensajesporcliente"));
		
		int servidores = Integer.parseInt(propiedades.getProperty("caso.servidores"));	
		
		
	
		Buffer buffer = new Buffer(buffersize);
		for(int i = 0; i < clientes; i++) {
			Cliente cliente = new Cliente(buffer, mensajesporcliente);
			cliente.start();
		}
		for(int i = 0; i < servidores; i++) {
			Servidor servidor = new Servidor(buffer);
			servidor.start();
		}
	}

}
