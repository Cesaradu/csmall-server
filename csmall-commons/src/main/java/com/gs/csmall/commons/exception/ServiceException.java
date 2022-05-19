package com.gs.csmall.commons.exception;

import com.gs.csmall.commons.response.ServiceCode;

public class ServiceException extends RuntimeException {
    private ServiceCode serviceCode;

    public ServiceException(ServiceCode serviceCode, String message) {
        super(message);
        this.serviceCode = serviceCode;
    }

    public ServiceCode getServiceCode() {
        return serviceCode;
    }
}
