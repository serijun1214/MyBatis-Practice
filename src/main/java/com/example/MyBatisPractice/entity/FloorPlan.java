package com.example.MyBatisPractice.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FloorPlan implements Serializable {
    private Integer id;
    private String floorPlanName;
    private List<Mansion> mansions;
}
