package com.offlinepay.merchant.controller;

import com.offlinepay.merchant.entity.MerchantEntity;
import com.offlinepay.merchant.model.Merchant;
import com.offlinepay.merchant.service.MerchantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Merchant", description = "The Merchant Management API")
public class MerchantController {

    final MerchantService merchantService;

    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @PostMapping("/merchant")
    @Operation(summary = "Add a new Merchant", description = "Add a new Merchant based on input data", responses = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public ResponseEntity<MerchantEntity> addMerchant(@RequestBody Merchant merchant) throws URISyntaxException {
        log.debug("executing addMerchant action :: {}", merchant);
        MerchantEntity entity = merchantService.addMerchant(merchant);
        return ResponseEntity.created(new URI("/api/v1/merchant/" + entity.getId())).body(entity);
    }

    @GetMapping("/merchant/{id}")
    @Operation(summary = "Get a merchant", description = "Get a Merchant for given Id", responses = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    ResponseEntity<?> getMerchant(@PathVariable Long id) {
        Optional<MerchantEntity> merchantEntity = merchantService.getMerchant(id);
        return merchantEntity.map(response -> new ResponseEntity<>(response, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/merchants")
    @Operation(summary = "Get all merchants", description = "Get list of all the Merchants", responses = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    ResponseEntity<Iterable<MerchantEntity>> getMerchants() {
        try {
            return new ResponseEntity<>(merchantService.getMerchants(), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Exception occurred :: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/merchant/{id}")
    @Operation(summary = "Update merchant", description = "Update merchant", responses = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    ResponseEntity<MerchantEntity> updateGroup(@RequestBody Merchant merchant) {
        log.info("Request to update Merchant :: {}", merchant);
        MerchantEntity entity = merchantService.updateMerchant(merchant);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }
}
