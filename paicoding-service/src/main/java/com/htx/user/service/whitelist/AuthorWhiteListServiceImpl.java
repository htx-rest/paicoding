package com.htx.user.service.whitelist;

import com.htx.vo.user.dto.BaseUserInfoDTO;
import com.htx.cache.RedisClient;
import com.htx.user.service.AuthorWhiteListService;
import com.htx.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/24 15:41
 */
@Service
public class AuthorWhiteListServiceImpl implements AuthorWhiteListService {
    /**
     * 实用 redis - set 来存储允许直接发文章的白名单
     */
    private static final String ARTICLE_WHITE_LIST = "auth_article_white_list";

    @Autowired
    private UserService userService;

    @Override
    public boolean authorInArticleWhiteList(Long authorId) {
        return RedisClient.sIsMember(ARTICLE_WHITE_LIST, authorId);
    }

    /**
     * 获取所有的白名单用户
     *
     * @return
     */
    @Override
    public List<BaseUserInfoDTO> queryAllArticleWhiteListAuthors() {
        Set<Long> users = RedisClient.sGetAll(ARTICLE_WHITE_LIST, Long.class);
        if (CollectionUtils.isEmpty(users)) {
            return Collections.emptyList();
        }
        List<BaseUserInfoDTO> userInfos = userService.batchQueryBasicUserInfo(users);
        return userInfos;
    }

    @Override
    public void addAuthor2ArticleWhitList(Long userId) {
        RedisClient.sPut(ARTICLE_WHITE_LIST, userId);
    }

    @Override
    public void removeAuthorFromArticleWhiteList(Long userId) {
        RedisClient.sDel(ARTICLE_WHITE_LIST, userId);
    }
}
