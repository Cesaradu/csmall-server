package com.gs.csmall.pojo.dto;

import com.gs.csmall.pojo.valid.CategoryRegExpression;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
public class CategoryAddNewDTO implements CategoryRegExpression, Serializable {
    /**
     * 验证请求参数失败的描述文本前缀
     */
    private static final String VALIDATE_MESSAGE_PREFIX = "新增类别失败，";

    @ApiModelProperty(value = "类别名称", example = "家电", required = true)
    @NotNull(message = VALIDATE_MESSAGE_PREFIX + "请填写名称！")
    @Pattern(regexp = REGEXP_NAME, message = VALIDATE_MESSAGE_PREFIX + MESSAGE_NAME)
    private String name;

    @ApiModelProperty(value = "父级类别id，如果是一级分类，则此属性值为0", example = "10", required = true)
    @NotNull(message = VALIDATE_MESSAGE_PREFIX + "必须提交父级类别！")
    @Min(value = 0, message = VALIDATE_MESSAGE_PREFIX + "选择的父级类别的数据格式错误！")
    private Long parentId;

    @ApiModelProperty(value = "类别关键词", example = "家电,家用电器", required = true)
    @NotNull(message = VALIDATE_MESSAGE_PREFIX + "请填写关键词列表！")
    @Pattern(regexp = REGEXP_KEYWORDS, message = VALIDATE_MESSAGE_PREFIX + MESSAGE_KEYWORDS)
    private String keywords;

    @ApiModelProperty(value = "自定义排序序号", example = "1", required = true)
    @NotNull(message = VALIDATE_MESSAGE_PREFIX + "必须提交自定义排序序号！")
    @Range(max = 99, message = VALIDATE_MESSAGE_PREFIX + MESSAGE_SORT)
    private Integer sort;

    @ApiModelProperty(value = "图标的URL", example = "http://www.tedu.cn/logo.png", required = true)
    @NotNull(message = VALIDATE_MESSAGE_PREFIX + "请输入图标图片的URL！")
    @Pattern(regexp = REGEXP_ICON, message = VALIDATE_MESSAGE_PREFIX + MESSAGE_ICON)
    private String icon;

    @ApiModelProperty(value = "是否启用，1=启用，0=禁用", example = "1", required = true)
    @NotNull(message = VALIDATE_MESSAGE_PREFIX + "请选择是否启用！")
    @Range(max = 1, message = VALIDATE_MESSAGE_PREFIX + MESSAGE_ENABLE)
    private Integer enable;

    @ApiModelProperty(value = "是否显示在导航栏，1=显示，0=不显示", example = "1", required = true)
    @NotNull(message = VALIDATE_MESSAGE_PREFIX + "请选择是否显示在导航栏！")
    @Range(max = 1, message = VALIDATE_MESSAGE_PREFIX + "选择的是否显示在导航栏的数据格式错误！")
    private Integer display;
}
