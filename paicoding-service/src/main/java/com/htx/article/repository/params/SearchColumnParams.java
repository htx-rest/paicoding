package com.htx.article.repository.params;

import com.htx.vo.PageParam;
import lombok.Data;

/**
 * 微信搜索「二哈学习之路」
 * 专栏查询
 * @author htx
 * @date 2024/8/22 20:46
 */
@Data
public class SearchColumnParams extends PageParam {

    /**
     * 专栏名称
     */
    private String column;
}
