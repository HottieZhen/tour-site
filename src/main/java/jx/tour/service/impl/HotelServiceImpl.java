package jx.tour.service.impl;

import jx.tour.mapper.HCommentMapper;
import jx.tour.mapper.HotelMapper;
import jx.tour.mapper.HotelRecommendMapper;
import jx.tour.mapper.HotelcommentMapper;
import jx.tour.pojo.HComment;
import jx.tour.pojo.Hotel;
import jx.tour.pojo.HotelWithBLOBs;
import jx.tour.pojo.Hotelcomment;
import jx.tour.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
@Autowired
private HotelMapper hotelMapper;
@Autowired
private HotelRecommendMapper hotelRecommendMapper;
@Autowired
private HCommentMapper hCommentMapper;
@Autowired
private HotelcommentMapper HotelcommentMapper;
	@Override
	public Hotel getHotel(int hid) {
		Hotel hotel = hotelMapper.selectByPrimaryKey(hid);
		return hotel;
	}
	@Override
	public List<Hotel> getOtherHotel(int hnum, int hid) {
		List<Hotel> OtherHotelList = hotelRecommendMapper.getOtherHotels(hnum, hid);
		return OtherHotelList;
	}
	@Override
	public List<HComment> getHotelComment(int hid) {
		List<HComment> hComments = hCommentMapper.getHotelCommment(hid);
		return hComments;
		 
	}
	@Override
	public List<Hotel> getSomeHotels() {
		List<Hotel> hotels = hotelRecommendMapper.getSomeHotels();
		return hotels;
	}
	@Override
	public List<HotelWithBLOBs> getAllHotels() {
		List<HotelWithBLOBs> AllHotels = hotelRecommendMapper.getALLHotels();
		return AllHotels;
	}
	@Override
	public void saveHotelComment(Hotelcomment hotelcomment) {
		hotelcomment.setStage(1);
		HotelcommentMapper.insert(hotelcomment);
	}


}
