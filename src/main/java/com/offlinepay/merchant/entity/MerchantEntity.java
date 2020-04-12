package com.offlinepay.merchant.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "Merchant")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class MerchantEntity {
    @Id
    @GeneratedValue //auto
    Integer merchantId;

    String prefix;
    String firstName;
    String lastName;
    String email;
    String bookingReference;
    String bookingDescription;
    Integer amountMajor;
    Integer amountMinor;
    String currency;
    String locale;
    LocalDateTime linkValidity;

}
