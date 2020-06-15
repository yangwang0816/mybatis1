package com.kgc.grade.domain;

import com.kgc.grade.util.PageParmeter;

public class StudentCondition extends PageParmeter {
    private String name;
    private Integer startAge;
    private Integer endAge;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStartAge() {
        return startAge;
    }

    public void setStartAge(Integer startAge) {
        this.startAge = startAge;
    }

    public Integer getEndAge() {
        return endAge;
    }

    public void setEndAge(Integer endAge) {
        this.endAge = endAge;
    }
}
