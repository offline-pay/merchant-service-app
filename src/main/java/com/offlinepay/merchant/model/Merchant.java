package com.offlinepay.merchant.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Merchant {

    @NotNull
    String merchantId;

    @Null
    String resellerId;

    @NotNull
    String merchantName;

    @NotNull
    @Email
    String merchantEmail;

    @NotNull
    String [] validityOptions;

    @NotNull
    String [] localeOptions;

    @Null
    String templateId;

    @Null
    String pageId;

    @Null
    Boolean pspBranding;

    @Null
    Boolean thirdParty;

    @Null
    Boolean tokenization;
}
