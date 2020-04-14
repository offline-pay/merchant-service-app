package com.offlinepay.merchant.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class LinkProperties {

    ValidityPeriod validity;

    LocalDateTime validUntil;
}
