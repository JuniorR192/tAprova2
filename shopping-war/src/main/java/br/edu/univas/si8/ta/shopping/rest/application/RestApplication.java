package br.edu.univas.si8.ta.shopping.rest.application;

import javax.ws.rs.core.Application;

import br.edu.univas.si8.ta.shopping.core.OrderServiceImpl;

import javax.ws.rs.ApplicationPath;

import java.util.HashSet;
import java.util.Set;


@ApplicationPath("/rest")
public class RestApplication extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();
		classes.add(OrderServiceImpl.class);
		return classes;
	}
}
