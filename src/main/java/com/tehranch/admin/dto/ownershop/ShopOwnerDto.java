package com.tehranch.admin.dto.ownershop;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tehranch.admin.utils.FieldType;
import com.tehranch.admin.utils.OrderRegister;
import com.tehranch.admin.utils.PanelType;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@ToString
public class ShopOwnerDto {
//    shopOwner
    private Long shopOwnerId;
    private String mobile;
    private String ownerName;
    private String email;
    private String ssn;
    private String ownerBirthday;
//    shopDetail
    private Long shopDetailId;
    private String shopNamePersian;
    private String shopNameEnglish;
    private String instagram;
    private String telegram;
    private String website;
    private String about;
    private String tagdir;
    private String fax;
    private String phone;
    private String address;
    private String salesManagerName;
    private String salesManagerMobile;
    private String postCode;
    private String metaDescription;
    private String metaKeywords;
    private String vageDar;
    private Boolean hasMalekiat;
    private Boolean hasMostager;
    private OrderRegister orderRegister;
    private FieldType fieldType;
    private PanelType panelType;
    private Date mohlateEjare;
    private String mastajerName;
    private Date mostagerBirthDay;
    private String mastajerSsn;
    private String mastajerMobile;
    private String shomarehJavaz;
    private Date tarikhEtebar;
    private Boolean hasMobasher;
    private String mobasherName;
    private String rabetName;
    private String semateRabet;
    private String rabetMobile;
    private String socialMobile;
    private String imageTop;
    private String imageTop2;
    private String imageLogo;
    private String imageAbout;
    private Double lat;
    private Double lng;

}
