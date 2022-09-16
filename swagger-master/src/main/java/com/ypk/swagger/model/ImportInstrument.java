package com.ypk.swagger.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName 仪器 * @Description TODO
 * @Author lgn
 * @Date 17:41 2022/9/16
 * @Version 1.0
 **/
@Data
public class ImportInstrument implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * @Excel 作用在一个filed上面，对列的描述
     * @param name 列名
     * @param orderNum 下标，从0开始。
     */
    @Excel(name = "设备名称", orderNum = "0",width = 10.0)
    private String name;
    @Excel(name = "类型", orderNum = "1",width = 10.0)
    private Integer type;
}
