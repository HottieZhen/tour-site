package jx.tour.service.impl;

import jx.tour.mapper.SpcommentMapper;
import jx.tour.mapper.SpecialtyCommentMapper;
import jx.tour.mapper.SpecialtyMapper;
import jx.tour.pojo.*;
import jx.tour.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {
	@Autowired
	private SpecialtyMapper specialtyMapper;
	@Autowired
	private SpecialtyCommentMapper specialtyCommentMapper;
	@Autowired
	private SpcommentMapper spcommentMapper;

	@Override
	public Specialty getSpecialty(int specialty_id) {
		Specialty specialty = specialtyMapper.selectByPrimaryKey(specialty_id);
		return specialty;
	}

	@Override
	public List<ScenicComment> getSpecialtyComment(int specialty_id) {
		List<ScenicComment> specialtyComment = specialtyCommentMapper.getSpecialtyComment(specialty_id);
		return specialtyComment;
	}

	@Override
	public List<Specialty> getOtherSpecialty(int specialty_id) {
		SpecialtyExample specialtyExample = new SpecialtyExample();
		SpecialtyExample.Criteria criteria = specialtyExample.createCriteria();
		criteria.andIdNotEqualTo(specialty_id);
		List<Specialty> specialties = specialtyMapper.selectByExample(specialtyExample);
		return specialties;
	}

	@Override
	public List<Specialty> getSomeSpecialty() {
		List<Specialty> specialties = specialtyCommentMapper.getSpecialty();
		return specialties;
	}

	@Override
	public List<Specialty> getAllSpecialty() {
		SpecialtyExample specialtyExample =  new SpecialtyExample();
		SpecialtyExample.Criteria criteria = specialtyExample.createCriteria();
		criteria.andIdIsNotNull();
		criteria.andStageEqualTo(1);
		List<Specialty> specialties = specialtyMapper.selectByExample(specialtyExample);
		return specialties;
	}

	@Override
	public List<Specialty> getOtherSpecialty(int tnum,int id) {
		List<Specialty> otherSpecialties = specialtyCommentMapper.getOtherSpecialty(tnum,id);
		return otherSpecialties;
	}

	@Override
	public List<Specialty> getSpecialtyByName(Search search) {
		List<Specialty> specialties =  specialtyCommentMapper.getSpecialtyByName(search);
		return specialties;
	}

	//发表特产评论
	@Override
	public void publishSpecialtyComment(SpecialtycommentVo specialtycommentVo) {
		specialtycommentVo.setStage(1);
		spcommentMapper.insert(specialtycommentVo);      
		
		
	}
}
