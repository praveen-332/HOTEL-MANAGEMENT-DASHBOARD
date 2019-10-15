package com.telusko.service;

import java.util.List;



import com.telusko.model.Hotel;

public interface HotelService {
public List<Hotel> listAllHotels();
	
	public void addHotel(Hotel Hotel);
	
	public void updateHotel(Hotel Hotel); 
	
	public void deleteHotel(int hid);
	
	public Hotel findHotelById(int hid);


}
