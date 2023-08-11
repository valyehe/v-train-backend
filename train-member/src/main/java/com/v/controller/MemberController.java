package com.v.controller;

import com.v.common.BaseResponse;
import com.v.common.ResultUtils;
import com.v.model.dto.memberRequest.memberRegisterRequest;
import com.v.service.MemberService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Resource
    MemberService memberService;

    @GetMapping("/register")
    public BaseResponse<Long> memberRegister(@Valid memberRegisterRequest request) {
        long result = memberService.register(request);
        return ResultUtils.success(result);
    }
}
