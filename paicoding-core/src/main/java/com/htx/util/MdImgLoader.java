package com.htx.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 微信搜索「二哈学习之路」
 * markdown文本中的图片识别
 * @author htx
 * @date 2024/8/21 21:28
 */
public class MdImgLoader {
    private static Pattern IMG_PATTERN = Pattern.compile("!\\[(.*?)\\]\\((.*?)\\)");

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MdImg {
        /**
         * 原始文本
         */
        private String origin;
        /**
         * 图片描述
         */
        private String desc;
        /**
         * 图片地址
         */
        private String url;
    }

    public static List<MdImg> loadImgs(String content) {
        Matcher matcher = IMG_PATTERN.matcher(content);
        List<MdImg> list = new ArrayList<>();
        while (matcher.find()) {
            list.add(new MdImg(matcher.group(0), matcher.group(1), matcher.group(2)));
        }
        return list;
    }
}
