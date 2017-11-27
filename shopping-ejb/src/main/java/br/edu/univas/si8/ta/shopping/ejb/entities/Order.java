package br.edu.univas.si8.ta.shopping.ejb.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "shopping_order")
@SequenceGenerator(name = "seq_shopping_order", sequenceName = "seq_shopping_order", allocationSize = 1)
public class Order {

	@Id
	@GeneratedValue(generator="seq_shopping_order", strategy=GenerationType.SEQUENCE)
	private int Id;
	private String description;
	private Timestamp order_time;
	
	public Integer getId() {
		return Id;
	}
	
	public void setId(int id) {
		Id = id;
	}
	
	public Order withId(int id) {
		this.Id = id;
		return this;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Order whithDescription(String description) {
		this.description = description;
		return this;
	}
	
	public Timestamp getOrder_time() {
		return order_time;
	}
	
	public void setOrder_time(Timestamp order_time) {
		this.order_time = order_time;
	}
	
	public Order withOrder_time(Timestamp order_time) {
		this.order_time = order_time;
		return this;
	}
	
}
