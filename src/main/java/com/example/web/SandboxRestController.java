package com.example.web;

import com.example.domain.model.EmployeeEntity;
import com.example.domain.model.MappingHelper;
import com.example.domain.repository.EmployeeRepository;
import com.example.domain.service.BenchmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class SandboxRestController {

    private final BenchmarkService benchmarkService;

    private final EmployeeRepository employeeRepository;

    @RequestMapping("/mybatisToMap")
    public ResponseEntity<Map> mybatisToMap() {
        List<MappingHelper<Integer, EmployeeEntity>> mapperList = employeeRepository.findAllByIds(Arrays.asList(1, 2));
        Map<Integer, EmployeeEntity> employeeMap = MappingHelper.toMap(mapperList);
        return ResponseEntity.ok().body(employeeMap);
    }

    @RequestMapping("/benchmark/sql/loop")
    public ResponseEntity<Map> benchmarkDatabaseAccess() {
        // IN句を使って1回で10,000件のレコードを取得
        long beforeOneTime = System.currentTimeMillis();
        benchmarkService.oneTimesDatabaseAccess();
        long afterOneTime = System.currentTimeMillis();

        // 10,000回のループで1件ずつレコードを取得
        long beforeLoopTime = System.currentTimeMillis();
        benchmarkService.tenThousandTimesDatabaseAccess();
        long afterLoopTime = System.currentTimeMillis();

        Map<String, Long> result = new HashMap<>();
        result.put("oneTimeFirst", afterOneTime - beforeOneTime);
        result.put("loopTimeFirst", afterLoopTime - beforeLoopTime);

        // 同様の処理をもう1回
        beforeOneTime = System.currentTimeMillis();
        benchmarkService.oneTimesDatabaseAccess();
        afterOneTime = System.currentTimeMillis();

        beforeLoopTime = System.currentTimeMillis();
        benchmarkService.tenThousandTimesDatabaseAccess();
        afterLoopTime = System.currentTimeMillis();

        result.put("oneTimeSecond", afterOneTime - beforeOneTime);
        result.put("loopTimeSecond", afterLoopTime - beforeLoopTime);
        return ResponseEntity.status(200).body(result);
    }
}
