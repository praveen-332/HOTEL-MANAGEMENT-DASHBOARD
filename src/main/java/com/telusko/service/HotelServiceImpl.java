package com.telusko.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.telusko.dao.HotelDao;
import com.telusko.model.Hotel;

@Service
@Component
public class HotelServiceImpl implements HotelService {

	HotelDao HotelDao;
	@Autowired
	public void setUserdao(HotelDao userdao) {
		this.HotelDao = userdao;
	}
	@Override
	public List<Hotel> listAllHotels() {
		return HotelDao.listAllHotels();
	}

	@Override
	public void addHotel(Hotel Hotel) {
		// TODO Auto-generated method stub
		HotelDao.addHotel(Hotel);
		
	}

	@Override
	public void updateHotel(Hotel Hotel) {
		// TODO Auto-generated method stub
		HotelDao.updateHotel(Hotel);
	}

	@Override
	public void deleteHotel(int hid) {
		// TODO Auto-generated method stub
		HotelDao.deleteHotel(hid);
		
	}

	@Override
	public Hotel findHotelById(int hid) {
		// TODO Auto-generated method stub
		return HotelDao.findHotelById(hid);
	}
	
}
