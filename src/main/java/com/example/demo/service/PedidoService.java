package com.example.demo.service;
import com.example.demo.dto.Pedido;
import com.example.demo.dto.StatusPedido;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
	
	@Autowired
	private UserService userService;
	
	private HashMap<Long,Pedido> pedidos = new HashMap<>();
	
	
	public void crearPedido(Long id,Pedido pedido) {
		if (userService.existeUsuario(pedido.getidUsuario())) {
			pedidos.put(id, pedido);
		}
	}
	
	public Pedido buscarPedido(Long id) {
		return pedidos.get(id);
	}
	
	public void procesarPedido(Long id) {
		pedidos.get(id).setEstado(StatusPedido.PROCESADO);
	}
	
	public void borrarPedido(Long id) {
		if (pedidos.get(id).getEstado()!= StatusPedido.PROCESADO) {
			pedidos.get(id).setEstado(StatusPedido.BORRADO);
			pedidos.remove(id);
		}
	}
}
