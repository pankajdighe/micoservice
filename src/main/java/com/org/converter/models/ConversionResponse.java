package com.org.converter.models;

import java.util.ArrayList;
import java.util.List;

/**
 * This is model class to sent conversion response
 */
public class ConversionResponse {

    private List<ConversionObject> conversion = new ArrayList<>();


    public List<ConversionObject> getConversion() {
        return conversion;
    }

    public void setConversion(List<ConversionObject> conversion) {
        this.conversion = conversion;
    }


    public static class ConversionObject {
        private String input;
        private String output;


        public String getInput() {
            return input;
        }

        public void setInput(String input) {
            this.input = input;
        }

        public String getOutput() {
            return output;
        }

        public void setOutput(String output) {
            this.output = output;
        }


    }

}
