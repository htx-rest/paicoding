package com.htx.vo.user.wx;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

/**
 * 微信搜索「二哈学习之路」
 * 返回的数据结构体
 * @author htx
 * @date 2024/8/21 20:28
 */
@Data
@JacksonXmlRootElement(localName = "item")
public class WxImgTxtItemVo {

    @JacksonXmlProperty(localName = "Title")
    private String title;
    @JacksonXmlProperty(localName = "Description")
    private String description;
    @JacksonXmlProperty(localName = "PicUrl")
    private String picUrl;
    @JacksonXmlProperty(localName = "Url")
    private String url;
}
