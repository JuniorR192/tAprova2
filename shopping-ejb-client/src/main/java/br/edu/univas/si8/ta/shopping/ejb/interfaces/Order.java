package br.edu.univas.si8.ta.shopping.ejb.interfaces;

public interface Order {
	
	void addOrder(String description);

	String[] listOrders();
}
