package com.htx.global;

import com.htx.vo.PageParam;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 微信搜索「二哈学习之路」
 * 全局属性配置
 * @author htx
 * @date 2024/8/24 21:49
 */
public class BaseViewController {
    @Autowired
    protected GlobalInitService globalInitService;

    public PageParam buildPageParam(Long page, Long size) {
        if (page <= 0) {
            page = PageParam.DEFAULT_PAGE_NUM;
        }
        if (size == null || size > PageParam.DEFAULT_PAGE_SIZE) {
            size = PageParam.DEFAULT_PAGE_SIZE;
        }
        return PageParam.newPageInstance(page, size);
    }
}
