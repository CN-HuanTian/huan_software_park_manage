package org.huantian.huan_software_park_manage.pojo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.huantian.huan_software_park_manage.pojo.Status;

@Data
public class ListUpdateDTO {
    @NotNull(message = "列表ID不能为空")
    private Integer id;

    @NotNull(message = "父组不能为空")
    private Integer groupId;

    @NotBlank(message = "分组名称不能为空")
    @Size(max = 10, message = "分组名称长度不能超过10")
    private String label;

    @Size(max = 100, message = "图片URL长度不能超过100")
    private String img;

    private Status status;

    @Size(max = 1000, message = "介绍长度不能超过1000")
    private String introduce;

    @Size(max = 1000, message = "备注长度不能超过1000")
    private String remarks;
}
