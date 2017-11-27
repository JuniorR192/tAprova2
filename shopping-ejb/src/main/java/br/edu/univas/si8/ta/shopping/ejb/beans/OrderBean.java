package br.edu.univas.si8.ta.shopping.ejb.beans;

import java.util.Date;
import java.util.stream.Collectors;

import javax.ejb.EJB;

import br.edu.univas.si8.ta.shopping.ejb.dao.OrderDAO;
import br.edu.univas.si8.ta.shopping.ejb.entities.Order;
import br.edu.univas.si8.ta.shopping.ejb.interfaces.OrderLocal;
import br.edu.univas.si8.ta.shopping.ejb.interfaces.OrderRemote;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(OrderRemote.class)
@Local(OrderLocal.class)
public class OrderBean implements OrderLocal, OrderRemote{


	@EJB
	private OrderDAO dao;

	@Override
	public void addOrder(String description) {
		Order order = new Order();
		order.setDescription(description);
		
		Date date = new Date();
		order.setOrderTime(date);
		dao.insert(order);
	}

	@Override
	public String[] listOrders() {
		return dao.listAll()
		.stream()
		.map(Order::getDescription)
		.collect(Collectors.toList())
		.toArray(new String[0]);
	}
	
	
}
