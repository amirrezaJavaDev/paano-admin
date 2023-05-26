package com.tehranch.admin.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Date;


@Slf4j
@Entity
@Table(name="shop_owner_detail" , schema = "public")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ShopOwnerDetail {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE , generator = "shop_owner_detail_seq")
    @SequenceGenerator(name = "shop_owner_detail_seq", sequenceName = "shop_owner_detail_seq", allocationSize = 1)
    private Long shopOwnerDetailId;

    @Column(name = "owner_name")
    private String ownerName;

    @Column(name = "email")
    private String email;

    @Column(name = "ssn")
    private String ssn;

    @Column(name = "owner_birthday")
    private Date ownerBirthday;

    @OneToOne(cascade = CascadeType.ALL , mappedBy = "shopOwnerDetail" , fetch = FetchType.LAZY)
    private ShopOwner shopOwner;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date updateDate;
}
