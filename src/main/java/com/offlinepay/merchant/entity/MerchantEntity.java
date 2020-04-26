package com.offlinepay.merchant.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Merchant")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class MerchantEntity {

    @Id
    @GeneratedValue //auto
    Long id;

    Long merchantId;
    Long resellerId;
    String merchantName;
    String merchantEmail;

    @ElementCollection
    @CollectionTable(name = "MerchantCurrency", joinColumns = @JoinColumn(name = "merchantId"))
    @Column(name = "currency")
    Set<String> currency;

    @ElementCollection
    @CollectionTable(name = "MerchantLocale", joinColumns = @JoinColumn(name = "merchantId"))
    @Column(name = "locale")
    Set<String> locale;

    String softDescriptor;
    String reference1;
    String reference2;

    @Column(name = "PSPBranding")
    Boolean hasPSPBranding;

    @Column(name = "ThirdParty")
    Boolean hasThirdParty;

    @Column(name = "Tokenization")
    Boolean hasTokenization;

}
