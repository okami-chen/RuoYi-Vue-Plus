package com.ruoyi.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.ruoyi.business.domain.bo.SysCardBo;
import com.ruoyi.business.domain.vo.SysCardVo;
import com.ruoyi.business.domain.SysCard;
import com.ruoyi.business.mapper.SysCardMapper;
import com.ruoyi.business.service.ISysCardService;

import java.util.*;

/**
 * 信用卡Service业务层处理
 *
 * @author ruoyi
 * @date 2023-01-13
 */
@RequiredArgsConstructor
@Service
public class SysCardServiceImpl implements ISysCardService {

    private final SysCardMapper baseMapper;

    /**
     * 查询信用卡
     */
    @Override
    public SysCardVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询信用卡列表
     */
    @Override
    public TableDataInfo<SysCardVo> queryPageList(SysCardBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<SysCard> lqw = buildQueryWrapper(bo);
        Page<SysCardVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询信用卡列表
     */
    @Override
    public List<SysCardVo> queryList(SysCardBo bo) {
        LambdaQueryWrapper<SysCard> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<SysCard> buildQueryWrapper(SysCardBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<SysCard> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(bo.getName()), SysCard::getName, bo.getName());
        lqw.eq(StringUtils.isNotBlank(bo.getTitle()), SysCard::getTitle, bo.getTitle());
        lqw.eq(StringUtils.isNotBlank(bo.getBank()), SysCard::getBank, bo.getBank());
        lqw.eq(StringUtils.isNotBlank(bo.getOrganize()), SysCard::getOrganize, bo.getOrganize());
        lqw.eq(StringUtils.isNotBlank(bo.getCardNo()), SysCard::getCardNo, bo.getCardNo());
        lqw.eq(bo.getExpireAt() != null, SysCard::getExpireAt, bo.getExpireAt());
        lqw.eq(StringUtils.isNotBlank(bo.getCode()), SysCard::getCode, bo.getCode());
        lqw.isNull(SysCard::getDeletedAt);
        return lqw;
    }

    /**
     * 新增信用卡
     */
    @Override
    public Boolean insertByBo(SysCardBo bo) {
        SysCard add = BeanUtil.toBean(bo, SysCard.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改信用卡
     */
    @Override
    public Boolean updateByBo(SysCardBo bo) {
        SysCard update = BeanUtil.toBean(bo, SysCard.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(SysCard entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除信用卡
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }

        ids.forEach((id)->{
            SysCardBo bo = new SysCardBo();
            bo.setId(id);
            bo.setDeletedAt(new Date());
            this.updateByBo(bo);
        });
        return true;
        //return baseMapper.deleteBatchIds(ids) > 0;
    }
}
