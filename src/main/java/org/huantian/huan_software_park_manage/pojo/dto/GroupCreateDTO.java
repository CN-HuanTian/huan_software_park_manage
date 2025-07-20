package org.huantian.huan_software_park_manage.pojo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class GroupCreateDTO {

    @NotNull(message = "父分类不能为空")
    private Integer classifyId;

    @NotBlank(message = "分组名称不能为空")
    @Size(max = 10, message = "分组名称长度不能超过10")
    private String label;

    @Size(max = 1000, message = "备注长度不能超过1000")
    private String remarks;
}
