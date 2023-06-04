package com.tehranch.admin.service;

import com.tehranch.admin.dto.ownershop.ShopOwnerDto;
import com.tehranch.admin.dto.ownershop.ShopOwnerDtoManager;
import com.tehranch.admin.exception.CustomException;
import com.tehranch.admin.model.ShopDetail;
import com.tehranch.admin.model.ShopOwner;
import com.tehranch.admin.repository.ShopDetailRepository;
import com.tehranch.admin.repository.ShopOwnerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class AdminShopServiceImpl implements AdminShopService
{
    private final RestTemplate restTemplate;
    private final ShopDetailRepository shopDetailRepo;
    private final ShopOwnerRepository shopOwnerRepo;
    private ShopOwnerDtoManager shopOwnerDtoManager = Mappers.getMapper(ShopOwnerDtoManager.class);




    private boolean authorizeUser(String cookie){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Authorization",cookie);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        int status = restTemplate
                .exchange("https://tehranch.com/api/superuser/token", HttpMethod.GET, entity, String.class)
                .getStatusCodeValue();
        if (status == 200){
            return true;
        }
        return false;
    }
    @Override
    @Transactional
    public Long save(String encoderToken, ShopOwnerDto shopOwnerDto){
        if (authorizeUser(encoderToken)){
            ShopOwner shopOwner = shopOwnerDtoManager.transferShopOwnerDtoToEntity(shopOwnerDto);
            Long shopOwnerId = shopOwnerRepo.save(shopOwner).getId();
            shopOwnerDto.setShopOwnerId(shopOwnerId);
            ShopDetail shopDetail = shopOwnerDtoManager.transferShopDetailDtoToEntity(shopOwnerDto);
            shopDetail.setShopOwner(shopOwner);
            shopDetailRepo.save(shopDetail);
           return shopOwnerId;
        }else{
            throw new CustomException("Not Authorized");
        }
    }





    @Override
    public ShopOwnerDto findShopDetailByEngName(String encoding, String shopName){
       try{
           if(authorizeUser(encoding)){
               Optional<ShopDetail> optionalResult = shopDetailRepo.findByShopNameEnglish(shopName);
               if (optionalResult.isPresent()){
                   ShopOwnerDto shopOwnerDto = shopOwnerDtoManager.transferOwnerShopAndDetailToDto(null, optionalResult.get());
                   return shopOwnerDto;
               }else {
                   throw new CustomException("با این اسم فروشگاهی یافت نشد.");
               }
           }
       }catch (RuntimeException ex){
           throw new CustomException(ex.getMessage());
       }
       return null;
    }
}
