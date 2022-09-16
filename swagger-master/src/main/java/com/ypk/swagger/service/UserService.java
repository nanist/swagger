package com.ypk.swagger.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @ClassName UserService * @Description TODO
 * @Author lgn
 * @Date 17:12 2022/9/16
 * @Version 1.0
 **/
public interface UserService {
    void importForSheetUsers(MultipartFile file) throws IOException;
}
