package com.example.MyBatisPractice.repository;

import com.example.MyBatisPractice.entity.Mansion;

import java.util.ArrayList;
import java.util.List;

public interface MansionRepository {
    public List<Mansion> selectAll();
    public Mansion selectById(Integer id);
    public List<Mansion> selectByStatusBuildingDate (Mansion mansion);
    public List<Mansion> selectByFloorPlanIdBuildingDateStatus (Mansion mansion);
    public List<Mansion> selectByIdIN(List<Integer> idList);

    public List<Mansion> selectByStationLIKE(String stationName);

    List<Mansion> selectByNameStation(Mansion mansion);
    Boolean insert(Mansion mansion);
    Boolean update(Mansion mansion);
    Mansion selectByIdWithFloorPlan(Integer id);
}
