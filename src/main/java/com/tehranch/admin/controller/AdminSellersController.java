package com.tehranch.admin.controller;

import com.tehranch.admin.dto.ownershop.ShopOwnerDto;
import com.tehranch.admin.dto.ownershop.ShopOwnerDtoManager;
import com.tehranch.admin.service.AdminSellerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/admin")
@AllArgsConstructor
public class AdminSellersController {
    private final AdminSellerService adminSellerService;
    @GetMapping
    public ResponseEntity<String> detect(){
        return new ResponseEntity<>("successfully",HttpStatus.ACCEPTED);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addShop(
            @RequestHeader(HttpHeaders.AUTHORIZATION)String encoding,
            @Valid @RequestBody ShopOwnerDto shopOwnerDto){
        Long result = adminSellerService.saveDetail(encoding, shopOwnerDto);
        return new ResponseEntity<>("created shop with id:"+result, HttpStatus.ACCEPTED);
    }
    @GetMapping("/find/shopowner/{id}")
    public ResponseEntity<?> findById(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader,@PathVariable Long id) {
            return new ResponseEntity<>(adminSellerService.findShopOwnerWithId(authHeader,id),HttpStatus.CREATED);
    }
    @GetMapping("/find/shopdetail/{name}")
    private ResponseEntity<?> findByEnglishName(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String autHeader,
            @PathVariable(name = "name") String name){
            return new  ResponseEntity<>(adminSellerService.findShopDetailByEngName(autHeader,name),HttpStatus.ACCEPTED);
    }

}
