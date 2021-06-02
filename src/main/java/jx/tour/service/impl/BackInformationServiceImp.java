package jx.tour.service.impl;

import jx.tour.mapper.InformationMapper;
import jx.tour.mapper.MinformationMapper;
import jx.tour.pojo.Information;
import jx.tour.service.BackInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BackInformationServiceImp implements BackInformationService {
	@Autowired
	private MinformationMapper minformationMapper;
	@Autowired
	private InformationMapper informationMapper;
	
	@Override
	public List<Information> getAllInformations() {
		List<Information> list = minformationMapper.getAllInformations();
		return list;
	}

	@Override
	public void downInformation(int id) {
		minformationMapper.downInformation(id);
	}

	@Override
	public void upInformation(int id) {
		minformationMapper.upInformation(id);
		
	}

	@Override
	public void addInformation(Information information) {
		informationMapper.insert(information);
		
	}

	@Override
	public void editInformation(Information information) {
		informationMapper.updateByPrimaryKey(information);
		
	}

}
