package jx.tour.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jx.tour.pojo.Area;
import jx.tour.pojo.Hotel;
import jx.tour.pojo.Scenic;
import jx.tour.pojo.Specialty;
import jx.tour.service.AreaService;
import jx.tour.service.HotelService;
import jx.tour.service.ScenicService;
import jx.tour.service.SpecialtyService;
import jx.tour.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/area")
public class AreaController {

	@Autowired
	private ScenicService scenicService;
	@Autowired
	private AreaService areaService;
	@Autowired
	private PageUtils pageUtils;

	//获取每个城市的景点、美食等信息
	@RequestMapping("/requestContent")
	public String requestArea(Model model,@RequestParam(value = "id") int contentId) throws Exception {
		//所有风景
		List<Scenic> scenictList = areaService.getALLScenicList(contentId);
		//随机特产
		List<Specialty> someSpecialtyList = areaService.getSomeSpecialty(contentId);
		//随机美食
		List<Specialty> someFoodList = areaService.getSomeFood(contentId);
		//随机红色景点
		List<Scenic> someRedScenicList = areaService.getSomeRedScenic(contentId);
		//随机酒店
	    List<Hotel> someHotelList = areaService.getSomHotels(contentId);

		model.addAttribute("scenictList",scenictList);
		model.addAttribute("someSpecialtyList",someSpecialtyList);
		model.addAttribute("someFoodList",someFoodList);
		model.addAttribute("someRedScenicList",someRedScenicList);
		model.addAttribute("someHotelList",someHotelList);
		return "scenic_list";
	}

	@RequestMapping("/requestArea")
	public String requestAreaScenic(Model model,@RequestParam(value = "id") int areaId,@RequestParam(required = false,defaultValue = "1",value = "page")Integer page){
		//引入分页查询，使用PageHelper分页功能
		//在查询之前传入当前页，然后多少记录
		PageHelper.startPage(page,6);
		List<Scenic> list = scenicService.getAreaScenics(areaId);
		Area area = areaService.getAreaById(areaId);
		//使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
		PageInfo<Scenic> pageInfo = new PageInfo<>(list,3);
		pageUtils.setCurrentPageNum(page);
		model.addAttribute("pageInfo",pageInfo);
		model.addAttribute("pageUtils",pageUtils);
		List<Scenic> scenics = areaService.getSomeRedScenic(areaId);
		model.addAttribute("scenics", scenics);
		List<Specialty> specialties = areaService.getSomeSpecialty(areaId);
		model.addAttribute("specialties", specialties);
		List<Hotel> hotels = areaService.getSomHotels(areaId);
		model.addAttribute("hotels", hotels);
		model.addAttribute("areaId",areaId);
		model.addAttribute("areaName",area.getAreaname());

		return "scenic_list";
	}


}
	
