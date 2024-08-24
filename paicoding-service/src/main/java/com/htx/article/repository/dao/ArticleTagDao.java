package com.htx.article.repository.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htx.enums.YesOrNoEnum;
import com.htx.vo.article.dto.TagDTO;
import com.htx.article.repository.entity.ArticleTagDO;
import com.htx.article.repository.mapper.ArticleTagMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * 微信搜索「二哈学习之路」
 * 文章标签映mapper接口
 * @author htx
 * @date 2024/8/22 21:00
 */
@Repository
public class ArticleTagDao extends ServiceImpl<ArticleTagMapper, ArticleTagDO> {


    /**
     * 批量保存
     *
     * @param articleId
     * @param tags
     */
    public void batchSave(Long articleId, Collection<Long> tags) {
        List<ArticleTagDO> insertList = new ArrayList<>(tags.size());
        tags.forEach(s -> {
            ArticleTagDO tag = new ArticleTagDO();
            tag.setTagId(s);
            tag.setArticleId(articleId);
            tag.setDeleted(YesOrNoEnum.NO.getCode());
            insertList.add(tag);
        });
        saveBatch(insertList);
    }


    /**
     * 更新文章标签
     * 1. 原来有，新的没有；则删除旧的
     * 2. 原来有，新的改变，则替换旧的
     * 3. 原来没有，新的有，则插入
     *
     * @param articleId
     * @param newTags
     */
    public void updateTags(Long articleId, Set<Long> newTags) {
        List<ArticleTagDO> dbTags = listArticleTags(articleId);
        // 在旧的里面，不在新的里面的标签，设置为删除
        List<Long> toDeleted = new ArrayList<>();
        dbTags.forEach(tag -> {
            if (!newTags.contains(tag.getTagId())) {
                toDeleted.add(tag.getId());
            } else {
                // 移除已经存在的记录
                newTags.remove(tag.getTagId());
            }
        });
        if (!toDeleted.isEmpty()) {
            baseMapper.deleteBatchIds(toDeleted);
        }

        if (!newTags.isEmpty()) {
            batchSave(articleId, newTags);
        }
    }


    /**
     * 查询文章标签
     *
     * @param articleId
     * @return
     */
    public List<TagDTO> queryArticleTagDetails(Long articleId) {
        return baseMapper.listArticleTagDetails(articleId);
    }


    public List<ArticleTagDO> listArticleTags(@Param("articleId") Long articleId) {
        return lambdaQuery().eq(ArticleTagDO::getArticleId, articleId).eq(ArticleTagDO::getDeleted, YesOrNoEnum.NO.getCode()).list();
    }
}
