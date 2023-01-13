package com.ruoyi.business.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 信用卡对象 sys_card
 *
 * @author ruoyi
 * @date 2023-01-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_card")
public class SysCard extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 自动编号
     */
    @TableId(value = "id")
    private Long id;
    /**
     * 持卡
     */
    private String name;
    /**
     * 名称
     */
    private String title;
    /**
     * 银行
     */
    private String bank;
    /**
     * 组织
     */
    private String organize;
    /**
     * 卡号
     */
    private String cardNo;
    /**
     * 过期时间
     */
    private Date expireAt;
    /**
     * 识别码
     */
    private String code;
    /**
     * 备注
     */
    private String remark;
    /**
     * 删除时间
     */
    private Date deletedAt;

}
