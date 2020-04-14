package com.offlinepay.merchant.repository;

import com.offlinepay.merchant.entity.ValidityOptionsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidityOptionsRepository extends CrudRepository<ValidityOptionsEntity, String> {

}