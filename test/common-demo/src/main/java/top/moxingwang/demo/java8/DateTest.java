package top.moxingwang.demo.java8;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @description:
 * @author: MoXingwang 2018-09-13 14:19
 **/
public class DateTest {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    public static void main(String[] args) {
        LocalDateTime fifteenAgo = LocalDateTime.now().plusDays(-15);
        String lastDate = fifteenAgo.format(FORMATTER);
        System.out.println(lastDate);
    }
}
