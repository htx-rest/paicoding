package com.htx.vo;

import lombok.Data;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/22 20:41
 */
@Data
public class PageListVo<T> {

    /**
     * 用户列表
     */
    List<T> list;

    /**
     * 是否有更多
     */
    private Boolean hasMore;

    public static <T> PageListVo<T> emptyVo() {
        PageListVo<T> vo = new PageListVo<>();
        vo.setList(Collections.emptyList());
        vo.setHasMore(false);
        return vo;
    }

    public static <T> PageListVo<T> newVo(List<T> list, long pageSize) {
        PageListVo<T> vo = new PageListVo<>();
        vo.setList(Optional.ofNullable(list).orElse(Collections.emptyList()));
        vo.setHasMore(vo.getList().size() == pageSize);
        return vo;
    }
}
