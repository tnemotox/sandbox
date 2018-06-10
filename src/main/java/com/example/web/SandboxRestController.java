package com.example.web;

import com.example.domain.service.BenchmarkService;
import com.example.domain.service.BenchmarkServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/benchmark")
@RequiredArgsConstructor
public class SandboxRestController {

    private final BenchmarkService benchmarkService;

    @RequestMapping("/sql/loop")
    public ResponseEntity<String> benchmarkDatabaseAccess() {
        // IN句を使って1回で100,000件のレコードを取得
        long beforeOneTime = System.currentTimeMillis();
        benchmarkService.oneTimesDatabaseAccess();
        long afterOneTime = System.currentTimeMillis();

        // 100,000回のループで1件ずつレコードを取得
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
        return ResponseEntity.status(200).body(result.toString());
    }
}
