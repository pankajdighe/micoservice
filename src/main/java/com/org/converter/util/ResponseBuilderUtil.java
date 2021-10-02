package com.org.converter.util;

import com.org.converter.models.ConversionResponse;

import java.util.List;

public class ResponseBuilderUtil {

    public static ConversionResponse build(List<ConversionResponse.ConversionObject> conversionObject) {

        ConversionResponse conversionResponse = new ConversionResponse();
        conversionResponse.getConversion().addAll(conversionObject);
        return conversionResponse;
    }


}
