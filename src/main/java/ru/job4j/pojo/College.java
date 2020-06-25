package ru.job4j.pojo;

import java.util.Date;

/**
 * 2. Модель данных. [#285781]
 */
public class College {
    public static void main(String[] args) {
        Student aStudent = new Student();
        aStudent.setFullName("Бадьянов Дмитрий Алексеевич");
        aStudent.setEntryDate(new Date());
        aStudent.setGroup(102);

        System.out.println(String.format("%s: зачислен %tF в группу № %d",
                aStudent.getFullName(),
                aStudent.getEntryDate(),
                aStudent.getGroup()));
    }
}
