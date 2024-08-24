package com.htx.user.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.htx.vo.PageParam;
import com.htx.vo.user.dto.ArticleFootCountDTO;
import com.htx.vo.user.dto.SimpleUserInfoDTO;
import com.htx.vo.user.dto.UserFootStatisticDTO;
import com.htx.user.repository.entity.UserFootDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 * 用户足迹mapper接口
 * @author htx
 * @date 2024/8/24 15:18
 */
public interface UserFootMapper extends BaseMapper<UserFootDO> {

    /**
     * 查询文章计数信息
     *
     * @param articleId
     * @return
     */
    ArticleFootCountDTO countArticleByArticleId(@Param("articleId") Long articleId);

    /**
     * 查询作者的文章统计
     *
     * @param author
     * @return
     */
    ArticleFootCountDTO countArticleByUserId(@Param("userId") Long author);

    /**
     * 查询作者的所有文章阅读计数
     *
     * @param author
     * @return
     */
    Integer countArticleReadsByUserId(@Param("userId") Long author);

    /**
     * 查询用户收藏的文章列表
     *
     * @param userId
     * @param pageParam
     * @return
     */
    List<Long> listCollectedArticlesByUserId(@Param("userId") Long userId, @Param("pageParam") PageParam pageParam);


    /**
     * 查询用户阅读的文章列表
     *
     * @param userId
     * @param pageParam
     * @return
     */
    List<Long> listReadArticleByUserId(@Param("userId") Long userId, @Param("pageParam") PageParam pageParam);

    /**
     * 查询文章的点赞列表
     *
     * @param documentId
     * @param type
     * @param size
     * @return
     */
    List<SimpleUserInfoDTO> listSimpleUserInfosByArticleId(@Param("documentId") Long documentId,
                                                           @Param("type") Integer type,
                                                           @Param("size") int size);


    UserFootStatisticDTO getFootCount();
}