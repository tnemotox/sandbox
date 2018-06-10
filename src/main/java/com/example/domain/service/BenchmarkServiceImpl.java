package com.example.domain.service;

import com.example.domain.repository.BenchmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class BenchmarkServiceImpl implements BenchmarkService {

    private final BenchmarkRepository benchmarkRepository;

    public void tenThousandTimesDatabaseAccess() {
        for (int i = 1; i <= 10000; i++) {
            benchmarkRepository.findById(i);
        }
    }

    public void oneTimesDatabaseAccess() {
        List<Integer> ids = IntStream.range(1, 10000).boxed().collect(toList());
        benchmarkRepository.findByIdIn(ids);
    }
}
