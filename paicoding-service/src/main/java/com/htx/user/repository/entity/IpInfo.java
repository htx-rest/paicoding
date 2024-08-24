package com.htx.user.repository.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 微信搜索「二哈学习之路」
 * ip信息
 * @author htx
 * @date 2024/8/24 15:04
 */
@Data
public class IpInfo implements Serializable {
    private static final long serialVersionUID = -4612222921661930429L;

    private String firstIp;

    private String firstRegion;

    private String latestIp;

    private String latestRegion;
}
