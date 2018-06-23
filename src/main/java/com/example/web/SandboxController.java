package com.example.web;

import com.example.domain.model.EmployeeEntity;
import com.example.domain.model.MappingHelper;
import com.example.domain.repository.EmployeeRepository;
import com.example.domain.service.BenchmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class SandboxController {

    @RequestMapping("/vue-xss")
    public String vueXss() {
        return "vue-xss";
    }
}
