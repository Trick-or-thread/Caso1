package Caso;

import java.util.LinkedList;

public class Buffer {
	
	/**
	 * Mensajes listos para consumir.
	 */
	private LinkedList<Mensaje> buff;
	
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
			buff.push(m);
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
			return buff.pop();
		}
	}
	
}
