package com.htx.vo.user;

import lombok.Data;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/21 20:15
 */
@Data
public class SearchZsxqUserReq {
    // 用户昵称
    private String name;
    // 星球编号
    private String starNumber;
    // 用户登录名
    private String userCode;

    private Integer state;
    // 分页
    private Long pageNumber;
    private Long pageSize;
}

