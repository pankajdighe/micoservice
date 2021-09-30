package com.converter.converter.util;

import com.converter.converter.models.ConversionResponse;

import java.util.List;
import java.util.Map;

public class ResponseBuilderUtil {

    public static ConversionResponse build(List<ConversionResponse.ConversionObject> conversionObject) {

        ConversionResponse conversionResponse = new ConversionResponse();
        conversionResponse.getConversion().addAll(conversionObject);
        return conversionResponse;
    }


}
