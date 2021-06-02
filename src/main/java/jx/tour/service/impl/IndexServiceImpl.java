package jx.tour.service.impl;

import jx.tour.mapper.*;
import jx.tour.pojo.*;
import jx.tour.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {

	@Autowired
	private ContentMapper contentMapper;
	@Autowired
	private ContentVoMapper contentVoMapper;
	@Autowired
	private AdsMapper adsMapper;
	@Autowired
	private TravelsVoMapper travelsVoMapper;
	@Autowired
	private MadsMapper madsMapper;
	@Autowired
	private ScenicCommentMapper scenicCommentMapper;
	@Autowired
	private SpecialtyCommentMapper specialtyCommentMapper;

	@Override
	//显示前台的广告轮播图模块
	public List<Ads> getAdsList() {
		 
		List<Ads> adList = madsMapper.getAdsList();
		return adList; 
	}
	
	//显示前台的风景、特产模块
	@Override
    public List<Content> getContentScenic() {
		List<Content> list = contentVoMapper.getContentScenic();
		return list;
	}

	@Override
	public List<Scenic> getSomeScenic() {
		List<Scenic> scenic = scenicCommentMapper.getIndexScenic();
		return scenic;
	}

	@Override
	public List<Specialty> getSomeSpecialty() {
		return specialtyCommentMapper.getIndexSpecialty();
	}

	@Override
    public List<Content> getContentSpecialty() {
		List<Content> list = contentVoMapper.getContentSpecialty();
 
		return list;
	}

	//活动、热点资讯显示
	public List<Information>getInformationList(int value){
		List<Information> informationList= travelsVoMapper.findInformationList(value);
		return informationList;
	}

	@Override
	//游记显示
	public List<TravelsVo> getTravelVoList() {
	    List<TravelsVo> TravelList = travelsVoMapper.findGoodTravels();
		return TravelList;
	}
}
