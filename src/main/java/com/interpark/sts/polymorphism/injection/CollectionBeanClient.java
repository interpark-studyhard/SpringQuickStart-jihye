package com.interpark.sts.polymorphism.injection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;
import java.util.Set;

/**
 * Created by 최지혜 on 2017-07-28.
 */
public class CollectionBeanClient {
    public static final Logger LOGGER = LoggerFactory.getLogger(CollectionBeanClient.class);
    public static void main(String[] args) {
        AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
        CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
        List<String> addrList = bean.getAddressList();
        for(String address : addrList) {
            LOGGER.info("주소 from List :: {}", address.toString());
        }
        Set<String> addrSet = bean.getAddressSet();
        for(String addr : addrSet) {
            LOGGER.info("주소 from SET : {}", addr.toString());
        }
        factory.close();
    }
}
