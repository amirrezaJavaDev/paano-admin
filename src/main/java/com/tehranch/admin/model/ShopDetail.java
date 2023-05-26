package com.tehranch.admin.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tehranch.admin.utils.FildPositionType;
import com.tehranch.admin.utils.PlanType;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Date;

@Slf4j
@Entity
@Data
@Table(name = "shop_detail_tbl")
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class ShopDetail {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE , generator = "shop_detail_seq")
    @SequenceGenerator(name = "shop_detail_seq", sequenceName = "shop_detail_seq", allocationSize = 1)
    private Long shopDetailId;

    @Column(name = "instagram_shop" , length = 100)
    private String instagram;

    @Column(name = "telegram_shop" , length = 100)
    private String telegram;

    @Column(name = "website_shop" , length = 100)
    private String website;

    @Column(name = "about_shop" , length = 100)
    private String aboutShop;

    @Column(name = "email_shop_detail" , length = 100)
    private String shopDetailEmail;

    @Column(name = "fax" , length = 100  , nullable = false)
    private String fax;

    @Column(name = "sales_manager_name" , length = 100  , nullable = false)
    private String salesManagerName;

    @Column(name = "sales_manager_mobile" , length = 100  , nullable = false)
    private String salesManagerMobile;

    @Column(name = "address" , length = 100  , nullable = false)
    private String address;

    @Column(name = "code_post" , length = 100  , nullable = false)
    private Long codePost;

    @Column(name = "meta_description" , length = 100)
    private String metadescription;

    @Column(name = "meta_keywords" , length = 100)
    private String metakeywords;

    @Column(name = "estate_personal" , length = 100  , nullable = false)
    private String estatePersonal;

    @Column(name = "order_register" , length = 100)
    private String orderRegister;

    @Column(name = "shop_name_per" , length = 100  , nullable = false)
    private String shopNamePersian;

    @Column(name = "shop_name_eng" , length = 100  , nullable = false,unique = true)
    private String shopNameEnglish;

    @Enumerated(EnumType.STRING)
    @Column(name = "position_type" , length = 100  , nullable = false)
    private FildPositionType fildPositionType;
    @Enumerated(EnumType.STRING)
    @Column(name = "plan_type" , length = 100  , nullable = false)
    private PlanType planType;

    @Column(name = "letter_of_commendations" , length = 100)
    private String letterOfCommendations;

    @Column(name = "shop_mobile" , length = 100 ,nullable = false)
    private String shopMobile;
    @Column(name = "image_top" , length = 100)
    private String imageTop;
    @Column(name = "image_top_2" , length = 100)
    private String imageTop2;
    @Column(name = "image_logo" , length = 100)
    private String imageLogo;
    @Column(name = "image_about" , length = 100)
    private String imageAbout;
    @Column(name = "image_letter_comandation" , length = 100)
    private String imageLetterOfCommandation;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date updateDate;
}

