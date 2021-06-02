package jx.tour.service.impl;

import jx.tour.mapper.DataViewMapper;
import jx.tour.pojo.OrderNumber;
import jx.tour.service.DataViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataViewServiceImp implements DataViewService {
@Autowired
private DataViewMapper dataViewMapper;
	@Override
	public List<OrderNumber> getoOrderNumber() {
		 List<OrderNumber> list = dataViewMapper.getOrderNumber();
		return list;
	}

}
