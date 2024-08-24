package com.htx.article.service;

import com.htx.vo.PageParam;
import com.htx.vo.PageVo;
import com.htx.vo.article.dto.TagDTO;

/**
 * 微信搜索「二哈学习之路」
 * 标签Service
 * @author htx
 * @date 2024/8/22 21:15
 */
public interface TagService {

    PageVo<TagDTO> queryTags(String key, PageParam pageParam);

    Long queryTagId(String tag);
}
