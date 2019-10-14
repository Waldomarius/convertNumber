package com.testtask.converter;

import org.junit.Test;
import static org.junit.Assert.*;

public class ConvertImplTest {

    @Test
    public void convertNumberTest() {

        Convert convert = new ConvertImpl();

        assertEquals("дробное число", convert.convertNumber(1.0));
        assertEquals("дробное число", convert.convertNumber(1.0F));
        assertEquals("число меньше нуля", convert.convertNumber(-1));
        assertEquals("ноль", convert.convertNumber(0));
        assertEquals("один", convert.convertNumber((byte) 1));
        assertEquals("один", convert.convertNumber((short) 1));
        assertEquals("один", convert.convertNumber((long) 1));

        assertEquals("один", convert.convertNumber(1));
        assertEquals("два", convert.convertNumber(2));
        assertEquals("пять", convert.convertNumber(5));
        assertEquals("десять", convert.convertNumber(10));
        assertEquals("двенадцать", convert.convertNumber(12));
        assertEquals("двадцать", convert.convertNumber(20));
        assertEquals("двадцать пять", convert.convertNumber(25));
        assertEquals("сто", convert.convertNumber(100));
        assertEquals("сто один", convert.convertNumber(101));
        assertEquals("сто одиннадцать", convert.convertNumber(111));
        assertEquals("сто двадцать один", convert.convertNumber(121));
        assertEquals("сто восемдесят", convert.convertNumber(180));

        assertEquals("одна тысяча", convert.convertNumber(1_000));
        assertEquals("одна тысяча один", convert.convertNumber(1_001));
        assertEquals("одна тысяча десять", convert.convertNumber(1_010));
        assertEquals("одна тысяча двадцать один", convert.convertNumber(1_021));
        assertEquals("одна тысяча сто", convert.convertNumber(1_100));
        assertEquals("одна тысяча сто один", convert.convertNumber(1_101));
        assertEquals("одна тысяча сто двадцать один", convert.convertNumber(1_121));
        assertEquals("две тысячи", convert.convertNumber(2_000));
        assertEquals("пять тысяч", convert.convertNumber(5_000));
        assertEquals("двадцать одна тысяча", convert.convertNumber(21_000));
        assertEquals("сто тысяч", convert.convertNumber(100_000));
        assertEquals("сто десять тысяч", convert.convertNumber(110_000));
        assertEquals("сто двадцать одна тысяча", convert.convertNumber(121_000));

        assertEquals("один миллион", convert.convertNumber(1_000_000));
        assertEquals("три миллиона", convert.convertNumber(3_000_000));
        assertEquals("пять миллионов", convert.convertNumber(5_000_000));
        assertEquals("пятнадцать миллионов", convert.convertNumber(15_000_000));
        assertEquals("двадцать один миллион", convert.convertNumber(21_000_000));
        assertEquals("сто миллионов", convert.convertNumber(100_000_000));
        assertEquals("сто двадцать один миллион", convert.convertNumber(121_000_000));

        assertEquals("один миллиард", convert.convertNumber(1_000_000_000));
        assertEquals("два миллиарда", convert.convertNumber(2_000_000_000));
        assertEquals("пять миллиардов", convert.convertNumber(5_000_000_000L));
        assertEquals("десять миллиардов", convert.convertNumber(10_000_000_000L));
        assertEquals("пятнадцать миллиардов", convert.convertNumber(15_000_000_000L));
        assertEquals("двадцать один миллиард", convert.convertNumber(21_000_000_000L));
        assertEquals("сто двадцать один миллиард", convert.convertNumber(121_000_000_000L));

        assertEquals("один триллион", convert.convertNumber(1_000_000_000_000L));
        assertEquals("два триллиона", convert.convertNumber(2_000_000_000_000L));
        assertEquals("пять триллионов", convert.convertNumber(5_000_000_000_000L));
        assertEquals("десять триллионов", convert.convertNumber(10_000_000_000_000L));
        assertEquals("пятнадцать триллионов", convert.convertNumber(15_000_000_000_000L));
        assertEquals("двадцать один триллион", convert.convertNumber(21_000_000_000_000L));
        assertEquals("сто двадцать один триллион", convert.convertNumber(121_000_000_000_000L));

        assertEquals("один квадриллион", convert.convertNumber(1_000_000_000_000_000L));
        assertEquals("два квадриллиона", convert.convertNumber(2_000_000_000_000_000L));
        assertEquals("пять квадриллионов", convert.convertNumber(5_000_000_000_000_000L));
        assertEquals("десять квадриллионов", convert.convertNumber(10_000_000_000_000_000L));
        assertEquals("пятнадцать квадриллионов", convert.convertNumber(15_000_000_000_000_000L));
        assertEquals("двадцать один квадриллион", convert.convertNumber(21_000_000_000_000_000L));
        assertEquals("сто двадцать один квадриллион", convert.convertNumber(121_000_000_000_000_000L));

        assertEquals("один квинтиллион", convert.convertNumber(1_000_000_000_000_000_000L));
        assertEquals("два квинтиллиона", convert.convertNumber(2_000_000_000_000_000_000L));
        assertEquals("пять квинтиллионов", convert.convertNumber(5_000_000_000_000_000_000L));
        assertEquals("девять квинтиллионов", convert.convertNumber(9_000_000_000_000_000_000L));

        //Integer.MAX_VALUE: 2_147_483_647
        assertEquals("два миллиарда сто сорок семь миллионов четыреста восемдесят три тысячи шестьсот сорок семь",
                convert.convertNumber(Integer.MAX_VALUE));

        //Long.MAX_VALUE: 9_223_372_036_854_775_807
        assertEquals("девять квинтиллионов двесте двадцать три квадриллиона триста семдесят два триллиона" +
                " тридцать шесть миллиардов восемьсот пятьдесят четыре миллиона семьсот семдесят пять тысяч восемьсот семь",
                convert.convertNumber(Long.MAX_VALUE));
    }
}
