package com.tehranch.admin.controller;

import com.tehranch.admin.dto.ownershop.ShopOwnerDto;
import com.tehranch.admin.service.AdminShopService;
import com.tehranch.admin.service.MapValidationErrorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/admin")
@AllArgsConstructor
public class AdminShopController {
    private final AdminShopService adminShopService;
    private final MapValidationErrorService mapValidationErrorService;

    @PostMapping("/add")
    public ResponseEntity<?> addShop(
            @RequestHeader(HttpHeaders.AUTHORIZATION)String encoding,
            @Valid @RequestBody ShopOwnerDto shopOwnerDto, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationService(result);
        if(errorMap!=null) return errorMap;
        Long resultId = adminShopService.save(encoding, shopOwnerDto);
        return new ResponseEntity<>("created shop with id:"+resultId, HttpStatus.ACCEPTED);
    }

}
