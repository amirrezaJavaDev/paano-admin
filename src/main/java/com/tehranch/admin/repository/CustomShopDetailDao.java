package com.tehranch.admin.repository;

import com.tehranch.admin.dto.ShopPageListDto;
import com.tehranch.admin.dto.ownershop.ShopOwnerDto;

import javax.persistence.Tuple;
import java.util.List;

public interface CustomShopDetailDao {


    List<Tuple> findShop(ShopPageListDto search);
}
