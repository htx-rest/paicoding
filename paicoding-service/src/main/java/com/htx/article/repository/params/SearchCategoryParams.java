package com.htx.article.repository.params;

import com.htx.vo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/22 20:44
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SearchCategoryParams extends PageParam {
    // 类目名称
    private String category;
}
