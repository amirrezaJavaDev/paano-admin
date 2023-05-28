package com.tehranch.admin.dto.ownershop;

import com.tehranch.admin.model.ShopDetail;
import com.tehranch.admin.model.ShopOwner;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ShopOwnerDtoManager {

    @Mapping(source ="shopOwner.id",target = "shopOwnerId")
    @Mapping(source ="shopOwner.mobile",target = "mobile")
    @Mapping(source ="shopOwner.ownerName",target = "ownerName")
    @Mapping(source ="shopDetail.email",target = "email")
    @Mapping(source ="shopOwner.ssn",target = "ssn")
    @Mapping(source ="shopOwner.birthDate",target = "ownerBirthday")
    @Mapping(source = "shopDetail.id",target = "shopDetailId")
    @Mapping(source = "shopDetail.shopNamePersian",target = "shopNamePersian")
    @Mapping(source = "shopDetail.shopNameEnglish",target = "shopNameEnglish")
    @Mapping(source = "shopDetail.instagram",target = "instagram")
    @Mapping(source = "shopDetail.telegram",target = "telegram")
    @Mapping(source = "shopDetail.website",target = "website")
    @Mapping(source = "shopDetail.about",target = "about")
    @Mapping(source = "shopDetail.tagdir",target = "tagdir")
    @Mapping(source = "shopDetail.fax",target = "fax")
    @Mapping(source = "shopDetail.phone",target = "phone")
    @Mapping(source = "shopDetail.address",target = "address")
    @Mapping(source = "shopDetail.salesManagerName",target = "salesManagerName")
    @Mapping(source = "shopDetail.salesManagerMobile",target = "salesManagerMobile")
    @Mapping(source = "shopDetail.postCode",target = "postCode")
    @Mapping(source = "shopDetail.metaDescription",target = "metaDescription")
    @Mapping(source = "shopDetail.metaKeywords",target = "metaKeywords")
    @Mapping(source = "shopDetail.vageDar",target = "vageDar")
    @Mapping(source = "shopDetail.orderRegister",target = "orderRegister")
    @Mapping(source = "shopDetail.hasMalekiat",target = "hasMalekiat")
    @Mapping(source = "shopDetail.hasMostager",target = "hasMostager")
    @Mapping(source = "shopDetail.fieldType",target = "fieldType")
    @Mapping(source = "shopDetail.panelType",target = "panelType")
    @Mapping(source = "shopDetail.mohlateEjare",target = "mohlateEjare")
    @Mapping(source = "shopDetail.mastajerName",target = "mastajerName")
    @Mapping(source = "shopDetail.mostagerBirthDay",target = "mostagerBirthDay")
    @Mapping(source = "shopDetail.mastajerSsn",target = "mastajerSsn")
    @Mapping(source = "shopDetail.mastajerMobile",target = "mastajerMobile")
    @Mapping(source = "shopDetail.shomarehJavaz",target = "shomarehJavaz")
    @Mapping(source = "shopDetail.tarikhEtebar",target = "tarikhEtebar")
    @Mapping(source = "shopDetail.hasMobasher",target = "hasMobasher")
    @Mapping(source = "shopDetail.mobasherName",target = "mobasherName")
    @Mapping(source = "shopDetail.rabetName",target = "rabetName")
    @Mapping(source = "shopDetail.semateRabet",target = "semateRabet")
    @Mapping(source = "shopDetail.rabetMobile",target = "rabetMobile")
    @Mapping(source = "shopDetail.socialMobile",target = "socialMobile")
    @Mapping(source = "shopDetail.lat",target = "lat")
    @Mapping(source = "shopDetail.lng",target = "lng")
    @Mapping(source = "shopDetail.imageTop",target = "imageTop")
    @Mapping(source = "shopDetail.imageTop2",target = "imageTop2")
    @Mapping(source = "shopDetail.imageLogo",target = "imageLogo")
    @Mapping(source = "shopDetail.imageAbout",target = "imageAbout")
    ShopOwnerDto transferOwnerShopAndDetailToDto(ShopOwner shopOwner, ShopDetail shopDetail);


    @InheritInverseConfiguration
    ShopOwner transferShopOwnerDtoToEntity(ShopOwnerDto shopOwnerDto);

    @InheritInverseConfiguration
    ShopDetail transferShopDetailDtoToEntity(ShopOwnerDto shopOwnerDto);
}
