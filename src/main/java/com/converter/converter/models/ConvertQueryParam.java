package com.converter.converter.models;

import org.springframework.beans.factory.annotation.Required;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class ConvertQueryParam {

    @Min(1)
    @Max(3999)
    private int query;

    @Min(1)
    @Max(3999)
    private int min;

    @Min(1)
    @Max(3999)
    private int max;

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }



    public int getQuery() {
        return query;
    }

    public void setQuery(int query) {
        this.query = query;
    }

}
