package jx.tour.mapper;

import jx.tour.pojo.Travels;
import jx.tour.pojo.TravelsExample;
import jx.tour.pojo.TravelsWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TravelsMapper {
//    void updateRead(int id);

    int countByExample(TravelsExample example);

    int deleteByExample(TravelsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TravelsWithBLOBs record);

    int insertSelective(TravelsWithBLOBs record);

    List<TravelsWithBLOBs> selectByExampleWithBLOBs(TravelsExample example);

    List<Travels> selectByExample(TravelsExample example);

    TravelsWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TravelsWithBLOBs record, @Param("example") TravelsExample example);

    int updateByExampleWithBLOBs(@Param("record") TravelsWithBLOBs record, @Param("example") TravelsExample example);

    int updateByExample(@Param("record") Travels record, @Param("example") TravelsExample example);

    int updateByPrimaryKeySelective(TravelsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TravelsWithBLOBs record);

    int updateByPrimaryKey(Travels record);
}