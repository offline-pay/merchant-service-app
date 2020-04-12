package com.offlinepay.merchant.converter;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.JMapperAPI;
import com.offlinepay.merchant.entity.MerchantEntity;
import com.offlinepay.merchant.model.Merchant;

import static com.googlecode.jmapper.api.JMapperAPI.attribute;
import static com.googlecode.jmapper.api.JMapperAPI.mappedClass;

public class TypeConverter {

    public static MerchantEntity convert(Merchant model) {

        JMapperAPI jmapperApi = new JMapperAPI().add(mappedClass(MerchantEntity.class)
                        .add(attribute("prefix").value("${customer.prefix}"))
                        .add(attribute("firstName").value("${customer.firstName}"))
                        .add(attribute("lastName").value("${customer.familyName}"))
                        .add(attribute("email").value("${customer.email}"))
                        .add(attribute("amountMajor").value("${invoice.amountMajor}"))
                        .add(attribute("amountMinor").value("${invoice.amountMinor}"))
                        .add(attribute("currency").value("${invoice.currencyCode}"))
                        .add(attribute("linkValidity").value("linkProperties"))
                        .add(attribute("bookingDescription").value("bookingDescription"))
                        .add(attribute("bookingReference").value("bookingReferencePrefix"))
                        .add(attribute("locale").value("locale"))
                );

        JMapper<MerchantEntity, Merchant> merchantMapper = new JMapper<>(MerchantEntity.class, Merchant.class, jmapperApi);

        return merchantMapper.getDestination(model);
    }

}
