package Caso;

import java.util.ArrayList;

public class Buffer {
	
	/**
	 * Mensajes listos para consumir.
	 */
	private ArrayList<Mensaje> buff;
	
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
		buff = new ArrayList<>();
	}
	
	/**
	 * M�todo que permite a un cliente dejar un mensaje.
	 * @param m mensaje a dejar.
	 * @return true si se logr� dejar el mensaje, false si no.
	 */
	private synchronized boolean dejarMensaje(Mensaje m) {
		if(buff.size() >= n) {
			return false;
		} else {
			buff.add(m);
			return true;
		}
	}
	
}
