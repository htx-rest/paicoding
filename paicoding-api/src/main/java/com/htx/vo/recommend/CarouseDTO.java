package com.htx.vo.recommend;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/21 20:40
 */
@Data
@Accessors(chain = true)
public class CarouseDTO implements Serializable {

    private static final long serialVersionUID = 1048555496974144842L;
    /**
     * 说明
     */
    private String name;
    /**
     * 图片地址
     */
    private String imgUrl;
    /**
     * 跳转地址
     */
    private String actionUrl;
}
