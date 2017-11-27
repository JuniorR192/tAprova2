package br.edu.univas.si8.ta.shopping.core;

import javax.enterprise.context.RequestScoped;
import javax.ejb.EJB;

import br.edu.univas.si8.ta.shopping.api.OrderService;
import br.edu.univas.si8.ta.shopping.ejb.interfaces.Order;

@RequestScoped
public class OrderServiceImpl implements OrderService {
	
	@EJB(mappedName = "java:app/shopping-ejb-0.1-SNAPSHOT/OrderBean!br.edu.univas.si8.ta.shopping.ejb.interfaces.OrderRemote")
	private Order order;
	
	@Override
	public String[] listOrders() {
		return order.listOrders();
	}

	@Override
	public String addOrder(String description) {
		order.addOrder(description);
		return "{\"message\": \"Success\"}";
	}

}
