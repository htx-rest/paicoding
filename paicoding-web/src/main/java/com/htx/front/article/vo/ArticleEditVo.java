package com.htx.front.article.vo;

import com.htx.vo.article.dto.ArticleDTO;
import com.htx.vo.article.dto.CategoryDTO;
import com.htx.vo.article.dto.TagDTO;
import lombok.Data;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/24 22:38
 */
@Data
public class ArticleEditVo {

    private ArticleDTO article;

    private List<CategoryDTO> categories;

    private List<TagDTO> tags;

}
