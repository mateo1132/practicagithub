package com.example.demo.service;
import com.example.demo.dto.Pedido;
import com.example.demo.dto.StatusPedido;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author Mateo
 */

/**
 * Servicio utilizado en la clase AppController que contine los metodos utilizados en el controlador
 */
@Service
public class PedidoService {
	
	@Autowired
	private UserService userService;
	
	private HashMap<Long,Pedido> pedidos = new HashMap<>();
	
	/**
	 * Metodo para crear un pedido
	 * @param id El id del pedido
	 * @param pedido El objeto pedido 
	 */
	public void crearPedido(Long id,Pedido pedido) {
		if (userService.existeUsuario(pedido.getidUsuario())) {
			pedidos.put(id, pedido);
		}
	}
	/**
	 * Metodo para buscar un pedido
	 * @param id El id del pedido 
	 * @return devuelve el pedido que coincide con el id
	 */
	
	public Pedido buscarPedido(Long id) {
		return pedidos.get(id);
	}
	/**
	 * Metodo que sirve para procesar un pedido
	 * @param id El id del pedido
	 */
	public void procesarPedido(Long id) {
		pedidos.get(id).setEstado(StatusPedido.PROCESADO);
	}
	/**
	 * Metodo para borrar un pedido
	 * @param id El id del pedido 
	 */
	public void borrarPedido(Long id) {
		if (pedidos.get(id).getEstado()!= StatusPedido.PROCESADO) {
			pedidos.get(id).setEstado(StatusPedido.BORRADO);
			pedidos.remove(id);
		}
	}
}
