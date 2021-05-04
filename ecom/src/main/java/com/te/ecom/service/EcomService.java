package com.te.ecom.service;

import java.util.List;

import com.te.ecom.beans.Admin;
import com.te.ecom.beans.Item;

public interface EcomService {

	public Admin authenticate(Integer id, String password);
	
	public boolean addItem(Item item);
	
	public boolean removeItem(Integer id);
	
	public Item searchItem(Integer id);
	
	public List<Item> getAllItems();
	
	public boolean updateItem(Item item);
}
