package com.htx.vo.user.wx;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

/**
 * 微信搜索「二哈学习之路」
 * 简单文本请求
 * @author htx
 * @date 2024/8/21 20:29
 */
@Data
@JacksonXmlRootElement(localName = "xml")
public class WxTxtMsgReqVo {
    @JacksonXmlProperty(localName = "ToUserName")
    private String toUserName;
    @JacksonXmlProperty(localName = "FromUserName")
    private String fromUserName;
    @JacksonXmlProperty(localName = "CreateTime")
    private Long createTime;
    @JacksonXmlProperty(localName = "MsgType")
    private String msgType;
    @JacksonXmlProperty(localName = "Event")
    private String event;
    @JacksonXmlProperty(localName = "EventKey")
    private String eventKey;
    @JacksonXmlProperty(localName = "Ticket")
    private String ticket;
    @JacksonXmlProperty(localName = "Content")
    private String content;
    @JacksonXmlProperty(localName = "MsgId")
    private String msgId;
    @JacksonXmlProperty(localName = "MsgDataId")
    private String msgDataId;
    @JacksonXmlProperty(localName = "Idx")
    private String idx;
}
