package jx.tour.service;

import jx.tour.pojo.*;

import java.util.List;

public interface IndexService {
 //首页轮播图的信息显示
  public List<Ads> getAdsList();
 //首页风景图的信息显示
  public List<Content> getContentScenic();

  //
  public List<Scenic> getSomeScenic();

  public List<Specialty> getSomeSpecialty();
//首页特产的信息显示
  public List<Content> getContentSpecialty();
 //首页活动、热点资讯信息显示
  public List<Information>getInformationList(int value);
//首页游记信息显示
  public List<TravelsVo>getTravelVoList();
 
}
