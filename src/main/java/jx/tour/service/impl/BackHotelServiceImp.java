package jx.tour.service.impl;

import jx.tour.mapper.HotelMapper;
import jx.tour.mapper.HotelVoMapper;
import jx.tour.pojo.HotelVo;
import jx.tour.pojo.HotelWithBLOBs;
import jx.tour.service.BackHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BackHotelServiceImp implements BackHotelService {
@Autowired
private HotelVoMapper hotelVoMapper;
@Autowired
private HotelMapper hotelMapper;


	@Override
	public void downHotel(int hid) {
		hotelVoMapper.downHotel(hid);
	}

	@Override
	public void upHotel(int hid) {
		hotelVoMapper.upHotel(hid);
		
	}

	@Override
	public List<HotelVo> getAllHotel() {
		List<HotelVo> list = hotelVoMapper.getAllHotel();
		return list;
	}

	@Override
	public void editHotel(HotelWithBLOBs hotel) {
		hotelMapper.updateByPrimaryKeyWithBLOBs(hotel);
		
	}

	@Override
	public void addHotel(HotelWithBLOBs hotel) {
		hotelMapper.insert(hotel);
	}

}
