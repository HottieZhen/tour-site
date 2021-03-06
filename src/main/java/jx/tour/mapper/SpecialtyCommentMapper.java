package jx.tour.mapper;

import jx.tour.pojo.ScenicComment;
import jx.tour.pojo.Search;
import jx.tour.pojo.Specialty;
import jx.tour.pojo.SpecialtycommentVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SpecialtyCommentMapper {
	 //显示对某一特产的所有评论信息
	public List<ScenicComment> getSpecialtyComment(int specialty_id);
	//根据输入框输入的特产名称模糊查询相关特产
	public List<Specialty> getSpecialtyByName(Search search);
	
	
	//随机显示3个特产信息
	public List<Specialty> getSpecialty();

	//首页特产信息
	public List<Specialty> getIndexSpecialty();

	//随机显示除此特产以外的当地其他6个特产
	public List<Specialty> getOtherSpecialty(@Param("tnum") int tnum, @Param("id") int id);
	
	
	/*后台*/
	//得到所有的特产评论
	public List<SpecialtycommentVo> getAllSpecialtyComment();
	//通过特产评论
	public void passSpecialtyComment(int id);
	//不通过特产评论
	public void rejectSpecialtyComment(int id);
    
}