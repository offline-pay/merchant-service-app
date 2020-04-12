package com.offlinepay.merchant.service;

import com.offlinepay.merchant.entity.MerchantEntity;
import com.offlinepay.merchant.model.Merchant;
import com.offlinepay.merchant.repository.MerchantRepository;
import org.springframework.stereotype.Service;

import static com.offlinepay.merchant.converter.TypeConverter.convert;

@Service
public class MerchantService {

    final MerchantRepository merchantRepository;

    public MerchantService(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    /**
     *
     */
    public String addMerchant(Merchant merchant) {

        MerchantEntity merchantEntity = merchantRepository.save(convert(merchant));

        return "/merchant" + merchantEntity;
    }


}
