package com.example.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "benchmark")
public class BenchmarkEntity {

    public BenchmarkEntity() {};

    public BenchmarkEntity(int id, int num) {
        this.id = id;
        this.num = num;
    }

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private int num;
}
