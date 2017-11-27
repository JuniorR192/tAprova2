package br.edu.univas.si8.ta.shopping.ejb.beans;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.edu.univas.si8.ta.shopping.ejb.dao.OrderDAO;
import br.edu.univas.si8.ta.shopping.ejb.entities.Order;
import br.edu.univas.si8.ta.shopping.ejb.interfaces.OrdersLocal;
import br.edu.univas.si8.ta.shopping.ejb.interfaces.OrdersRemote;

@Stateless
@Local(OrdersLocal.class)
@Remote(OrdersRemote.class)
public class OrdersBean implements OrdersLocal, OrdersRemote {
	
	@EJB
	private OrderDAO dao;

	@Override
	public void createNewOrder(String description) {
		Date dateNow = new Date();
		Order order = new Order();
		order.setDescription(description);
		order.setOrder_time(new Timestamp(dateNow.getTime()));
		dao.insert(order);
	}

	@Override
	public String[] listOrdersDescription() {
		List<Order> orders = dao.listAll();
		return orders
				.stream()
				.map(o -> o.getDescription())
				.collect(Collectors.toList())
				.toArray(new String[0]);
	}

}
