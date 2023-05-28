package com.tehranch.admin.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Entity
@Table(name="shop_owner" , schema = "public")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ShopOwner {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE , generator = "shop_owner_seq")
    @SequenceGenerator(name = "shop_owner_seq", sequenceName = "shop_owner_seq", allocationSize = 1)
    @Column(name="ID")
    private Long id;

    @Column(name = "mobile" , length = 11 , unique = true , nullable = false)
    private String mobile;

    @Column(name = "owner_name" , length = 100)
    private String ownerName;

    @Column(name = "ssn" , length = 10)
    private String ssn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "birth_date")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date birthDate;

    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="shopOwner",
            cascade= CascadeType.ALL)
    private Set<ShopDetail> shopDetails = new HashSet<>();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date updateDate;

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
