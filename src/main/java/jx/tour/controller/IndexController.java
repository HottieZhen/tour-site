package jx.tour.controller;

import jx.tour.mapper.AdsMapper;
import jx.tour.pojo.Ads;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: HZW
 * @Date: 2021/6/2 12:07 AM
 */
@Controller
public class IndexController {

    AdsMapper adsMapper;

    @Autowired
    public void setAdsMapper(AdsMapper adsMapper) {
        this.adsMapper = adsMapper;
    }

    @RequestMapping("/")
    public void test(){
        Ads ads = adsMapper.selectByPrimaryKey(1);
        System.out.println(ads.getDescrible());

    }
}
