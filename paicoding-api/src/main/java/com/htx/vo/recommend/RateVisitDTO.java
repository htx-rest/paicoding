package com.htx.vo.recommend;

import lombok.Data;

/**
 * 微信搜索「二哈学习之路」
 * 资源的访问、评分信息
 * @author htx
 * @date 2024/8/21 20:41
 */
@Data
public class RateVisitDTO {

    /**
     * 查看次数
     */
    private Integer visit;

    /**
     * 下载次数
     */
    private Integer download;

    /**
     * 评分, 浮点数，string方式返回，避免精度问题
     */
    private String rate;

    public RateVisitDTO() {
        visit = 0;
        download = 0;
        rate = "8";
    }

    public void incrVisit() {
        visit += 1;
    }

    public void incrDownload() {
        download += 1;
    }
}
