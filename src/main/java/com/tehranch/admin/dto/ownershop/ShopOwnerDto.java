package com.tehranch.admin.dto.ownershop;

import com.tehranch.admin.utils.FieldType;
import com.tehranch.admin.utils.OrderRegister;
import com.tehranch.admin.utils.PanelType;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@ToString
public class ShopOwnerDto {
//    shopOwner

    private Long shopOwnerId;

    @Pattern(regexp="(^$|[0-9]{11})")
    private String mobile;

    @Size(max = 100)
    @NotNull
    private String ownerName;

    @Email(message = "this email is not valid")
    private String email;

    @Size(max = 11,message = "ssn max is 11")
    private String ssn;

    private Date ownerBirthday;
//    shopDetail
    private Long shopDetailId;

    @NotNull
    @Size(max = 100,message = "shop name persian max is 100")
    private String shopNamePersian;

    @NotNull
    @Size(max = 100)
    private String shopNameEnglish;

    @Size(max = 100)
    private String instagram;

    @Size(max = 100)
    private String telegram;

    @Size(max = 100)
    private String website;

    @Size(max = 100)
    private String about;

    @Size(max = 100)
    private String tagdir;

    @Size(max = 100)
    private String fax;

    @Size(max = 200)
    private String phone;

    @Size(max = 200)
    private String address;

    @Size(max = 100)
    private String salesManagerName;

    @Size(max = 11)
    private String salesManagerMobile;

    @Size(max = 10)
    private String postCode;

    @Size(max = 200)
    private String metaDescription;

    @Size(max = 200)
    private String metaKeywords;

    @Size(max = 100)
    private String vageDar;

    private Boolean hasMalekiat;

    private Boolean hasMostager;

    private OrderRegister orderRegister;

    private String fieldType;

    private PanelType panelType;

    private Date mohlateEjare;

    @Size(max = 100)
    private String mastajerName;

    private Date mostagerBirthDay;

    @Size(max = 100)
    private String mastajerSsn;

    @Size(max = 11)
    private String mastajerMobile;

    @Size(max = 100)
    private String shomarehJavaz;

    private Date tarikhEtebar;

    private Boolean hasMobasher;

    @Size(max = 100)
    private String mobasherName;

    @Size(max = 100)
    private String rabetName;

    @Size(max = 100)
    private String semateRabet;

    @Size(max = 11)
    private String rabetMobile;

    @Size(max = 11)
    private String socialMobile;
    @Size(max = 100)
    private String mojtame;
    @Size(max = 100)
    private String imageTop;

    @Size(max = 100)
    private String imageTop2;

    @Size(max = 100)
    private String imageLogo;

    @Size(max = 100)
    private String imageAbout;

    @Size(max = 100)
    private String imageGovahi;

    private Double lat;

    private Double lng;

}
