package com.offlinepay.merchant.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class Merchant {

    @NotNull
    String bookingReferencePrefix;

    @NotNull
    String bookingDescription;

    @NotNull
    String locale;

}
