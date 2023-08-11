package com.v.controller;

import com.v.common.BaseResponse;
import com.v.common.ResultUtils;
import com.v.model.dto.memberRequest.memberLoginRequest;
import com.v.model.dto.memberRequest.memberSendCodeRequest;
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

    @GetMapping("/login")
    public BaseResponse<Long> memberRegister(@Valid memberLoginRequest request) {
        long result = memberService.login(request);
        return ResultUtils.success(result);
    }

    @GetMapping("/sendCode")
    public BaseResponse<Boolean> memberSendCode(@Valid memberSendCodeRequest request) {
        boolean result = memberService.sendCode(request);
        return ResultUtils.success(result);
    }

}
