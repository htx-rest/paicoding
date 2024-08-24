package com.htx.image.service;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/24 14:50
 */
public interface ImageService {
    /**
     * 图片转存
     * @param content
     * @return
     */
    String mdImgReplace(String content);


    /**
     * 外网图片转存
     *
     * @param img
     * @return
     */
    String saveImg(String img);

    /**
     * 保存图片
     *
     * @param request
     * @return
     */
    String saveImg(HttpServletRequest request);
}
