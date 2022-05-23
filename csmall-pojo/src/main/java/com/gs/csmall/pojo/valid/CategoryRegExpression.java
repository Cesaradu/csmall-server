package com.gs.csmall.pojo.valid;

/**
 * <p>类别数据的表达式接口，定义了相关的正则表达式和提示文本</p>
 *
 * <p>使用接口主要是为了便于定义常量，并利于相关类实现，以简化在类中使用常量的语法</p>
 */
public interface CategoryRegExpression extends com.gs.csmall.pojo.valid.RegExpression {

    String REGEXP_NAME = ".{2,16}";
    String MESSAGE_NAME = "名称必须由2~16字符组成！";

    String REGEXP_KEYWORDS = ".{0,255}";
    String MESSAGE_KEYWORDS = "关键词列表的长度不得超过255字符！";

    String REGEXP_ICON = ".{0,255}";
    String MESSAGE_ICON = "图标图片的URL的长度不得超过255字符！";

}