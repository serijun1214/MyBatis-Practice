package com.example.MyBatisPractice.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class FloorPlan implements Serializable {
    private Integer id;
    private String floorPlanName;
}
