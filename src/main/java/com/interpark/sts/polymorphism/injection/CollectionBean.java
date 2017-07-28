package com.interpark.sts.polymorphism.injection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;

/**
 * Created by 최지혜 on 2017-07-28.
 */
public class CollectionBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(CollectionBean.class);

    private List<String> addressList;

    private Set<String> addressSet;

    public Set<String> getAddressSet() {
        return addressSet;
    }

    public void setAddressSet(Set<String> addressSet) {
        this.addressSet = addressSet;
    }

    public List<String> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<String> addressList) {
        this.addressList = addressList;
    }
}
