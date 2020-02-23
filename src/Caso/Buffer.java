package Caso;

import java.util.LinkedList;

public class Buffer {
	
	/**
	 * Mensajes listos para consumir.
	 */
	private LinkedList<Mensaje> buff;
	
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
			buff.push(m);
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
			return buff.pop();
		}
	}
	
}
