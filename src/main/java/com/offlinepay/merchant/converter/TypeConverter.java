package com.offlinepay.merchant.converter;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.JMapperAPI;
import com.offlinepay.merchant.entity.MerchantEntity;
import com.offlinepay.merchant.model.Merchant;

import static com.googlecode.jmapper.api.JMapperAPI.attribute;
import static com.googlecode.jmapper.api.JMapperAPI.mappedClass;
import static com.googlecode.jmapper.api.enums.MappingType.ONLY_VALUED_FIELDS;

public class TypeConverter {

    public static MerchantEntity convert(Merchant model) {

        JMapperAPI jmapperApi = new JMapperAPI().add(mappedClass(MerchantEntity.class)
                        .add(attribute("merchantId").value("merchantId"))
                        .add(attribute("resellerId").value("resellerId"))
                        .add(attribute("merchantName").value("merchantName"))
                        .add(attribute("merchantEmail").value("merchantEmail"))
                        .add(attribute("templateId").value("templateId"))
                        .add(attribute("pageId").value("pageId"))
                        .add(attribute("pspBranding").value("pspBranding"))
                        .add(attribute("thirdParty").value("thirdParty"))
                        .add(attribute("tokenization").value("tokenization"))
                );

        JMapper<MerchantEntity, Merchant> merchantMapper = new JMapper<>(MerchantEntity.class, Merchant.class, jmapperApi);

        return merchantMapper.getDestination(model, ONLY_VALUED_FIELDS);
    }

}
