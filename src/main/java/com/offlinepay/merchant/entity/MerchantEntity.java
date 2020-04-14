package com.offlinepay.merchant.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

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

    @JsonManagedReference
    @OneToMany(mappedBy = "merchant", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<ValidityOptionsEntity> linkValidity;

    @JsonManagedReference
    @OneToMany(mappedBy = "merchant", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<LocaleOptionsEntity> locale;

    Integer templateId;
    Integer pageId;
    Boolean pspBranding;
    Boolean thirdParty;
    Boolean tokenization;
}
