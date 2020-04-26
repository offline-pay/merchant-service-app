package com.offlinepay.merchant.controller;

import com.google.common.collect.Iterables;
import com.offlinepay.merchant.model.MerchantDto;
import com.offlinepay.merchant.service.MerchantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/v1/merchants")
@Tag(name = "Merchant", description = "The Merchant Management API")
public class MerchantController {

    final MerchantService merchantService;

    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @PostMapping
    @Operation(summary = "Add a new Merchant", description = "Add a new Merchant based on input data", responses = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public ResponseEntity<MerchantDto> addMerchant(@RequestBody MerchantDto merchantDto) {
        log.debug("executing addMerchant action :: {}", merchantDto);
        MerchantDto responseDto = merchantService.addMerchant(merchantDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    @Operation(summary = "Get a merchant", description = "Get a Merchant for given Id", responses = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    ResponseEntity<MerchantDto> getMerchant(@PathVariable Long id) {
        try {
            MerchantDto merchantDto = merchantService.getMerchant(id);
            log.debug("MerchantDto :: {}", merchantDto);

            return new ResponseEntity<>(merchantDto, HttpStatus.OK);

        } catch (Exception ex) {
            log.error("Exception Occurred :: {}", ex.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping
    @Operation(summary = "Get all merchants", description = "Get list of all the Merchants", responses = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    ResponseEntity<Iterable<MerchantDto>> getMerchants() {
        try {
            Iterable<MerchantDto> merchantList = merchantService.getMerchants();

            int resultSize = Iterables.size(merchantList);
            log.debug("Size of Merchant List :: {}", resultSize);

            HttpHeaders headers = new HttpHeaders();
            headers.add("X-Total-Count", String.valueOf(resultSize));
            headers.add("Access-Control-Expose-Headers", "X-Total-Count");

            return new ResponseEntity<>(merchantList, headers, HttpStatus.OK);

        } catch (Exception e) {
            log.error("Exception occurred :: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/{id}")
    @Operation(summary = "Update merchant", description = "Update merchant", responses = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    ResponseEntity<MerchantDto> updateMerchant(@RequestBody MerchantDto merchantDto) {
        log.debug("Request to update Merchant :: {}", merchantDto);
        MerchantDto responseDto = merchantService.updateMerchant(merchantDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
