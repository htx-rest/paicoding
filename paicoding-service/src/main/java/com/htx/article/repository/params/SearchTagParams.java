package com.htx.article.repository.params;

import com.htx.vo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/22 20:46
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SearchTagParams extends PageParam {
    // 标签名称
    private String tag;
}
