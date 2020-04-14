package com.offlinepay.merchant.service;

import com.offlinepay.merchant.entity.LocaleOptionsEntity;
import com.offlinepay.merchant.entity.MerchantEntity;
import com.offlinepay.merchant.entity.ValidityOptionsEntity;
import com.offlinepay.merchant.model.Merchant;
import com.offlinepay.merchant.repository.LocaleOptionsRepository;
import com.offlinepay.merchant.repository.MerchantRepository;
import com.offlinepay.merchant.repository.ValidityOptionsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.offlinepay.merchant.converter.TypeConverter.convert;

@Slf4j
@Service
public class MerchantService {

    final MerchantRepository merchantRepository;
    final LocaleOptionsRepository localeOptionsRepository;
    final ValidityOptionsRepository validityOptionsRepository;

    public MerchantService(MerchantRepository merchantRepository, LocaleOptionsRepository localeOptionsRepository,
                           ValidityOptionsRepository validityOptionsRepository) {
        this.merchantRepository = merchantRepository;
        this.localeOptionsRepository = localeOptionsRepository;
        this.validityOptionsRepository = validityOptionsRepository;
    }

    /**
     *
     */
    public MerchantEntity addMerchant(Merchant merchant) {

        MerchantEntity merchantEntity = merchantRepository.save(convert(merchant));

        log.debug("MerchantEntity :: {}", merchantEntity);

        List<ValidityOptionsEntity> validityOptions = new ArrayList<>();
        List<LocaleOptionsEntity> localeOptions = new ArrayList<>();

        Arrays.stream(merchant.getValidityOptions()).forEach(i -> {
            validityOptions.add(persistValidityValue(i, merchantEntity));
        });

        Arrays.stream(merchant.getLocaleOptions()).forEach(i -> {
            localeOptions.add(persistLocaleValue(i, merchantEntity));
        });

        merchantEntity.setLinkValidity(validityOptions);
        merchantEntity.setLocale(localeOptions);

        return merchantEntity;
    }


    private ValidityOptionsEntity persistValidityValue(String value, MerchantEntity merchant) {

        ValidityOptionsEntity validity = ValidityOptionsEntity.builder()
                .merchant(merchant)
                .validity(value)
                .build();

        return validityOptionsRepository.save(validity);
    }


    private LocaleOptionsEntity persistLocaleValue(String value, MerchantEntity merchant) {

        LocaleOptionsEntity validity = LocaleOptionsEntity.builder()
                .merchant(merchant)
                .locale(value)
                .build();

        return localeOptionsRepository.save(validity);
    }


    public Optional<MerchantEntity> getMerchant(Long id) {
        return merchantRepository.findById(id);
    }


    public Iterable<MerchantEntity> getMerchants() {
        return merchantRepository.findAll();
    }

}
