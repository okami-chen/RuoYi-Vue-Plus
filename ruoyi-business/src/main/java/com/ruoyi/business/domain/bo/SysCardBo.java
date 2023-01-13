package com.ruoyi.business.domain.bo;

import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.*;

import java.util.Date;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 信用卡业务对象 sys_card
 *
 * @author ruoyi
 * @date 2023-01-13
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class SysCardBo extends BaseEntity {

    /**
     * 自动编号
     */
    @NotNull(message = "自动编号不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 持卡
     */
    @NotBlank(message = "持卡不能为空", groups = { AddGroup.class, EditGroup.class })
    private String name;

    /**
     * 名称
     */
    @NotBlank(message = "名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String title;

    /**
     * 银行
     */
    @NotBlank(message = "银行不能为空", groups = { AddGroup.class, EditGroup.class })
    private String bank;

    /**
     * 组织
     */
    @NotBlank(message = "组织不能为空", groups = { AddGroup.class, EditGroup.class })
    private String organize;

    /**
     * 卡号
     */
    @NotBlank(message = "卡号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String cardNo;

    /**
     * 过期时间
     */
    @NotNull(message = "过期时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date expireAt;

    /**
     * 识别码
     */
    @NotBlank(message = "识别码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String code;

    /**
     * 备注
     */
    @NotBlank(message = "备注不能为空", groups = { AddGroup.class, EditGroup.class })
    private String remark;

    /**
     * 删除时间
     */
    private Date deletedAt;


}
