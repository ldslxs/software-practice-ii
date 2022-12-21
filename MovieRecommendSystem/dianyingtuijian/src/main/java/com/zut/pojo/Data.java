package com.zut.pojo;

public class Data {
    private int value;
    private String name;

    public Data(int value, String name) {
        this.value = value;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Data{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Data() {
    }
}
