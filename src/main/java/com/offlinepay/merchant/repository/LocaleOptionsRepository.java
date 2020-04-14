package com.offlinepay.merchant.repository;

import com.offlinepay.merchant.entity.LocaleOptionsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocaleOptionsRepository extends CrudRepository<LocaleOptionsEntity, String> {

}