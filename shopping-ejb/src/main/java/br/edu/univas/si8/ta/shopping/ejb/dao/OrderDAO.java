package br.edu.univas.si8.ta.shopping.ejb.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.edu.univas.si8.ta.shopping.ejb.entities.Order;

@Stateless
public class OrderDAO {
	
	@PersistenceContext(unitName = "shopping_order")
	private EntityManager em;

	public void insert(Order client) {
		em.persist(client);
	}

	public List<Order> listAll() {
		return em.createQuery("from shopping_order p", Order.class).getResultList();
	}
}
