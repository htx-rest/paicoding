package com.htx.article.service.impl;

import com.htx.exception.ExceptionUtil;
import com.htx.vo.PageListVo;
import com.htx.vo.PageParam;
import com.htx.vo.article.dto.ColumnDTO;
import com.htx.vo.article.dto.SimpleArticleDTO;
import com.htx.vo.constants.StatusEnum;
import com.htx.vo.user.dto.BaseUserInfoDTO;
import com.htx.vo.user.dto.ColumnFootCountDTO;
import com.htx.article.conveter.ColumnConvert;
import com.htx.article.repository.dao.ArticleDao;
import com.htx.article.repository.dao.ColumnArticleDao;
import com.htx.article.repository.dao.ColumnDao;
import com.htx.article.repository.entity.ColumnArticleDO;
import com.htx.article.repository.entity.ColumnInfoDO;
import com.htx.article.service.ColumnService;
import com.htx.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/24 14:41
 */
@Service
public class ColumnServiceImpl implements ColumnService {
    @Autowired
    private ColumnDao columnDao;
    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private ColumnArticleDao columnArticleDao;

    @Autowired
    private UserService userService;

    @Override
    public ColumnArticleDO getColumnArticleRelation(Long articleId) {
        return columnArticleDao.selectColumnArticleByArticleId(articleId);
    }

    /**
     * 专栏列表
     *
     * @return
     */
    @Override
    public PageListVo<ColumnDTO> listColumn(PageParam pageParam) {
        List<ColumnInfoDO> columnList = columnDao.listOnlineColumns(pageParam);
        List<ColumnDTO> result = columnList.stream().map(this::buildColumnInfo).collect(Collectors.toList());
        return PageListVo.newVo(result, pageParam.getPageSize());
    }

    @Override
    public ColumnDTO queryBasicColumnInfo(Long columnId) {
        // 查找专栏信息
        ColumnInfoDO column = columnDao.getById(columnId);
        if (column == null) {
            throw ExceptionUtil.of(StatusEnum.COLUMN_NOT_EXISTS, columnId);
        }
        return ColumnConvert.toDto(column);
    }

    @Override
    public ColumnDTO queryColumnInfo(Long columnId) {
        return buildColumnInfo(queryBasicColumnInfo(columnId));
    }

    private ColumnDTO buildColumnInfo(ColumnInfoDO info) {
        return buildColumnInfo(ColumnConvert.toDto(info));
    }

    /**
     * 构建专栏详情信息
     *
     * @param dto
     * @return
     */
    private ColumnDTO buildColumnInfo(ColumnDTO dto) {
        // 补齐专栏对应的用户信息
        BaseUserInfoDTO user = userService.queryBasicUserInfo(dto.getAuthor());
        dto.setAuthorName(user.getUserName());
        dto.setAuthorAvatar(user.getPhoto());
        dto.setAuthorProfile(user.getProfile());

        // 统计计数
        ColumnFootCountDTO countDTO = new ColumnFootCountDTO();
        // 更新文章数
        countDTO.setArticleCount(columnDao.countColumnArticles(dto.getColumnId()));
        // 专栏阅读人数
        countDTO.setReadCount(columnDao.countColumnReadPeoples(dto.getColumnId()));
        // 总的章节数
        countDTO.setTotalNums(dto.getNums());
        dto.setCount(countDTO);
        return dto;
    }


    @Override
    public ColumnArticleDO queryColumnArticle(long columnId, Integer section) {
        ColumnArticleDO article = columnDao.getColumnArticleId(columnId, section);
        if (article == null) {
            throw ExceptionUtil.of(StatusEnum.ARTICLE_NOT_EXISTS, section);
        }
        return article;
    }

    @Override
    public List<SimpleArticleDTO> queryColumnArticles(long columnId) {
        return columnDao.listColumnArticles(columnId);
    }

    @Override
    public Long getTutorialCount() {
        return this.columnDao.countColumnArticles();
    }

}
