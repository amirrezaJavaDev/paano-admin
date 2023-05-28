package com.tehranch.admin.utils;

public enum FieldType {
    LUSTERBLURY(1,"لوستر بلوری"),
    LUSTERWOOD(2,"لوستر چوبی"),
    LUSTERSANTI(3,"لوستر سانتی"),
    LUSTERBOBLE(4,"لوستر حبابی");
    private int code;
    private String perfix;
    FieldType(int code, String perfix) {
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
