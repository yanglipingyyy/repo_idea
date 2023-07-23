package com.lagou.domain;

public class Test {
    public Integer id;
    public String brief;

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", brief='" + brief + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }
}
