package com.offlinepay.merchant.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MerchantDto {

    @JsonProperty("id")
    String id;

    @JsonProperty("merchant_id")
    String merchantId;

    @JsonProperty("reseller_id")
    String resellerId;

    @JsonProperty("merchant_name")
    String merchantName;

    @JsonProperty("merchant_email")
    String merchantEmail;

    @JsonProperty("currencies")
    Set<String> currency;

    @JsonProperty("locales")
    Set<String> locale;

    @JsonProperty("soft_descriptor")
    String softDescriptor;

    @JsonProperty("reference_1")
    String reference1;

    @JsonProperty("reference_2")
    String reference2;

    @JsonProperty("has_pspBranding")
    Boolean hasPSPBranding;

    @JsonProperty("has_thirdParty")
    Boolean hasThirdParty;

    @JsonProperty("has_tokenization")
    Boolean hasTokenization;
}
