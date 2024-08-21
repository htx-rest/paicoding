package com.htx.event;

import com.htx.enums.ArticleEventEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/20 22:52
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class ArticleMsgEvent<T> extends ApplicationEvent {

    private ArticleEventEnum type;

    private T content;


    public ArticleMsgEvent(Object source, ArticleEventEnum type, T content) {
        super(source);
        this.type = type;
        this.content = content;
    }
}
