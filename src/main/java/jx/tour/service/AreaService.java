package jx.tour.service;

import jx.tour.pojo.Area;
import jx.tour.pojo.Hotel;
import jx.tour.pojo.Scenic;
import jx.tour.pojo.Specialty;

import java.util.List;

public interface AreaService {
 //显示浙江某个城市的风景
  public List<Scenic> getALLScenicList(int id);
  //显示浙江某个城市的特产
  public List<Specialty> getALLSpecialty(int id);
  //显示浙江某个城市的美食
  public List<Specialty> getALLGoodFood(int id);
  //随机显示浙江某个城市的6种特产
  public List<Specialty> getSomeSpecialty(int id);
  //随机显示浙江某个城市的6种美食
  public List<Specialty> getSomeFood(int id);
  //随机显示浙江某个城市的6个红色景点
  public List<Scenic> getSomeRedScenic(int id);
  //随机显示浙江某个城市的6个红色景点
  public List<Hotel> getSomHotels(int id);
  //获得Area信息
  public Area getAreaById(int aid);
}
