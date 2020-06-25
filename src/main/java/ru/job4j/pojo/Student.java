package ru.job4j.pojo;

import java.util.Date;

/**
 * 2. Модель данных. [#285781]
 */
public class Student {
    private String fullName;
    private int group;
    private Date entryDate;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }
}
