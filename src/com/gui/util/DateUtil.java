package com.gui.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.gui.model.Student;

public class DateUtil {

    public static final Properties errors = new Properties();

    static {
        try {
            InputStream is = new FileInputStream("errors.properties");
            errors.load(is);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 将日期转换为字符串
     */
    public static LocalDate dateToLocalDate(Date date) {
        return LocalDate.ofEpochDay(date.getTime() / 86400000).plusDays(1);
    }

    /**
     * 集合转数组
     */
    public static Object[][] listToArray(List<Student> stus) {
        Object[][] data = new Object[stus.size()][];
        int size = stus.size();
        for (int i = 0; i < size; i++) {
            Student s = stus.get(i);
            Object[] info = new Object[]{s.getId(), s.getName(), s.getScore(), s.getBirth(), s.getCity()};
            data[i] = info;
        }
        return data;
    }
}
