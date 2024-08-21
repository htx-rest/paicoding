package com.htx.event;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

/**
 * 微信搜索「二哈学习之路」
 * 配置变更消息事件
 * @author htx
 * @date 2024/8/20 22:53
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class ConfigRefreshEvent extends ApplicationEvent {
    private String key;
    private String val;


    public ConfigRefreshEvent(Object source, String key, String value) {
        super(source);
        this.key = key;
        this.val = value;
    }
}
