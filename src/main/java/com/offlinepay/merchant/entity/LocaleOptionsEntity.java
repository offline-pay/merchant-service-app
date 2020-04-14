package com.offlinepay.merchant.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "MerchantLocales")
@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LocaleOptionsEntity {

    @Id
    @GeneratedValue
    Long id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "merchantId", nullable = false)
    MerchantEntity merchant;

    String locale;

}
