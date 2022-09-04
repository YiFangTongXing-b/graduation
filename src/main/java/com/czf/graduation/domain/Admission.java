package com.czf.graduation.domain;

import lombok.Data;

@Data
public class Admission {
    private Integer id;
    private Integer sid;
    private Integer pid;
    private String schoolName;
    private String kind;
    private Integer year;
    private String major;
    private Integer leastScore;
    private Integer leastRank;
    private Integer avgScore;
    private Integer highScore;
    private Integer num;
}
