package com.example.MyBatisPractice.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class Mansion implements Serializable {
    private Integer id;
    private String name;
    private String address;
    private String station;
    private Integer floorPlanId;
    private Date buildingDate;
    private Boolean status;
}
