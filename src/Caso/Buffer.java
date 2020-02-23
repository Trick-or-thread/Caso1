package Caso;

import java.util.LinkedList;

public class Buffer {
	
	/**
	 * Mensajes listos para consumir.
	 */
	private LinkedList<Mensaje> buff;
	
	/**
	 * Número de clientes circulando actualmente.
	 */
	private int numeroClientes;
	
	/**
	 * Bolsa que evita que más de un thread modifique la variable "númeroClientes".
	 */
	private Object bolsaModificarClientes;
	
	/**
	 * Cantidad máxima de mensajes que pueden estar en la lista de espera.
	 */
	private int n;
	
	/**
	 * Método constructor del buffer.
	 * @param n tamaño del buffer.
	 */
	public Buffer(int n) {
		this.n = n;
		numeroClientes = 0;
		bolsaModificarClientes = new Object();
		buff = new LinkedList<>();
	}
	
	/**
	 * Método que permite a un cliente dejar un mensaje.
	 * @param m mensaje a dejar.
	 * @return true si se logró dejar el mensaje, false si no.
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
	 * Método que permite a un servidor sacar un mensaje.
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
	 * Método que le informa al buffer que un nuevo cliente entró a hacer peticiones.
	 */
	public void entrarCliente() {
		synchronized(bolsaModificarClientes) {	
			System.out.println("BUFFER>> Ingreso un cliente");
			numeroClientes++;
		}
	}
	
	/**
	 * Método que le informa al buffer que un cliente dejó de hacer peticiones.
	 */
	public void salirCliente() {
		synchronized(bolsaModificarClientes) {
			numeroClientes--;
		}
	}
	
	/**
	 * Método que informa a un servidor que aún existen clientes haciendo peticiones.
	 * @return true si aún hay clientes haciendo peticiones, false si no.
	 */
	public boolean existenClientes() {
		synchronized(bolsaModificarClientes) {
			System.out.println(numeroClientes);
			return numeroClientes > 0 ? true : false;
		}
	}
	
}
