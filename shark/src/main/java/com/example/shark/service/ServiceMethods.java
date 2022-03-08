package com.example.shark.service;

import java.util.List;

public interface ServiceMethods<T> {
	T create(T shark);
	
	List<T> readAll();
	
	T readById(long id);
	
	T update(long id, T shark);
	
	boolean delete(long id);

}
