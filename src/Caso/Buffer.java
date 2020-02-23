package Caso;

import java.util.ArrayList;

public class Buffer {
	
	/**
	 * Mensajes listos para consumir.
	 */
	private ArrayList<Mensaje> buff;
	
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
		buff = new ArrayList<>();
	}
	
	/**
	 * Método que permite a un cliente dejar un mensaje.
	 * @param m mensaje a dejar.
	 * @return true si se logró dejar el mensaje, false si no.
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
