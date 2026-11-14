package model;

import java.time.LocalDateTime;

public class Pedido{
	
	private Integer id;
	private LocalDateTime data;
	private Cliente cliente;
	
	public Pedido() {
		
	}
	
	public Pedido(Integer id, LocalDateTime data, Cliente cliente) {
		this.id = id;
		this.data = data;
		this.cliente = cliente;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public LocalDateTime getData() {
		return data;
	}
	
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Override
	public String toString() {
		return "Pedido [id=" + id +", data=" + data + ", cliente=" + cliente +"]";
	}
	
}