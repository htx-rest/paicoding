package com.htx.vo.user.wx;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.ToString;

/**
 * 微信搜索「二哈学习之路」
 * 返回的数据结构体
 * @author htx
 * @date 2024/8/21 20:30
 */
@Data
@ToString(callSuper = true)
@JacksonXmlRootElement(localName = "xml")
public class WxTxtMsgResVo extends BaseWxMsgResVo {
    @JacksonXmlProperty(localName = "Content")
    private String content;

    public WxTxtMsgResVo() {
        setMsgType("text");
    }
}
