package com.example.domain.repository;

import com.example.domain.model.BenchmarkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BenchmarkRepository extends JpaRepository<BenchmarkEntity, Integer> {

    // SELECT * FROM benchmark WHERE id = #{id}
    BenchmarkEntity findById(int id);

    // SELECT * FROM benchmark WHERE id IN (#{...ids})
    List<BenchmarkEntity> findByIdIn(List<Integer> ids);
}
