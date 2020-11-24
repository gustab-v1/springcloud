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
    GOODS_NOT_FOUND(404,"商品不存在"),
    GOODS_DETAIL_NOT_FOUND(404,"商品详情不存在"),
    GOODS_SKU_NOT_FOUND(404,"商品SKU不存在"),
    GOODS_STOCK_NOT_FOUND(404,"商品库存不存在"),
    CATEGORY_NOT_FOUND(404,"商品分类没查到"),
    UPLOAD_ERROR(500,"文件上传失败"),
    INVALID_FILE_TYPE(400,"文件格式不符"),
    GOODS_SAVE_ERROR(500,"新增商品失败"),
    GOODS_UPDATE_ERROR(500,"更新商品失败"),
    GOODS_ID_BE_NULL(400,"商品ID不能为空"),
    USER_DATA_TYPE_ERROR(400,"用户数据类型无效")
    ;
    private int code;
    private String msg;
}
