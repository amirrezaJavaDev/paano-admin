package com.tehranch.admin.controller;

import com.tehranch.admin.dto.ShopPageListDto;
import com.tehranch.admin.service.MapValidationErrorService;
import com.tehranch.admin.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sellerpro")
public class SellerController {

    private final MapValidationErrorService mapValidationErrorService;

    private final SellerService sellerService;

    @PostMapping
    public ResponseEntity<?> findMeeting(@Valid @RequestBody ShopPageListDto search, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationService(result);
        if(errorMap!=null) return errorMap;
        return new ResponseEntity<>(sellerService.findShopPageList(search), HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity<?> test(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
