package com.ruoyi.business.service;

import com.ruoyi.business.domain.SysCard;
import com.ruoyi.business.domain.vo.SysCardVo;
import com.ruoyi.business.domain.bo.SysCardBo;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 信用卡Service接口
 *
 * @author ruoyi
 * @date 2023-01-13
 */
public interface ISysCardService {

    /**
     * 查询信用卡
     */
    SysCardVo queryById(Long id);

    /**
     * 查询信用卡列表
     */
    TableDataInfo<SysCardVo> queryPageList(SysCardBo bo, PageQuery pageQuery);

    /**
     * 查询信用卡列表
     */
    List<SysCardVo> queryList(SysCardBo bo);

    /**
     * 新增信用卡
     */
    Boolean insertByBo(SysCardBo bo);

    /**
     * 修改信用卡
     */
    Boolean updateByBo(SysCardBo bo);

    /**
     * 校验并批量删除信用卡信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
