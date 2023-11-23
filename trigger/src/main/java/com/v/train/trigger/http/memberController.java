package com.v.train.trigger.http;

import com.v.train.domain.member.model.entity.MemberEntity;
import com.v.train.domain.member.model.entity.MemberLoginEntity;
import com.v.train.domain.member.service.IMemberService;
import com.v.train.types.model.BaseResponse;
import com.v.train.types.util.ResultUtils;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class memberController {
    @Resource
    private IMemberService memberService;

    @GetMapping("/code")
    @ResponseBody
    public BaseResponse<Boolean> sendCode(MemberLoginEntity memberLogin) {

        Boolean result = memberService.sendCodeByMobile(memberLogin);

        return ResultUtils.success(result);
    }

    @PostMapping("/login")
    @ResponseBody
    public BaseResponse<MemberEntity> login(MemberLoginEntity memberLogin) {

        MemberEntity result = memberService.memberLogin(memberLogin);

        return ResultUtils.success(result);
    }


}
