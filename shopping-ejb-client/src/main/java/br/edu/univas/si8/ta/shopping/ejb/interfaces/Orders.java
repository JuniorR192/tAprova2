package br.edu.univas.si8.ta.shopping.ejb.interfaces;

public interface Orders {
	
	void createNewOrder(String description);
	
	String[] listOrdersDescription();

}
