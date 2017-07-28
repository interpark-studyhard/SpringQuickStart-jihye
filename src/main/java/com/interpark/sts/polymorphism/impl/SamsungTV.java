package com.interpark.sts.polymorphism.impl;

import com.interpark.sts.polymorphism.ifs.Speaker;
import com.interpark.sts.polymorphism.ifs.TV;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by 최지혜 on 2017-07-28.
 */
@Component("samsungTv")
public class SamsungTV implements TV {
    private static final Logger LOGGER = LoggerFactory.getLogger(SamsungTV.class);

//    @Autowired
//    @Qualifier("apple")
    @Resource(name="apple")
    private Speaker speaker;
    private int price;

    public void setSpeaker(Speaker speaker) {
        LOGGER.info(" == > Call setSpeaker ");
        this.speaker = speaker;
    }

    public void setPrice(int price) {
        LOGGER.info(" == > Call setPrice ");
        this.price = price;
    }

    public SamsungTV() {
        LOGGER.info(" Samsung Tv 객체 생성.. ");
    }

    @Override
    public void powerOn() {
        LOGGER.info(" Samsung TV 전원 켠다. ( 가격 : {} )", price);
    }

    @Override
    public void powerOff() {
        LOGGER.info(" Samsung TV 전원 끈다.");
    }

    @Override
    public void volumeUp() {
        speaker.volumeUp();
    }

    @Override
    public void volumeDown() {
        speaker.volumeDown();
    }
}
