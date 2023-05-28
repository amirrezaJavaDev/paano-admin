package com.tehranch.admin.utils;

public enum PanelType {
    Firoze(1,"فیروزه ای"),
    Gold(2,"طلایی"),
    Silver(3,"نقره ای"),
    Bronze(4,"برنزی"),
    Adi(5,"عادی");

    private int code;
    private String perfix;

    PanelType(int code, String perfix) {
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
