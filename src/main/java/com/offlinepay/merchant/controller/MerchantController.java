package com.offlinepay.merchant.controller;

import com.offlinepay.merchant.model.Merchant;
import com.offlinepay.merchant.service.MerchantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/merchant/v1/")
public class MerchantController {

    final MerchantService merchantService;

    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @PostMapping
    public void addMerchant(@RequestBody Merchant merchant) {
       merchantService.addMerchant(merchant);
    }

}
