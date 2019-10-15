package com.telusko.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.telusko.dao.ItemDao;
import com.telusko.model.Item;

@Service
@Component
public class ItemServiceImpl implements ItemService {

	ItemDao ItemDao;
	@Autowired
	public void setUserdao(ItemDao userdao) {
		this.ItemDao = userdao;
	}
	@Override
	public List<Item> listAllItems() {
		return ItemDao.listAllItems();
	}

	@Override
	public void addItem(Item Item) {
		// TODO Auto-generated method stub
		ItemDao.addItem(Item);
		
	}

	@Override
	public void updateItem(Item Item) {
		// TODO Auto-generated method stub
		ItemDao.updateItem(Item);
	}

	@Override
	public void deleteItem(int iid) {
		// TODO Auto-generated method stub
		ItemDao.deleteItem(iid);
		
	}

	@Override
	public Item findItemById(int iid) {
		// TODO Auto-generated method stub
		return ItemDao.findItemById(iid);
	}
	
}
