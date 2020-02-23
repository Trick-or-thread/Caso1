package Caso;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Main extends JFrame {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		Main esto = new Main();

		JFileChooser chooser = new JFileChooser( "./data/" );
		chooser.setDialogTitle( "Seleccionar datos" );
		int resultado = chooser.showOpenDialog(esto);

		Properties propiedades = new Properties( );


		if( resultado == JFileChooser.APPROVE_OPTION )
		{
			File seleccionado = chooser.getSelectedFile( );
			try {
				propiedades.load( new FileInputStream( seleccionado ) );
			}
			catch(Exception e) {
				
				e.printStackTrace();
			}
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
