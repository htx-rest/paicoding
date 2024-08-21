package com.htx.vo.user.dto;

import com.htx.entity.BaseDTO;
import com.htx.enums.user.UserAIStatEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/21 20:21
 */
@Data
@ApiModel("用户基础实体对象")
@Accessors(chain = true)
public class BaseUserInfoDTO extends BaseDTO {
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id", required = true)
    private Long userId;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", required = true)
    private String userName;

    /**
     * 用户角色 admin, normal
     */
    @ApiModelProperty(value = "角色", example = "ADMIN|NORMAL")
    private String role;

    /**
     * 用户图像
     */
    @ApiModelProperty(value = "用户头像")
    private String photo;
    /**
     * 个人简介
     */
    @ApiModelProperty(value = "用户简介")
    private String profile;
    /**
     * 职位
     */
    @ApiModelProperty(value = "个人职位")
    private String position;

    /**
     * 公司
     */
    @ApiModelProperty(value = "公司")
    private String company;

    /**
     * 扩展字段
     */
    @ApiModelProperty(hidden = true)
    private String extend;

    /**
     * 是否删除
     */
    @ApiModelProperty(hidden = true, value = "用户是否被删除")
    private Integer deleted;

    /**
     * 用户最后登录区域
     */
    @ApiModelProperty(value = "用户最后登录的地理位置", example = "湖北·武汉")
    private String region;

    /**
     * 星球状态
     */
    private UserAIStatEnum starStatus;
}
