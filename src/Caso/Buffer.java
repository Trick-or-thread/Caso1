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
			System.out.println("BUFFER >> EL BUFFER ESTA LLENO INTENTO FALLIDO DE DEJAR EL MENSAJE "+m.getMensaje()+"  |  "+m);			
			return false;
		} else {
			System.out.println("BUFFER >> SE AGREGO EXITOSAMENTE AL BUFFER EL MENSAJE "+m.getMensaje()+"  |  "+m);
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
			System.out.println("BUFFER >> EL BUFFER ESTA VACIO INTENTO FALLIDO DE SACAR MENSAJE POR PARTE DEL SERVIDOR");			
			return null;
		} else {
			Mensaje m = buff.pop();
			System.out.println("BUFFER >> EL SERVIDOR EXTRAJO EXITOSAMENTE DEL BUFFER EL MENSAJE "+m.getMensaje()+"  |  "+m);
			return m;
		}
	}
	
	/**
	 * Método que le informa al buffer que un nuevo cliente entró a hacer peticiones.
	 */
	public void entrarCliente() {
		synchronized(bolsaModificarClientes) {	
			System.out.println("BUFFER >> INGRESO DE UN CLIENTE, CANTIDAD DE CLIENTES: "+(numeroClientes+1));
			numeroClientes++;
		}
	}
	
	/**
	 * Método que le informa al buffer que un cliente dejó de hacer peticiones.
	 */
	public void salirCliente() {
		synchronized(bolsaModificarClientes) {
			System.out.println("BUFFER >> SALIDA DE UN CLIENTE, CANTIDAD DE CLIENTES: "+(numeroClientes-1));
			numeroClientes--;
		}
	}
	
	/**
	 * Método que informa a un servidor que aún existen clientes haciendo peticiones.
	 * @return true si aún hay clientes haciendo peticiones, false si no.
	 */
	public boolean existenClientes() {
		synchronized(bolsaModificarClientes) {
			return numeroClientes > 0 ? true : false;
		}
	}
	
}
