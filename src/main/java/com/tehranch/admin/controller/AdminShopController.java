package com.tehranch.admin.controller;

import com.tehranch.admin.dto.ownershop.ShopOwnerDto;
import com.tehranch.admin.service.AdminShopService;
import com.tehranch.admin.service.MapValidationErrorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.UUID;

@Controller
@RequestMapping("/api/admin")
public class AdminShopController {
    @Autowired
    private  AdminShopService adminShopService;
    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    private String imageTop;
    private String imageTop2;
    private String imageLogo;
    private String imageAbout;
    private String imageGovahi;


    @CrossOrigin(origins = "*")
    @PostMapping("/add")
    public ResponseEntity<?> addShop(
            @RequestHeader(HttpHeaders.AUTHORIZATION)String auth,
            @Valid @RequestBody ShopOwnerDto shopOwnerDto, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationService(result);
        if(errorMap!=null) return errorMap;
        shopOwnerDto.setImageTop(imageTop);
        shopOwnerDto.setImageTop2(imageTop2);
        shopOwnerDto.setImageAbout(imageAbout);
        shopOwnerDto.setImageLogo(imageLogo);
        shopOwnerDto.setImageGovahi(imageGovahi);
        Long resultId = adminShopService.save(auth, shopOwnerDto);
        return new ResponseEntity<>("created shop with id:"+resultId, HttpStatus.ACCEPTED);
    }

    @PostMapping("/uploadImageTop")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> uploadImageTop(@RequestParam("file") MultipartFile file) throws Exception {
        imageTop = saveImage(file);
        return new ResponseEntity<>(imageTop,HttpStatus.ACCEPTED);
    }

    private String saveImage(MultipartFile img){
        String path = "";
        String name = UUID.randomUUID().toString() + ".jpg";
        // if(file.getContentType().equals("Image/jpeg")){
        path = "C:\\paano-front\\public\\Imgs\\" + name;
        // }
        File file = new File(path);
        try (OutputStream os = new FileOutputStream(file)) {
            os.write(img.getBytes());
            return name;
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/uploadImageTop2")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> uploadImageTop2(@RequestParam("file") MultipartFile file) throws Exception {
        imageTop2 =  saveImage(file);
        return new ResponseEntity<>(imageTop2,HttpStatus.ACCEPTED);
    }

    @PostMapping("/uploadImageLogo")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> uploadImageLogo(@RequestParam("file") MultipartFile file) throws Exception {
        imageLogo = saveImage(file);
        return new ResponseEntity<>(imageLogo,HttpStatus.ACCEPTED);
    }

    @PostMapping("/uploadImageAbout")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> uploadImageAbout(@RequestParam("file") MultipartFile file) throws Exception {
        imageAbout= saveImage(file);
        return new ResponseEntity<>(imageAbout,HttpStatus.ACCEPTED);
    }

    @PostMapping("/uploadImageGovahi")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> uploadImageGovahi(@RequestParam("file") MultipartFile file) throws Exception {
        imageGovahi = saveImage(file);
        return new ResponseEntity<>(imageGovahi,HttpStatus.ACCEPTED);
    }
}
