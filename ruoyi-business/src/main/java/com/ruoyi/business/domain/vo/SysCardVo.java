package com.ruoyi.business.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ruoyi.common.annotation.ExcelDictFormat;
import com.ruoyi.common.convert.ExcelDictConvert;
import lombok.Data;
import java.util.Date;



/**
 * 信用卡视图对象 sys_card
 *
 * @author ruoyi
 * @date 2023-01-13
 */
@Data
@ExcelIgnoreUnannotated
public class SysCardVo {

    private static final long serialVersionUID = 1L;

    /**
     * 自动编号
     */
    @ExcelProperty(value = "自动编号")
    private Long id;

    /**
     * 持卡
     */
    @ExcelProperty(value = "持卡")
    private String name;

    /**
     * 名称
     */
    @ExcelProperty(value = "名称")
    private String title;

    /**
     * 银行
     */
    @ExcelProperty(value = "银行")
    private String bank;

    /**
     * 组织
     */
    @ExcelProperty(value = "组织")
    private String organize;

    /**
     * 卡号
     */
    @ExcelProperty(value = "卡号")
    private String cardNo;

    /**
     * 过期时间
     */
    @ExcelProperty(value = "过期时间")
    private Date expireAt;

    /**
     * 识别码
     */
    @ExcelProperty(value = "识别码")
    private String code;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;

    /**
     * 删除时间
     */
    @ExcelProperty(value = "删除时间")
    private Date deletedAt;


}
