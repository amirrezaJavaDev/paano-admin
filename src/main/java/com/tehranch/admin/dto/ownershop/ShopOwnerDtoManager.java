package com.tehranch.admin.dto.ownershop;

import com.tehranch.admin.model.ShopDetail;
import com.tehranch.admin.model.ShopOwner;
import com.tehranch.admin.model.ShopOwnerDetail;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ShopOwnerDtoManager {

    @Mapping(source ="shopOwner.id",target = "id")
    @Mapping(source ="shopOwner.mobile",target = "mobile")
    @Mapping(source ="shopOwnerDetail.shopOwnerDetailId",target = "shopOwnerDetailId")
    @Mapping(source ="shopOwnerDetail.ownerName",target = "ownerName")
    @Mapping(source ="shopOwnerDetail.email",target = "email")
    @Mapping(source ="shopOwnerDetail.ssn",target = "ssn")
    @Mapping(source ="shopOwnerDetail.ownerBirthday",target = "ownerBirthday")
    @Mapping(source = "shopDetail.shopDetailId",target = "shopDetailId")
    @Mapping(source = "shopDetail.instagram",target = "instagram")
    @Mapping(source = "shopDetail.telegram",target = "telegram")
    @Mapping(source = "shopDetail.website",target = "website")
    @Mapping(source = "shopDetail.aboutShop",target = "aboutShop")
    @Mapping(source = "shopDetail.shopDetailEmail",target = "shopDetailEmail")
    @Mapping(source = "shopDetail.fax",target = "fax")
    @Mapping(source = "shopDetail.salesManagerName",target = "salesManagerName")
    @Mapping(source = "shopDetail.salesManagerMobile",target = "salesManagerMobile")
    @Mapping(source = "shopDetail.address",target = "address")
    @Mapping(source = "shopDetail.codePost",target = "codePost")
    @Mapping(source = "shopDetail.metadescription",target = "metadescription")
    @Mapping(source = "shopDetail.metakeywords",target = "metakeywords")
    @Mapping(source = "shopDetail.estatePersonal",target = "estatePersonal")
    @Mapping(source = "shopDetail.orderRegister",target = "orderRegister")
    @Mapping(source = "shopDetail.shopNamePersian",target = "shopNamePersian")
    @Mapping(source = "shopDetail.shopNameEnglish",target = "shopNameEnglish")
    @Mapping(source = "shopDetail.letterOfCommendations",target = "letterOfCommendations")
    @Mapping(source = "shopDetail.shopMobile",target = "shopMobile")
    @Mapping(source = "shopDetail.imageTop",target = "imageTop")
    @Mapping(source = "shopDetail.imageTop2",target = "imageTop2")
    @Mapping(source = "shopDetail.imageLogo",target = "imageLogo")
    @Mapping(source = "shopDetail.imageAbout",target = "imageAbout")
    @Mapping(source = "shopDetail.fildPositionType",target = "fildPositionType")
    @Mapping(source = "shopDetail.planType",target = "planType")
    @Mapping(source = "shopDetail.imageLetterOfCommandation",target = "imageLetterOfCommandation")
    ShopOwnerDto transferOwnerShopAndDetailToDto(ShopOwner shopOwner, ShopOwnerDetail shopOwnerDetail, ShopDetail shopDetail);


    @InheritInverseConfiguration
    ShopOwner transferShopOwnerDtoToEntity(ShopOwnerDto shopOwnerDto);

    @InheritInverseConfiguration
    ShopOwnerDetail transferShopOwnerDetailDtoToEntity(ShopOwnerDto shopOwnerDto);

    @InheritInverseConfiguration
    ShopDetail transferShopDetailDtoToEntity(ShopOwnerDto shopOwnerDto);
}
