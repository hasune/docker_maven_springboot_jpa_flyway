package com.hasune.springjpa;

import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class SpringjpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringjpaApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setPreferNestedProperties(false);
        // String to LocalDate
        mapper.addConverter(
                new AbstractConverter<String, LocalDate>() {
                    @Override
                    protected LocalDate convert(String source) {
                        if (source == null) {
                            return null;
                        }
                        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        return LocalDate.parse(source, format);
                    }
                });
        // LocalDate to String
        mapper.addConverter(
                new AbstractConverter<LocalDate, String>() {
                    @Override
                    protected String convert(LocalDate source) {
                        if (source == null) {
                            return null;
                        }
                        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        return source.format(format);
                    }
                });
        return mapper;
    }
}
