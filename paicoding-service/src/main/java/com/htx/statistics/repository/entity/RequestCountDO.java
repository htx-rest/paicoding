package com.htx.statistics.repository.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.htx.entity.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 微信搜索「二哈学习之路」
 * 请求计数表
 * @author htx
 * @date 2024/8/24 15:58
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("request_count")
public class RequestCountDO extends BaseDO {

    private static final long serialVersionUID = 1L;

    /**
     * 机器IP
     */
    private String host;

    /**
     * 访问计数
     */
    private Integer cnt;

    /**
     * 当前日期
     */
    private Date date;
}
