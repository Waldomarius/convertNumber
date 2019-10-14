package com.testtask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Data {

    public static String zeroToTen[];
    public static String zeroToTenThousand[];
    public static String tenToTwenty[];
    public static String ten[];
    public static String hundred[];
    public static String thousand[];
    public static String million[];
    public static String billion[];
    public static String trillion[];
    public static String kvadrillion[];
    public static String kvintillion[];

    private static Data instance;

    private Data() {
        base();
    }

    public static Data getInstance() {
        if (instance == null) {
            instance = new Data();
        }
        return instance;
    }

    private static void base() {
        File file = new File("base.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            zeroToTen = br.readLine().split(",");
            zeroToTenThousand = br.readLine().split(",");
            tenToTwenty = br.readLine().split(",");
            ten = br.readLine().split(",");
            hundred = br.readLine().split(",");
            thousand = br.readLine().split(",");
            million = br.readLine().split(",");
            billion = br.readLine().split(",");
            trillion = br.readLine().split(",");
            kvadrillion = br.readLine().split(",");
            kvintillion = br.readLine().split(",");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}