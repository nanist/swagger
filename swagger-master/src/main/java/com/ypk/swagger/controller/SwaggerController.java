package com.ypk.swagger.controller;

import com.ypk.swagger.model.Result;
import com.ypk.swagger.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lgn
 * @date 2021/6/20
 */
@Api(tags = "测试swagger")
@RestController
@RequestMapping(value = "/swagger")
public class SwaggerController {

    @ApiOperation(value = "获取用户信息")
    @GetMapping(value = "/info")
    public Result<User> getInfo() {
        return Result.<User>successResponse();
    }

    @ApiOperation(value = "获取列表数据")
    @GetMapping(value = "/list")
    public Result<List<User>> getList() {
        return Result.<List<User>>successResponse();
    }
}
