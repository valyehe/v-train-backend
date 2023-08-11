package com.v.model.dto.memberRequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.io.Serializable;

@Data
public class memberSendCodeRequest implements Serializable {

    @NotBlank(message = "手机号不为空")
    @Pattern(regexp = "^1\\d{10}$",message = "手机格式错误")
    private String mobile;

}
