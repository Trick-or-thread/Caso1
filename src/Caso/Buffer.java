package Caso;

import java.util.LinkedList;

public class Buffer {
	
	/**
	 * Mensajes listos para consumir.
	 */
	private LinkedList<Mensaje> buff;
	
	/**
	 * N�mero de clientes circulando actualmente.
	 */
	private int numeroClientes;
	
	/**
	 * Bolsa que evita que m�s de un thread modifique la variable "n�meroClientes".
	 */
	private Object bolsaModificarClientes;
	
	/**
	 * Cantidad m�xima de mensajes que pueden estar en la lista de espera.
	 */
	private int n;
	
	/**
	 * M�todo constructor del buffer.
	 * @param n tama�o del buffer.
	 */
	public Buffer(int n) {
		this.n = n;
		numeroClientes = 0;
		bolsaModificarClientes = new Object();
		buff = new LinkedList<>();
	}
	
	/**
	 * M�todo que permite a un cliente dejar un mensaje.
	 * @param m mensaje a dejar.
	 * @return true si se logr� dejar el mensaje, false si no.
	 */
	public synchronized boolean dejarMensaje(Mensaje m) {
		if(buff.size() >= n) {
			return false;
		} else {
			buff.add(m);
			return true;
		}
	}
	
	/**
	 * M�todo que permite a un servidor sacar un mensaje.
	 * @return un mensaje si existe alguno en la lista, null si no.
	 */
	public synchronized Mensaje sacarMensaje() {
		if(buff.size( ) == 0) {
			return null;
		} else {
			Mensaje m = buff.pop();
			return m;
		}
	}
	
	/**
	 * M�todo que le informa al buffer que un nuevo cliente entr� a hacer peticiones.
	 */
	public void entrarCliente() {
		synchronized(bolsaModificarClientes) {	
			System.out.println("BUFFER>> Ingreso un cliente");
			numeroClientes++;
		}
	}
	
	/**
	 * M�todo que le informa al buffer que un cliente dej� de hacer peticiones.
	 */
	public void salirCliente() {
		synchronized(bolsaModificarClientes) {
			numeroClientes--;
		}
	}
	
	/**
	 * M�todo que informa a un servidor que a�n existen clientes haciendo peticiones.
	 * @return true si a�n hay clientes haciendo peticiones, false si no.
	 */
	public boolean existenClientes() {
		synchronized(bolsaModificarClientes) {
			System.out.println(numeroClientes);
			return numeroClientes > 0 ? true : false;
		}
	}
	
}
