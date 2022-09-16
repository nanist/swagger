package com.ypk.swagger.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName ImportServer * @Description TODO
 * @Author lgn
 * @Date 18:38 2022/9/16
 * @Version 1.0
 **/
@Data
public class ImportServer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Excel(name = "计算机名称", orderNum = "0",width = 10.0)
    private String name;
    @Excel(name = "服务器IP", orderNum = "1",width = 10.0)
    private String ip;
}
