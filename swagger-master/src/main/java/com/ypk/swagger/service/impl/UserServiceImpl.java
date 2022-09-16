package com.ypk.swagger.service.impl;

import com.ypk.swagger.model.ImportInstrument;
import com.ypk.swagger.model.ImportServer;
import com.ypk.swagger.service.UserService;
import com.ypk.swagger.utils.EasyPoiUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName UserServiceImpl * @Description TODO
 * @Author lgn
 * @Date 17:13 2022/9/16
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void importForSheetUsers(MultipartFile file) throws IOException {

        //分批进行读取excel的sheet工作表
        //读取第一个sheet表
        List<ImportInstrument> sheetOneUsers = EasyPoiUtils.importExcel(file.getInputStream(), 0, 1, 1, ImportInstrument.class);
        //读取第二个sheet表
        List<ImportServer> sheetTwoUsers = EasyPoiUtils.importExcel(file.getInputStream(), 1, 1, 1, ImportServer.class);

        for (ImportInstrument o:sheetOneUsers){

            System.out.println("------one:"+o);
        }

        for (ImportServer o:sheetTwoUsers){
            System.out.println("------two:"+o);
        }

    }
}
