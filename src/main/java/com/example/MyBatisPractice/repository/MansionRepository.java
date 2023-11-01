package com.example.MyBatisPractice.repository;

import com.example.MyBatisPractice.entity.Mansion;

import java.util.List;

public interface MansionRepository {
    public List<Mansion> selectAll();
}
