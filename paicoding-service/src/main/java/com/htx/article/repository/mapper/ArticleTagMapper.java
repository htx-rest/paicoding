package com.htx.article.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.htx.vo.article.dto.TagDTO;
import com.htx.article.repository.entity.ArticleTagDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 * 文章标签映mapper接口
 * @author htx
 * @date 2024/8/22 20:50
 */
public interface ArticleTagMapper extends BaseMapper<ArticleTagDO> {

    /**
     * 查询文章标签
     *
     * @param articleId
     * @return
     */
    List<TagDTO> listArticleTagDetails(@Param("articleId") Long articleId);

}
