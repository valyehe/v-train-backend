package com.v.controller;

import com.v.common.BaseResponse;
import com.v.common.ResultUtils;
import com.v.model.dto.memberRequest.memberLoginRequest;
import com.v.model.dto.memberRequest.memberSendCodeRequest;
import com.v.model.vo.member.memberVo;
import com.v.service.MemberService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Resource
    MemberService memberService;

    @PostMapping("/login")
    public BaseResponse<memberVo> memberRegister(@Valid @RequestBody memberLoginRequest request) {
        memberVo memberVo = memberService.login(request);
        return ResultUtils.success(memberVo);
    }

    @PostMapping("/sendCode")
    public BaseResponse<Boolean> memberSendCode(@Valid @RequestBody memberSendCodeRequest request) {
        boolean result = memberService.sendCode(request);
        return ResultUtils.success(result);
    }

}
