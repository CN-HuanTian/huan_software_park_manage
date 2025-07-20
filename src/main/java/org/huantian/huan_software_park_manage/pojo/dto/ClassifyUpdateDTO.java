package org.huantian.huan_software_park_manage.pojo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.huantian.huan_software_park_manage.pojo.Status;

@Data
public class ClassifyUpdateDTO {
    @NotNull(message = "分类ID不能为空")
    private Integer id;

    @Size(max = 10, message = "分类名称长度不能超过10")
    private String label;

    @Size(max = 100, message = "图片URL长度不能超过100")
    private String img;

    private Status status;

    @Size(max = 1000, message = "备注长度不能超过1000")
    private String remarks;

}
