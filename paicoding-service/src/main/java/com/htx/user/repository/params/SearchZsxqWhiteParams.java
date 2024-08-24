package com.htx.user.repository.params;

import com.htx.vo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/24 15:16
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SearchZsxqWhiteParams extends PageParam {

    /**
     * 审核状态
     */
    private Integer status;

    /**
     * 星球编号
     */
    private String starNumber;

    /**
     * 登录用户名
     */
    private String name;

    /**
     * 用户编号
     */
    private String userCode;

}
