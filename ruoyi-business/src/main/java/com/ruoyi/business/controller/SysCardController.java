package com.ruoyi.business.controller;

import java.util.List;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import lombok.RequiredArgsConstructor;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import com.ruoyi.common.annotation.RepeatSubmit;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.core.validate.QueryGroup;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.business.domain.vo.SysCardVo;
import com.ruoyi.business.domain.bo.SysCardBo;
import com.ruoyi.business.service.ISysCardService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 信用卡
 *
 * @author ruoyi
 * @date 2023-01-13
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/business/card")
public class SysCardController extends BaseController {

    private final ISysCardService iSysCardService;

    /**
     * 查询信用卡列表
     */
    @SaCheckPermission("business:card:list")
    @GetMapping("/list")
    public TableDataInfo<SysCardVo> list(SysCardBo bo, PageQuery pageQuery) {
        return iSysCardService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出信用卡列表
     */
    @SaCheckPermission("business:card:export")
    @Log(title = "信用卡", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(SysCardBo bo, HttpServletResponse response) {
        List<SysCardVo> list = iSysCardService.queryList(bo);
        ExcelUtil.exportExcel(list, "信用卡", SysCardVo.class, response);
    }

    /**
     * 获取信用卡详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("business:card:query")
    @GetMapping("/{id}")
    public R<SysCardVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(iSysCardService.queryById(id));
    }

    /**
     * 新增信用卡
     */
    @SaCheckPermission("business:card:add")
    @Log(title = "信用卡", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody SysCardBo bo) {
        return toAjax(iSysCardService.insertByBo(bo));
    }

    /**
     * 修改信用卡
     */
    @SaCheckPermission("business:card:edit")
    @Log(title = "信用卡", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody SysCardBo bo) {
        return toAjax(iSysCardService.updateByBo(bo));
    }

    /**
     * 删除信用卡
     *
     * @param ids 主键串
     */
    @SaCheckPermission("business:card:remove")
    @Log(title = "信用卡", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(iSysCardService.deleteWithValidByIds(Arrays.asList(ids), true));
    }
}
