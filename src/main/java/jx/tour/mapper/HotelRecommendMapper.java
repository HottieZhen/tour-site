package jx.tour.mapper;

import jx.tour.pojo.Hotel;
import jx.tour.pojo.HotelWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HotelRecommendMapper {
	//得到某地的其它酒店
    public List<Hotel> getOtherHotels(@Param("hnum") int hnum, @Param("hid") int hid);
    //随机抽取3个酒店信息
    public List<Hotel> getSomeHotels();
    //得到11个酒店(当点击更多时随机显示11个酒店信息)
    public List<HotelWithBLOBs> getALLHotels();
}