package com.v.model.dto.memberRequest;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

@Data
public class memberRegisterRequest implements Serializable {

    @NotBlank(message = "手机号不为空")
    private String mobile;

}
