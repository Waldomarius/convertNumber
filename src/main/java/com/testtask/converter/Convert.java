package com.testtask.converter;

public interface Convert {
    <T extends Number> String convertNumber(T t);
}
