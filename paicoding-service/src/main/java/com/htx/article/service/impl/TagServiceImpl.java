package com.htx.article.service.impl;

import com.htx.vo.PageParam;
import com.htx.vo.PageVo;
import com.htx.vo.article.dto.TagDTO;
import com.htx.article.repository.dao.TagDao;
import com.htx.article.service.TagService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 * 标签Service
 * @author htx
 * @date 2024/8/24 14:45
 */
@Service
public class TagServiceImpl implements TagService {
    private final TagDao tagDao;

    public TagServiceImpl(TagDao tagDao) {
        this.tagDao = tagDao;
    }

    @Override
    public PageVo<TagDTO> queryTags(String key, PageParam pageParam) {
        List<TagDTO> tagDTOS = tagDao.listOnlineTag(key, pageParam);
        Integer totalCount = tagDao.countOnlineTag(key);
        return PageVo.build(tagDTOS, pageParam.getPageSize(), pageParam.getPageNum(), totalCount);
    }

    @Override
    public Long queryTagId(String tag) {
        return tagDao.selectTagIdByTag(tag);
    }
}
