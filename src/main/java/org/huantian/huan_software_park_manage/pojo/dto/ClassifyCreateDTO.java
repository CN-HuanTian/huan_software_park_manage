package org.huantian.huan_software_park_manage.pojo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClassifyCreateDTO {
    @NotBlank(message = "分类名称不能为空")
    @Size(max = 10, message = "分类名称长度不能超过10")
    private String label;

    @Size(max = 100, message = "图片URL长度不能超过100")
    private String img;

    @Size(max = 1000, message = "备注长度不能超过1000")
    private String remarks;
}
