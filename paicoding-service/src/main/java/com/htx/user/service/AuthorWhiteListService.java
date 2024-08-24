package com.htx.user.service;

import com.htx.vo.user.dto.BaseUserInfoDTO;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/24 15:23
 */
public interface AuthorWhiteListService {

    /**
     * 判断作者是否再文章发布的白名单中；
     * 这个白名单主要是用于控制作者发文章之后是否需要进行审核
     *
     * @param authorId
     * @return
     */
    boolean authorInArticleWhiteList(Long authorId);

    /**
     * 获取所有的白名单用户
     *
     * @return
     */
    List<BaseUserInfoDTO> queryAllArticleWhiteListAuthors();

    /**
     * 将用户添加到白名单中
     *
     * @param userId
     */
    void addAuthor2ArticleWhitList(Long userId);

    /**
     * 从白名单中移除用户
     *
     * @param userId
     */
    void removeAuthorFromArticleWhiteList(Long userId);

}
