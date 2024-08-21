package com.htx.vo.user;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/21 20:18
 */
@Data
public class ZsxqUserBatchOperateReq implements Serializable {
    // ids
    private List<Long> ids;
    // 状态
    private Integer status;
}
