package com.example.MyBatisPractice.repository;

import com.example.MyBatisPractice.entity.FloorPlan;

import java.util.List;

public interface FloorPlanRepository {
    List<FloorPlan> selectByFloorPlanIdWithMansion (Integer id);
}
