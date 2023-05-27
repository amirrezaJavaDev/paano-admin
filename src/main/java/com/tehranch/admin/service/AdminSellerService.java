package com.tehranch.admin.service;

import com.tehranch.admin.dto.ownershop.ShopOwnerDto;
import com.tehranch.admin.dto.ownershop.ShopOwnerDtoManager;
import com.tehranch.admin.exception.CustomException;
import com.tehranch.admin.model.ShopDetail;
import com.tehranch.admin.model.ShopOwner;
import com.tehranch.admin.repository.ShopDetailRepository;
import com.tehranch.admin.repository.ShopOwnerDetailRepository;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class AdminSellerService {
    private final RestTemplate restTemplate;
    private final ShopDetailRepository shopDetailRepo;
    private final ShopOwnerRepository shopOwnerRepo;
    private final ShopOwnerDetailRepository shopOwnerDetailRepo;
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
    @Transactional
    public Long saveDetail(String encoderToken, ShopOwnerDto shopOwnerDto){
        if (authorizeUser(encoderToken)){
           saveShopOwner(shopOwnerDto);
           saveShopDetail(shopOwnerDto);
           Long shopOdId = saveShopOwnerDetail(shopOwnerDto);
           return shopOdId;
        }else{
            throw new CustomException("Not Authorized");
        }
    }

    public ShopOwnerDto findShopOwnerWithId(String encoding,Long id){
        try{
            if(authorizeUser(encoding)){
                Optional<ShopOwner> optionalResult = shopOwnerRepo.findById(id);
                if (optionalResult.isPresent()){
                   return shopOwnerDtoManager.transferOwnerShopAndDetailToDto(optionalResult.get(),null,null);
                }else{
                    throw new CustomException("اطلاعات مسئول فروشگاهی با این ایدی یافت نشد");
                }
            }
        }catch (RuntimeException ex){
            throw new CustomException(ex.getMessage());
        }
        return null;
    }

    public ShopOwnerDto findShopDetailByEngName(String encoding,String shopName){
       try{
           if(authorizeUser(encoding)){
               Optional<ShopDetail> optionalResult = shopDetailRepo.findByShopNameEnglish(shopName);
               if (optionalResult.isPresent()){
                   ShopOwnerDto shopOwnerDto = shopOwnerDtoManager.transferOwnerShopAndDetailToDto(null, null, optionalResult.get());
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

    private Long saveShopDetail(ShopOwnerDto shopOwnerDto) {
        Long shopDetailId = shopDetailRepo.save(shopOwnerDtoManager.transferShopDetailDtoToEntity(shopOwnerDto)).getShopDetailId();
        return shopDetailId;
    }

    private Long saveShopOwnerDetail(ShopOwnerDto shopOwnerDto) {
        Long shopOwnerDetailId= shopOwnerDetailRepo.save(shopOwnerDtoManager.transferShopOwnerDetailDtoToEntity(shopOwnerDto))
                .getShopOwnerDetailId();
        return shopOwnerDetailId;
    }

    private Long saveShopOwner(ShopOwnerDto shopOwnerDto) {
        Long shopOwnerId = shopOwnerRepo.save(shopOwnerDtoManager.transferShopOwnerDtoToEntity(shopOwnerDto)).getId();
        return shopOwnerId;
    }
    private List<ShopOwnerDto> findAllSales(String encoding){
        List<ShopOwnerDto> allSalers = new ArrayList<>();
        if(authorizeUser(encoding)){
            List<ShopOwnerDto> shopEntities=new ArrayList<>();
            Iterable<ShopDetail> shopDetails = this.shopDetailRepo.findAll();
            System.out.println("shop detail is:"+shopDetails);
            return null;
        }else {
            throw new CustomException("Invalid User !");
        }
    }
}
