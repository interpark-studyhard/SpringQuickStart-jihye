package com.interpark.sts.polymorphism.impl;

import com.interpark.sts.polymorphism.ifs.Speaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by 최지혜 on 2017-07-28.
 */
@Component("sony")
public class SonySpeaker implements Speaker {
    public static final Logger LOGGER = LoggerFactory.getLogger(SonySpeaker.class);

    public SonySpeaker() {
        LOGGER.info(" Sony speaker 생성..");
    }

    @Override
    public void volumeUp() {
        LOGGER.info(" Sony Speaker 볼륨 업 .. ");
    }

    @Override
    public void volumeDown() {
        LOGGER.info(" Sony Speaker 볼륨 내림 .. ");
    }
}
