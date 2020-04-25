package com.offlinepay.merchant.service;

import com.offlinepay.merchant.entity.MerchantEntity;
import com.offlinepay.merchant.model.MerchantDto;
import com.offlinepay.merchant.repository.MerchantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static com.offlinepay.merchant.mapper.MerchantMapper.INSTANCE;

@Slf4j
@Service
public class MerchantService {

    final MerchantRepository merchantRepository;

    public MerchantService(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }


    public MerchantDto addMerchant(MerchantDto merchantDto) {

        MerchantEntity merchantEntity = merchantRepository.save(INSTANCE.toMerchantEntity(merchantDto));

        log.debug("MerchantEntity :: {}", merchantEntity);

        return INSTANCE.ToMerchantDto(merchantEntity);
    }


    public MerchantDto getMerchant(Long id) {
        Optional<MerchantEntity> merchantEntity = merchantRepository.findById(id);

        if (merchantEntity.isPresent()) {
            return INSTANCE.ToMerchantDto(merchantEntity.get());
        } else {
            throw new EntityNotFoundException(String.valueOf(id));
        }
    }


    public Iterable<MerchantDto> getMerchants() {
        return INSTANCE.toMerchantDtoList(merchantRepository.findAll());
    }


    public MerchantDto updateMerchant(MerchantDto merchantDto) {

        MerchantEntity merchantEntity = merchantRepository.save(INSTANCE.toMerchantEntity(merchantDto));

        log.debug("MerchantEntity :: {}", merchantEntity);

        return INSTANCE.ToMerchantDto(merchantEntity);
    }
}
