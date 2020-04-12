package com.offlinepay.merchant.repository;

import com.offlinepay.merchant.entity.MerchantEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends CrudRepository<MerchantEntity, Long> {

}
