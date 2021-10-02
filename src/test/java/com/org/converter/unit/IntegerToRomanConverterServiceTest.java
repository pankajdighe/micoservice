package com.org.converter.unit;

import com.org.converter.models.ConversionResponse;
import com.org.converter.service.IConverter;
import com.org.converter.service.impl.IntegerToRomanConverterService;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.List;

public class IntegerToRomanConverterServiceTest {


    IConverter converter =  new IntegerToRomanConverterService();


    @Test
    public void testConvert_with_positive_input_1() {
        ConversionResponse.ConversionObject conversionObject =  converter.convert(10);
        Assert.isTrue(conversionObject.getOutput().equals("X"));
    }

    @Test
    public void testConvert_with_positive_input_2() {
        ConversionResponse.ConversionObject conversionObject =  converter.convert(11);
        Assert.isTrue(conversionObject.getOutput().equals("XI"));
    }

    @Test
    public void testConvert_with_negative_input_1() {
        ConversionResponse.ConversionObject conversionObject =  converter.convert(-11);
        Assert.isTrue(conversionObject.getOutput().equals(""));
    }

    @Test
    public void testConvert_with_zero_input_2() {
        ConversionResponse.ConversionObject conversionObject =  converter.convert(0);
        Assert.isTrue(conversionObject.getOutput().equals(""));
    }

    @Test
    public void testConvertRange_with_positive_input_1() {
        List<ConversionResponse.ConversionObject> conversionObject =  converter.convertRange(1, 3999);

        Assert.isTrue(conversionObject.size()==3999);
    }

    @Test
    public void testConvertRange_with_negative_input_1() {
        List<ConversionResponse.ConversionObject> conversionObject =  converter.convertRange(-1, -3999);
        Assert.isTrue(conversionObject.size()==0);
    }

    @Test
    public void testConvertRange_with_negative_and_positive_input_1() {
        List<ConversionResponse.ConversionObject> conversionObject =  converter.convertRange(-1, 3999);
        Assert.isTrue(conversionObject.size()!=0);
        Assert.isTrue(conversionObject.get(0).getOutput().equals(""));
    }
}
