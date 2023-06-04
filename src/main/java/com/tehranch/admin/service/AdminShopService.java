package com.tehranch.admin.service;

import com.tehranch.admin.dto.ownershop.ShopOwnerDto;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

public interface AdminShopService {

    @Transactional
    Long save(String encoderToken, ShopOwnerDto shopOwnerDto);

    ShopOwnerDto findShopDetailByEngName(String encoding, String shopName);
}
