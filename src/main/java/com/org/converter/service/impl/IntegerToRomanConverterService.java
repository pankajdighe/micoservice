package com.org.converter.service.impl;

import com.org.converter.models.ConversionResponse;
import com.org.converter.service.IConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * This is the implementation of IConverter which converts Integer to Roman numeral
 */
@Component
public class IntegerToRomanConverterService implements IConverter {
    public static int[] data = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public static String[] roman_str = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    Logger logger = LoggerFactory.getLogger(IntegerToRomanConverterService.class);

    @Override
    public ConversionResponse.ConversionObject convert(Integer input) {
        logger.info("initiating conversion for {}", input);
        ConversionResponse.ConversionObject conversionObject = new ConversionResponse.ConversionObject();
        StringBuilder sb = new StringBuilder();
        Integer temp = input;

        for (int i = 0; i < data.length; i++) {
            int unit = data[i];
            if (input >= unit) {
                int n = input / unit;
                for (int j = 0; j < n; j++) {
                    sb.append(roman_str[i]);
                }
                input %= unit;
            }
        }
        conversionObject.setInput(String.valueOf(temp));
        conversionObject.setOutput(sb.toString());
        return conversionObject;
    }

    @Override
    public List<ConversionResponse.ConversionObject> convertRange(Integer min, Integer max) {

        logger.info("initiating conversion from {} to {}", min, max);


        List<CompletableFuture<ConversionResponse.ConversionObject>> completableFutureList = new ArrayList<>();

        Queue<ConversionResponse.ConversionObject> queue = new PriorityQueue<ConversionResponse.ConversionObject>((a, b) -> {
            return Integer.valueOf(a.getInput()) - Integer.valueOf(b.getInput());
        });


        for (int i = min; i <= max; i++) {
            int finalI = i;
            CompletableFuture<ConversionResponse.ConversionObject> conversionObjectCompletableFuture =
                    CompletableFuture.supplyAsync(() -> convert(finalI));
            completableFutureList.add(conversionObjectCompletableFuture);
        }

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                completableFutureList.toArray(new CompletableFuture[completableFutureList.size()])
        );

        allFutures.thenApply(v -> {
            return completableFutureList.stream()
                    .map(pageContentFuture -> {
                        ConversionResponse.ConversionObject conversionObject = pageContentFuture.join();

                        queue.add(conversionObject);
                        return conversionObject;
                    })
                    .collect(Collectors.toList());
        });

        allFutures.join();

        return new ArrayList<>(queue);
    }


}
