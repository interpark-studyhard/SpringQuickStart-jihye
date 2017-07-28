package com.interpark.sts.polymorphism.impl;

import com.interpark.sts.polymorphism.ifs.Speaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by 최지혜 on 2017-07-28.
 */
@Component("apple")
public class AppleSpeaker implements Speaker {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppleSpeaker.class);
    public AppleSpeaker() {
        LOGGER.info(" AppleSpeaker 생성됨 .. ");
    }

    @Override
    public void volumeUp() {
        LOGGER.info(" == APPLE Speaker 볼륨 업 .. ");
    }

    @Override
    public void volumeDown() {
        LOGGER.info(" == APPLE Speaker 볼륨 다운 .. ");
    }
}
