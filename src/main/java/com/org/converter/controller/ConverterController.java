package com.org.converter.controller;

import com.org.converter.models.ConversionResponse;
import com.org.converter.service.IConverter;
import com.org.converter.util.ResponseBuilderUtil;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Arrays;

/**
 * Following class is the controller layer which exposes the endpoints
 */
@RestController
@RequestMapping(value = "/converter/v1/")
@Validated
public class ConverterController {

    @Autowired
    IConverter interToRomanConverter;

    @RequestMapping(value = "/romannumeral",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @Timed(value = "convertTime")
    public ConversionResponse convertIntegerToRoman
            (@Valid @RequestParam(value = "query", required = false, defaultValue = "0") @Min(0) @Max(3999) int query,
             @Valid @RequestParam(value = "min", required = false, defaultValue = "0") @Min(0) @Max(3999) int min,
             @Valid @RequestParam(value = "max", required = false, defaultValue = "0") @Min(0) @Max(3999) int max

            ) {

        if (query > 0) {
            return ResponseBuilderUtil.build(Arrays.asList(interToRomanConverter.convert(query)));
        } else if (min > 0 && max > 0) {
            return ResponseBuilderUtil.build(interToRomanConverter.convertRange(min, max));
        }

        return null;
    }


}
