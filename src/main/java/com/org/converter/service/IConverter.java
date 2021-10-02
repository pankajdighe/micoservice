package com.org.converter.service;

import com.org.converter.models.ConversionResponse;

import java.util.List;

/**
 * Converter interface
 */
public interface IConverter {

    ConversionResponse.ConversionObject convert(Integer integer);

    List<ConversionResponse.ConversionObject> convertRange(Integer min, Integer max);
}
