package com.v.model.dto.memberRequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.io.Serializable;

@Data
public class memberLoginRequest implements Serializable {

    @NotBlank(message = "手机号为空")
    @Pattern(regexp = "^1\\d{10}$", message = "手机格式错误")
    private String mobile;

    @NotBlank(message = "验证码为空")
    private String code;

    private String token;

}
