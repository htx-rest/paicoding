package com.htx.vo.user.wx;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 * 返回的数据结构体
 * @author htx
 * @date 2024/8/21 20:28
 */
@Data
@ToString(callSuper = true)
@JacksonXmlRootElement(localName = "xml")
public class WxImgTxtMsgResVo extends BaseWxMsgResVo {
    @JacksonXmlProperty(localName = "ArticleCount")
    private Integer articleCount;
    @JacksonXmlElementWrapper(localName = "Articles")
    @JacksonXmlProperty(localName = "item")
    private List<WxImgTxtItemVo> articles;

    public WxImgTxtMsgResVo() {
        setMsgType("news");
    }
}
