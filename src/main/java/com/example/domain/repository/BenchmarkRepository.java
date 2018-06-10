package com.example.domain.repository;

import com.example.domain.model.BenchmarkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BenchmarkRepository extends JpaRepository<BenchmarkEntity, Integer> {

    BenchmarkEntity findById(int id);

    List<BenchmarkEntity> findByIdIn(List<Integer> ids);
}
