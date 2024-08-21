package com.htx.vo.article.dto;

import com.htx.enums.PushStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/20 23:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO implements Serializable {
    public static final String DEFAULT_TOTAL_CATEGORY = "全部";
    public static final CategoryDTO DEFAULT_CATEGORY = new CategoryDTO(0L, "全部");

    private static final long serialVersionUID = 8272116638231812207L;
    public static CategoryDTO EMPTY = new CategoryDTO(-1L, "illegal");

    private Long categoryId;

    private String category;

    private Integer rank;

    private Integer status;

    private Boolean selected;

    public CategoryDTO(Long categoryId, String category) {
        this(categoryId, category, 0);
    }

    public CategoryDTO(Long categoryId, String category, Integer rank) {
        this.categoryId = categoryId;
        this.category = category;
        this.status = PushStatusEnum.ONLINE.getCode();
        this.rank = rank;
        this.selected = false;
    }
}
