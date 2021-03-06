package com.telusko.dao;

import java.util.List;


import com.telusko.model.Item;

public interface ItemDao {

	public List<Item> listAllItems();
	
	public void addItem(Item Item);
	
	public void updateItem(Item Item); 
	
	public void deleteItem(int iid);
	
	public Item findItemById(int iid);
	
}
