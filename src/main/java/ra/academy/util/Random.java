package ra.academy.util;

import org.apache.commons.lang3.RandomStringUtils;

public class Random {
    public static String getNewIdTransaction (){
        // tạo ra chuỗi ngầũ nhiên 10 kí tự
        return RandomStringUtils.randomAlphanumeric(10);
    }
}
