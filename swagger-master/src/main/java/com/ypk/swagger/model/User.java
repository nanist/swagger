package com.ypk.swagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yangpk
 * @date 2021/6/20
 */
@ApiModel(value = "用户视图")
@Data
public class User {

    private int id;
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "年龄")
    private int age;
}
