package com.htx.article.repository.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htx.article.repository.entity.ColumnArticleDO;
import com.htx.article.repository.mapper.ColumnArticleMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/22 21:02
 */
@Repository
public class ColumnArticleDao extends ServiceImpl<ColumnArticleMapper, ColumnArticleDO> {
    @Resource
    private ColumnArticleMapper columnArticleMapper;

    /**
     * 返回专栏最大更新章节数
     *
     * @param columnId
     * @return 专栏内无文章时，返回0；否则返回当前最大的章节数
     */
    public int selectMaxSection(Long columnId) {
        return columnArticleMapper.selectMaxSection(columnId);
    }

    /**
     * 根据文章id，查询再所属的专栏信息
     * fixme: 如果一篇文章，在多个专栏内，就会有问题
     *
     * @param articleId
     * @return
     */
    public ColumnArticleDO selectColumnArticleByArticleId(Long articleId) {
        List<ColumnArticleDO> list = lambdaQuery()
                .eq(ColumnArticleDO::getArticleId, articleId)
                .list();
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    public ColumnArticleDO selectBySection(Long columnId, Integer sort) {
        return lambdaQuery()
                .eq(ColumnArticleDO::getColumnId, columnId)
                .eq(ColumnArticleDO::getSection, sort)
                .one();
    }
}
