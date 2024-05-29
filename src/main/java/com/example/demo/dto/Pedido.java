package com.example.demo.dto;

import java.time.LocalDate;

public class Pedido {
	private double precio;
	private StatusPedido estado;
	private LocalDate fecha;
	private Long idUsuario;
	
	public Pedido(double precio, StatusPedido estado, LocalDate fecha, Long idUsuario) {
		super();
		this.precio = precio;
		this.estado = estado;
		this.fecha = fecha;
		this.idUsuario = idUsuario;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public StatusPedido getEstado() {
		return estado;
	}

	public void setEstado(StatusPedido estado) {
		this.estado = estado;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Long getidUsuario() {
		return idUsuario;
	}



	@Override
	public String toString() {
		return "Pedido [precio=" + precio + ", estado=" + estado + ", fecha=" + fecha + ", idUsuario=" +idUsuario + "]";
	}
	
	
}
