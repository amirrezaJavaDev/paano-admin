package com.tehranch.admin.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tehranch.admin.utils.FieldType;
import com.tehranch.admin.utils.OrderRegister;
import com.tehranch.admin.utils.PanelType;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Date;

@Slf4j
@Entity
@Data
@Table(name = "shop_detail")
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class ShopDetail {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE , generator = "shop_detail_seq")
    @SequenceGenerator(name = "shop_detail_seq", sequenceName = "shop_detail_seq", allocationSize = 1)
    private Long id;

    @Column(name = "shop_name_per" , length = 100  , nullable = false)
    private String shopNamePersian;

    @Column(name = "shop_name_eng" , length = 100  , nullable = false,unique = true)
    private String shopNameEnglish;

    @Column(name = "instagram" , length = 100)
    private String instagram;

    @Column(name = "telegram" , length = 100)
    private String telegram;

    @Column(name = "website" , length = 100)
    private String website;

    @Column(name = "about" , length = 100)
    private String about;

    @Column(name = "tegdir" , length = 100)
    private String tagdir;

    @Column(name = "fax" , length = 100)
    private String fax;

    @Column(name = "phone" , length = 200)
    private String phone;

    @Column(name = "address" , length = 200)
    private String address;

    @Column(name = "email" , length = 100)
    private String email;

    @Column(name = "sales_manager_name" , length = 100 )
    private String salesManagerName;

    @Column(name = "sales_manager_mobile" , length = 11 )
    private String salesManagerMobile;

    @Column(name = "post_doce" , length = 10 )
    private String postCode;

    @Column(name = "meta_description" , length = 200)
    private String metaDescription;

    @Column(name = "meta_keywords" , length = 200)
    private String metaKeywords;

    @Column(name = "vage_dar" , length = 100)
    private String vageDar;

    @Column(name = "has_malekiat")
    private Boolean hasMalekiat;

    @Column(name = "has_mostager")
    private Boolean hasMostager;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_register" , length = 20)
    private OrderRegister orderRegister;

    @Enumerated(EnumType.STRING)
    @Column(name = "field_type" , length = 20)
    private FieldType fieldType;

    @Enumerated(EnumType.STRING)
    @Column(name = "panel_type" , length = 10)
    private PanelType panelType;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "mohlate_ejare")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date mohlateEjare;

    @Column(name = "mostajer_name" , length = 100)
    private String mastajerName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "mostager_birthday")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date mostagerBirthDay;

    @Column(name = "mostajer_ssn" , length = 10)
    private String mastajerSsn;

    @Column(name = "mostajer_mobile" , length = 11)
    private String mastajerMobile;

    @Column(name = "shomareh_javaz" , length = 100)
    private String shomarehJavaz;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tarikh_etebar")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date tarikhEtebar;

    @Column(name = "has_mobasher")
    private Boolean hasMobasher;

    @Column(name = "mobasher_name" , length = 100)
    private String mobasherName;

    @Column(name = "rabet_name" , length = 100)
    private String rabetName;

    @Column(name = "semate_rabet" , length = 100)
    private String semateRabet;

    @Column(name = "rabet_mobile" , length = 11)
    private String rabetMobile;

    @Column(name = "social_mobile" , length = 11)
    private String socialMobile;

    @Column(name = "image_top" , length = 100)
    private String imageTop;

    @Column(name = "image_top_2" , length = 100)
    private String imageTop2;

    @Column(name = "image_logo" , length = 100)
    private String imageLogo;

    @Column(name = "image_about" , length = 100)
    private String imageAbout;

    @Column(name = "lat")
    private Double lat;
    @Column(name = "lng")
    private Double lng;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date updateDate;

    @ManyToOne(cascade= CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name="shop_owner_id")
    private ShopOwner shopOwner;

    @PrePersist
    protected void onCreateDate(){
        this.createDate = new Date();
        log.info( "created :" + this.toString());
    }
    @PreUpdate
    protected void onUpdateDate(){
        this.createDate = new Date();
        log.info( "updated :" + this.toString());
    }
    @PreRemove
    protected void onRemove(){
        log.info("removed :" + this.toString());
    }
}

