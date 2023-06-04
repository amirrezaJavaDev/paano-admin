package com.tehranch.admin.service;

import com.tehranch.admin.dto.ShopPageListDto;
import com.tehranch.admin.repository.ShopDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SellerService {

    private final ShopDetailRepository shopDetailRepository;

    public List<ShopPageListDto> findShopPageList(ShopPageListDto search){
        List<Tuple> tuples = shopDetailRepository.findShop(search);
        List<ShopPageListDto> shopPageListDtos = new ArrayList<>();
        tuples.stream().forEach(i -> {
            ShopPageListDto shopPageListDto = new ShopPageListDto();
            shopPageListDto.setPanel(i.get(0)!=null?(String) i.get(0):"");
            shopPageListDto.setShopEng((String) i.get(1));
            shopPageListDto.setShopPer((String) i.get(2));
            shopPageListDto.setImgGovahi((String) i.get(3));
            shopPageListDtos.add(shopPageListDto);
        });
        return shopPageListDtos;
    }
}
