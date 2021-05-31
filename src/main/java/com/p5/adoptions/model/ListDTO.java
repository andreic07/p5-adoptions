package com.p5.adoptions.model;

import java.util.List;

public class ListDTO<T> {

    private Integer totalCount;
    private List<T> data;

    public ListDTO(Integer totalCount, List<T> data) {
        this.totalCount = totalCount;
        this.data = data;
    }
    public Integer getTotalCount() {
        return totalCount;
    }

    public ListDTO<T> setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    public List<T> getData() {
        return data;
    }

    public ListDTO<T> setData(List<T> data) {
        this.data = data;
        return this;
    }
}
