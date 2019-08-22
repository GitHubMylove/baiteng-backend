package com.baiteng.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class IdGeneratorUtils {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

    public static String generateRandId()

    {
        return new StringBuilder().append(simpleDateFormat.format(new Date())).append(
                String.valueOf(new Random()
                        .nextLong()).substring(0, 6)).toString();
    }

    public static Integer generateRandSeqId()
    {
        return Integer.valueOf(simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())).substring(7, 14));
    }

    public static String generateRandom()
    {
        return new StringBuilder().append(simpleDateFormat.format(Long.valueOf(new Date().getTime()))).append(String.valueOf(new Random().nextLong()).substring(0, 6)).toString();
    }

    public static void main(String[] args)
    {
        String id = generateRandom();
        System.out.println(id);
    }
}
