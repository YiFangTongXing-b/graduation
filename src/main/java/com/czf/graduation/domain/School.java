package com.czf.graduation.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class School implements Serializable {
    private Integer id;
    private Integer pid;
    private String name;
    private String site;
    private String scoreSite;

}