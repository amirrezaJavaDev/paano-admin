package com.tehranch.admin.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopPageListDto {
    private String order;
    private Integer limit;
    private Integer page;
    private String panel;
    private String shopEng;
    private String shopPer;
    private String imgGovahi;
}
