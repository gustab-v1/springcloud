package com.tongtu.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {
    BRAND_SAVE_ERRO(500,"新增品牌失败"),
    USER_DATA_TYPE_ERROR(400,"用户数据类型无效"),
    ;
    private int code;
    private String msg;
}
