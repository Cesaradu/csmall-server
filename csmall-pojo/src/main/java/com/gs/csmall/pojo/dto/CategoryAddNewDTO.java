package com.gs.csmall.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
public class CategoryAddNewDTO implements Serializable {
    /**
     * 验证请求参数失败的描述文本前缀
     */
    private static final String VALIDATE_MESSAGE_PREFIX = "新增类别失败，";

    @ApiModelProperty(value = "类别名称", example = "家电", required = true)
    @NotNull(message = "增加类别失败，必须提交类别名称！")
    @Pattern(regexp = ".{2,16}", message = "增加类别失败，类别名称必须是2~16字符！")
    private String name;

    @ApiModelProperty(value = "父级类别id，如果是一级分类，则此属性值为0", example = "10", required = true)
    @NotNull(message = "增加类别失败，必须提交父级类别！")
    private Long parentId;

    @ApiModelProperty(value = "类别关键词", example = "家电,家用电器", required = true)
    @NotNull(message = "增加类别失败，必须提交类别关键词！")
    private String keywords;

    @ApiModelProperty(value = "自定义排序序号", example = "1", required = true)
    @NotNull(message = "增加类别失败，必须提交自定义排序序号！")
    @Range(max = 99, message = "增加类别失败，自定义排序序号必须是0~99之间的值！")
    private Integer sort;

    @ApiModelProperty(value = "图标的URL", example = "http://www.tedu.cn/logo.png", required = true)
    @NotNull(message = "增加类别失败，必须提交图标！")
    private String icon;

    @ApiModelProperty(value = "是否启用，1=启用，0=禁用", example = "1", required = true)
    @NotNull(message = "增加类别失败，必须选择是否启用！")
    @Range(max = 1)
    private Integer enable;

    @ApiModelProperty(value = "是否显示在导航栏，1=显示，0=不显示", example = "1", required = true)
    @NotNull(message = "增加类别失败，必须选择是否显示在导航栏！")
    @Range(max = 1)
    private Integer display;
}
