package com.ypk.swagger.controller;

import com.ypk.swagger.model.Result;
import com.ypk.swagger.model.User;
import com.ypk.swagger.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author lgn
 * @date 2021/6/20
 */
@Api(tags = "测试swagger")
@RestController
@RequestMapping(value = "/swagger")
public class SwaggerController {

    @Autowired
    private UserService userService;

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

    /**
     * excel多sheet导入
     */
    @ApiOperation(value = "excel多sheet导入", notes = "excel多sheet导入")
    @PostMapping(value ="ImportAssetsManage", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void importForSheetUsers(@RequestPart("file") MultipartFile file) throws IOException {
        userService.importForSheetUsers(file);
    }
}
