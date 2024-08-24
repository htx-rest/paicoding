package com.htx.common;

import com.htx.vo.ResVo;
import com.htx.permission.Permission;
import com.htx.permission.UserRole;
import com.htx.config.service.DictCommonService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 微信搜索「二哈学习之路」
 * 通用
 * @author htx
 * @date 2024/8/24 23:19
 */
@RestController
@Slf4j
@Permission(role = UserRole.LOGIN)
@Api(value = "通用接口管理控制器", tags = "全局设置")
@RequestMapping(path = {"common/","api/admin/common/", "admin/common/"})
public class DictCommonController {

    @Autowired
    private DictCommonService dictCommonService;

    @ResponseBody
    @GetMapping(path = "/dict")
    public ResVo<Map<String, Object>> list() {
        log.debug("获取字典");
        Map<String, Object> bannerDTOPageVo = dictCommonService.getDict();
        return ResVo.ok(bannerDTOPageVo);
    }
}