package com.jojo.entity;

import lombok.Data;

import java.util.List;

@Data
public class LayUiTable {
    private int code;
    private String msg;
    private long count;
    private List<?> data;

}
