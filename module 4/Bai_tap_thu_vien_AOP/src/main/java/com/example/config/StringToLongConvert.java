package com.example.config;

import org.springframework.core.convert.converter.Converter;

public class StringToLongConvert implements Converter<String, Long> {

    @Override
    public Long convert(String source) {
        Long num = Long.parseLong(source);
        return num;
    }
}
