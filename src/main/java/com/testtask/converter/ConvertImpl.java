package com.testtask.converter;


import com.testtask.Data;

import java.util.ArrayList;
import java.util.List;

public class ConvertImpl implements Convert {

    private StringBuffer result = new StringBuffer();

    public ConvertImpl() {
        Data.getInstance();
    }

    @Override
    public <T extends Number> String convertNumber(T number) {
        result.setLength(0);
        if (number instanceof Float || number instanceof Double) {
            return "дробное число";
        } else {
            if (Long.parseLong(number.toString()) < 0) {
                return "число меньше нуля";
            } else {
                return combineStringFromNumber(segmentNumber(number)).trim();
            }
        }
    }

    private <T extends Number> List<String> segmentNumber(T number) {

        List<String> listSegment = new ArrayList<>();
        String stringNumber = number.toString();
        int quantitySegment = stringNumber.length() / 3;
        int lastSegment = stringNumber.length() % 3;

        for (int i = 0; i < quantitySegment; i++) {
            listSegment.add(stringNumber.substring(stringNumber.length() - 3 * i - 3, stringNumber.length() - 3 * i));
        }

        if (lastSegment != 0) {
            listSegment.add(stringNumber.substring(0, stringNumber.length() - quantitySegment * 3));
        }
        return listSegment;
    }

    private String combineStringFromNumber(List<String> listSegment) {
        if (listSegment.size() == 1 && listSegment.get(0).equals("0")) return "ноль";
        for (int i = listSegment.size() - 1; i >= 0; i--) {

            switch (i) {
                case 6:
                    result.append(stringTextNumber(listSegment.get(i), false));
                    result.append(stringTextRegister(Data.kvintillion, listSegment.get(i)) + " ");
                    break;
                case 5:
                    result.append(stringTextNumber(listSegment.get(i), false));
                    if (listSegment.get(i).equals("000")) {
                        break;
                    }
                    result.append(stringTextRegister(Data.kvadrillion, listSegment.get(i)) + " ");
                    break;
                case 4:
                    result.append(stringTextNumber(listSegment.get(i), false));
                    if (listSegment.get(i).equals("000")) {
                        break;
                    }
                    result.append(stringTextRegister(Data.trillion, listSegment.get(i)) + " ");
                    break;
                case 3:
                    result.append(stringTextNumber(listSegment.get(i), false));
                    if (listSegment.get(i).equals("000")) {
                        break;
                    }
                    result.append(stringTextRegister(Data.billion, listSegment.get(i)) + " ");
                    break;
                case 2:
                    result.append(stringTextNumber(listSegment.get(i), false));
                    if (listSegment.get(i).equals("000")) {
                        break;
                    }
                    result.append(stringTextRegister(Data.million, listSegment.get(i)) + " ");
                    break;
                case 1:
                    result.append(stringTextNumber(listSegment.get(i), true));
                    if (listSegment.get(i).equals("000")) {
                        break;
                    }
                    result.append(stringTextRegister(Data.thousand, listSegment.get(i)) + " ");
                    break;
                case 0:
                    result.append(stringTextNumber(listSegment.get(i), false));
                    break;
            }
        }
        return result.toString();
    }

    private String stringTextRegister(String textRegister[], String segment) {

        if (segment.length() == 3 && segment.equals("000")) return "";

        if ((segment.length() == 2 && segment.charAt(segment.length() - 2) == '1') ||
                (segment.length() == 3 && segment.charAt(segment.length() - 2) == '1') ||
                (segment.length() == 3 && segment.charAt(segment.length() - 1) == '0')) {
            return textRegister[2];
        } else {
            String result = "";
            switch (segment.charAt(segment.length() - 1)) {
                case '1':
                    result = textRegister[0];
                    break;
                case '2':
                case '3':
                case '4':
                    result = textRegister[1];
                    break;
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    result = textRegister[2];
                    break;
            }
            return result;
        }
    }

    private String stringTextNumber(String number, boolean keyThousand) {
        char mass[] = number.toCharArray();
        boolean keyTen = true;

        for (int i = 0; i < mass.length; i++) {
            switch (mass.length - i) {
                case 3:
                    if (!numberToText(Data.hundred, mass[i]).equals(""))
                        result.append(numberToText(Data.hundred, mass[i]) + " ");
                    break;
                case 2:
                    if (mass[i] == '1') {
                        keyTen = false;
                    } else {
                        if (!numberToText(Data.ten, mass[i]).equals(""))
                            result.append(numberToText(Data.ten, mass[i]) + " ");
                    }
                    break;
                case 1:
                    if (keyTen) {
                        if (keyThousand) {
                            if (!numberToText(Data.zeroToTenThousand, mass[i]).equals(""))
                                result.append(numberToText(Data.zeroToTenThousand, mass[i]) + " ");
                        } else {
                            if (!numberToText(Data.zeroToTen, mass[i]).equals(""))
                                result.append(numberToText(Data.zeroToTen, mass[i]) + " ");
                        }
                    } else {
                        if (!numberToText(Data.tenToTwenty, mass[i]).equals(""))
                            result.append(numberToText(Data.tenToTwenty, mass[i]) + " ");
                    }
                    break;
            }
        }
        return "";
    }

    private String numberToText(String text[], char ch) {
        int value = Character.getNumericValue(ch);
        for (int i = 0; i < 10; i++) {
            if (i == value) return text[i];
        }
        return "";
    }
}


