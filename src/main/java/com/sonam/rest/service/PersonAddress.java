package com.sonam.rest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonAddress implements AddressService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String getAddress(long personId) {
	logger.debug("return a person address for personId {}", personId);
	return "Person address is 12x Avenue, South Temple, Salt Lake City, Utah - 84641";
    }

}
