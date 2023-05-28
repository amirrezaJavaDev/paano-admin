package com.tehranch.admin.utils;

public enum OrderRegister {
    SAHEB_PARVANEH(1,"صاحب پروانه") ,
    MOSTAGER(2,"مستاجر");

    private int code;
    private String perfix;

    OrderRegister(int code, String perfix) {
        this.code = code;
        this.perfix = perfix;
    }

    public int getCode() {
        return code;
    }

    public String getPerfix() {
        return perfix;
    }


}
