package com.htx.article.service;

import com.htx.vo.PageVo;
import com.htx.vo.article.SearchTagReq;
import com.htx.vo.article.TagReq;
import com.htx.vo.article.dto.TagDTO;

/**
 * 微信搜索「二哈学习之路」
 * 标签后台接口
 * @author htx
 * @date 2024/8/22 21:16
 */
public interface TagSettingService {

    void saveTag(TagReq tagReq);

    void deleteTag(Integer tagId);

    void operateTag(Integer tagId, Integer pushStatus);

    /**
     * 获取tag列表
     *
     * @param req
     * @return
     */
    PageVo<TagDTO> getTagList(SearchTagReq req);

    TagDTO getTagById(Long tagId);
}
