package com.czf.graduation.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class UCollection implements Serializable {
    Integer cid;
    Integer uid;
    Integer aid;
    String schoolName;
    String major;
    String provinceIndex;            //录取的省份
    Integer year;
    Integer leastScore;
    Integer leastRank;
    Integer highScore;
    Integer avgScore;
    Integer num;
    String kind;
}
