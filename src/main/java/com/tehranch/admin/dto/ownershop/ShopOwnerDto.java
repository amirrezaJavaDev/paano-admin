package com.tehranch.admin.dto.ownershop;

import com.tehranch.admin.utils.FildPositionType;
import com.tehranch.admin.utils.PlanType;
import lombok.Data;
import lombok.ToString;
import org.mapstruct.EnumMapping;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@ToString
public class ShopOwnerDto {
//    shopOwner
    private Long id;
    private String mobile;

//    shopOwnerDetail
    private Long shopOwnerDetailId;
    private String ownerName;
    private String email;
    private String ssn;
    private String ownerBirthday;
//    shopDetail
    private Long shopDetailId;
    private String instagram;
    private String telegram;
    private String website;
    private String aboutShop;
    private String shopDetailEmail;
    private String fax;
    private String salesManagerName;
    private String salesManagerMobile;
    private String address;
    private Long codePost;
    private FildPositionType fildPositionType;
    private PlanType planType;
    private String metadescription;
    private String metakeywords;
    private String estatePersonal;
    private String orderRegister;
    private String shopNamePersian;
    private String shopNameEnglish;
    private String letterOfCommendations;
    private String shopMobile;
    private String imageTop;
    private String imageTop2;
    private String imageLogo;
    private String imageAbout;
    private String imageLetterOfCommandation;





}
