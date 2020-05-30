package com.leyou.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {
    BRAND_SAVE_ERRO(500,"新增品牌失败"),
    BRAND_NOT_FOUND(404,"品牌不存在"),
    PRICE_CANNOT_BE_NULL(400,"价格不能为空"),
    SPEC_GROUP_NOT_FOUND(404,"商品规格组没查到"),
    SPEC_PARAM_NOT_FOUND(404,"商品规格参数没查到"),
    CATEGORY_NOT_FOUND(404,"商品分类没查到"),
    UPLOAD_ERROR(500,"文件上传失败"),
    INVALID_FILE_TYPE(400,"文件格式不符"),
    ;
    private int code;
    private String msg;
}
