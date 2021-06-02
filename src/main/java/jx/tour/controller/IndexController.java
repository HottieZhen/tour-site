package jx.tour.controller;

import jx.tour.pojo.*;
import jx.tour.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class IndexController {

	@Autowired
	private IndexService indexService;


	// 打开前台首页
	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}

	// 首页的广告轮播图
	@RequestMapping("/requestAds")
	public @ResponseBody List<Ads> requestAds(Model model) throws Exception {
		List<Ads> adList = indexService.getAdsList();
		return adList;
	}

	// 首页的美景、特产显示
	@RequestMapping("/requestScenic")
	public @ResponseBody List<Scenic> requestScenic() throws Exception {
//		List<Content> contentList = indexService.getContentScenic();
		List<Scenic> someScenic = indexService.getSomeScenic();
		return someScenic;
	}

	// 首页的美景、特产显示
	@RequestMapping("/requestSpecialty")
	public @ResponseBody List<Specialty> requestSpecialty() throws Exception {
//		List<Content> contentList = indexService.getContentSpecialty();
		List<Specialty> someSpecialty = indexService.getSomeSpecialty();
		return someSpecialty;
	}

	// 首页资讯信息显示
	@RequestMapping("/requestInformation")
	public @ResponseBody List<Information> requestInformation(int value) throws Exception {
		List<Information> informationList = indexService.getInformationList(value);
		return informationList;
	}

	// 首页显示四个热门的游记
	@RequestMapping("/requestTravels")
	public @ResponseBody List<TravelsVo> requestTravels() throws Exception {
		List<TravelsVo> TravelList = indexService.getTravelVoList();
		for (TravelsVo t : TravelList) {
			System.out.println(t.getUserimag());
		}
		return TravelList;
	}
}
