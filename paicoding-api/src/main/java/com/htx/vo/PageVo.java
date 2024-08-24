package com.htx.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/22 20:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageVo<T> {

    private List<T> list;

    private long pageSize;

    private long pageNum;

    private long pageTotal;

    private long total;

    /**
     * 构造方法，int参数，需去除
     *
     * @param list
     * @param pageSize
     * @param pageNum
     * @param total
     * @return
     */
    @Deprecated
    public PageVo(List<T> list, int pageSize, int pageNum, int total) {
        this.list = list;
        this.total = total;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.pageTotal = (int) Math.ceil((double) total / pageSize);
    }

    /**
     * 构造PageVO
     *
     * @param list
     * @param pageSize
     * @param pageNum
     * @param total
     * @return
     */
    public PageVo(List<T> list, long pageSize, long pageNum, long total) {
        this.list = list;
        this.total = total;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.pageTotal = (long) Math.ceil((double) total / pageSize);
    }

    /**
     * 创建PageVO
     *
     * @param list
     * @param pageSize
     * @param pageNum
     * @param total
     * @return PageVo<T>
     */
    @Deprecated
    public static <T> PageVo<T> build(List<T> list, int pageSize, int pageNum, int total) {
        return new PageVo<>(list, pageSize, pageNum, total);
    }

    /**
     * 创建PageVO
     *
     * @param list
     * @param pageSize
     * @param pageNum
     * @param total
     * @return PageVo<T>
     */
    public static <T> PageVo<T> build(List<T> list, long pageSize, long pageNum, long total) {
        return new PageVo<>(list, pageSize, pageNum, total);
    }
}
