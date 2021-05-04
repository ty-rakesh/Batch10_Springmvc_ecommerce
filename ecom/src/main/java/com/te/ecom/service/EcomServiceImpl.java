package com.te.ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.ecom.beans.Admin;
import com.te.ecom.beans.Item;
import com.te.ecom.dao.EcomDaoImpl;

@Service
public class EcomServiceImpl implements EcomService{

	@Autowired
	EcomDaoImpl ecomDao;
	
	@Override
	public Admin authenticate(Integer id, String password) {
		
		Admin admin = ecomDao.authenticate(id, password);
		return admin;
	}

	@Override
	public boolean addItem(Item item) {
		boolean result = ecomDao.addItem(item) ;
		return result;
	}

	@Override
	public boolean removeItem(Integer id) {
		boolean result = ecomDao.removeItem(id);
		return result;
	}

	@Override
	public Item searchItem(Integer id) {
		Item item = ecomDao.searchItem(id);
		return item;
	}

	@Override
	public List<Item> getAllItems() {
		List<Item> list = ecomDao.getAllItems();
		return list;
	}

	@Override
	public boolean updateItem(Item item) {
		boolean result = ecomDao.updateItem(item);
		return result;
	}

}
