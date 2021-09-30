package com.converter.converter.service;

import com.converter.converter.models.ConversionResponse;

import java.util.List;
import java.util.Map;

public interface IConverter {

    ConversionResponse.ConversionObject convert(Integer integer);

    List<ConversionResponse.ConversionObject> convertRange(Integer min, Integer max);
}
