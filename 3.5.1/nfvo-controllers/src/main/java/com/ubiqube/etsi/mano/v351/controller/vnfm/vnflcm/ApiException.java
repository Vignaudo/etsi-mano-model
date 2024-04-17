package com.ubiqube.etsi.mano.nfvo.v451.controller.vnflcm;

public class ApiException extends Exception {
    private int code;
    public ApiException (int code, String msg) {
        super(msg);
        this.code = code;
    }
}
