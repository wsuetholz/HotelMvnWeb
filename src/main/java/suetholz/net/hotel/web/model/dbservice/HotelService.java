/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suetholz.net.hotel.web.model.dbservice;

import java.util.List;
import suetholz.net.hotel.web.model.dao.HotelDAO;
import suetholz.net.hotel.web.model.dao.MySqlHotelDAO;
import suetholz.net.hotel.web.model.entities.Hotel;

/**
 *
 * @author wsuetholz
 */
public class HotelService {
    HotelDAO hotelDao;
    
    public HotelService (HotelDAO hotelDao) {
	this.hotelDao = hotelDao;
    }
    
    public List<Hotel> getAllHotels() throws Exception {
	return hotelDao.getAllHotels();
    }
    
    public Hotel getHotelByName(String hotelName) throws Exception {
	return hotelDao.getHotelByName(hotelName);
    }
    
    public Hotel getHotelById(long hotelId) throws Exception {
	return hotelDao.getHotelById(hotelId);
    }
    
    public Hotel getHotelById(String hotelId) throws Exception {
	return hotelDao.getHotelById(Long.parseLong(hotelId));
    }
    
    public long insertHotel (Hotel hotel) throws Exception {
	return hotelDao.insertHotel(hotel);
    }
    
    public long updateHotel (Hotel hotel) throws Exception {
	return hotelDao.updateHotel(hotel);
    }
    
    public long deleteHotel (Hotel hotel) throws Exception {
	return hotelDao.deleteHotel(hotel);
    }
    
    public long deleteHotelsByIds ( String[] hotel_ids ) throws Exception {
	long ret = 0;
	
	for ( String hotel_id : hotel_ids ) {
	    Hotel hotel = getHotelById(hotel_id); 
	    if (hotel != null) {
		ret += deleteHotel(hotel);
	    }
	}
	return ret;
    }
    
    public static void main(String[] args) throws Exception {
	HotelDAO hotelDao = new MySqlHotelDAO();
	HotelService hotelService = new HotelService(hotelDao);
	long retVal = 0;
	
	List<Hotel> hotels = hotelService.getAllHotels();
	for ( Hotel h : hotels ) {
	    System.out.println(h.toString());	    
	}
	
	Hotel hotel = new Hotel();
	hotel.setHotelName("Hotel Number 5");
	hotel.setStreetAddress("5 Hotel Street");
	hotel.setCity("City of Hotels");
	hotel.setState("Florida");
	hotel.setPostalCode("55555-5555");
	hotel.setNotes("Some Notes about Hotel 5");
	
	retVal = hotelService.insertHotel(hotel);
	System.out.println("Insert Result = " + retVal);
	
	hotels = hotelService.getAllHotels();
	for ( Hotel h : hotels ) {
	    System.out.println(h.toString());	    
	}
	
	hotel = hotelService.getHotelByName("Hotel Number 2");
	hotel.setNotes("Some Service Orientated Notes for Hotel 2");
	retVal = hotelService.updateHotel(hotel);
	System.out.println("Update Result = " + retVal);

	hotels = hotelService.getAllHotels();
	for ( Hotel h : hotels ) {
	    System.out.println(h.toString());	    
	}
	
	hotel = hotelService.getHotelByName("Hotel Number 5");
	retVal = hotelService.deleteHotel(hotel);
	System.out.println("Update Result = " + retVal);

	hotels = hotelService.getAllHotels();
	for ( Hotel h : hotels ) {
	    System.out.println(h.toString());	    
	}
	
	
    }
}
