package com.tehranch.admin.service;

import com.tehranch.admin.dto.ownershop.ShopOwnerDto;
import org.springframework.transaction.annotation.Transactional;

public interface AdminShopService {
    Long save(String encoderToken, ShopOwnerDto shopOwnerDto);

    ShopOwnerDto findShopDetailByEngName(String encoding, String shopName);
}
