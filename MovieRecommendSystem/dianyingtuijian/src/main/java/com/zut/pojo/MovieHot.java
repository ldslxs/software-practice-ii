package com.zut.pojo;

public class MovieHot {
    private int mid;

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    private String imgUrl;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MovieHot{" +
                "mid=" + mid +
                ", imgUrl='" + imgUrl + '\'' +
                ", name='" + name + '\'' +
                ", count=" + count +
                '}';
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    private long count;


}
