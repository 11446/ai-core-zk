package com.aicorezk.controller;

import com.aicorezk.common.BaseResponse;
import com.aicorezk.common.ResultUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping("/")
    public BaseResponse<String> healthCheck() {
        return ResultUtils.success("ok");
    }
}

