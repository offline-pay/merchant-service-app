package com.offlinepay.merchant.controller;

import com.offlinepay.merchant.entity.MerchantEntity;
import com.offlinepay.merchant.model.Merchant;
import com.offlinepay.merchant.service.MerchantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("api/v1")
public class MerchantController {

    final MerchantService merchantService;

    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @PostMapping("/merchant")
    public ResponseEntity<MerchantEntity> addMerchant(@RequestBody Merchant merchant) throws URISyntaxException {
        log.debug("executing addMerchant action :: {}", merchant);
        MerchantEntity entity = merchantService.addMerchant(merchant);
        return ResponseEntity.created(new URI("/api/v1/merchant/" + entity.getId())).body(entity);
    }

    @GetMapping("/merchant/{id}")
    ResponseEntity<?> getMerchant(@PathVariable Long id) {
        Optional<MerchantEntity> merchantEntity = merchantService.getMerchant(id);
        return merchantEntity.map(response -> new ResponseEntity<>(response, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/merchants")
    ResponseEntity<Iterable<MerchantEntity>> getMerchants() {
        try {
            return new ResponseEntity<>(merchantService.getMerchants(), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Exception occurred :: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
