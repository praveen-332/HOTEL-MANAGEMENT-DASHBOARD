package com.telusko.dao;

import java.util.List;



import com.telusko.model.Hotel;

public interface HotelDao {

	public List<Hotel> listAllHotels();
	
	public void addHotel(Hotel hotel);
	
	public void updateHotel(Hotel hotel); 
	
	public void deleteHotel(int hid);
	
	public Hotel findHotelById(int hid);
}
