package org.huantian.huan_software_park_manage.pojo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.huantian.huan_software_park_manage.pojo.Status;

@Data
public class ApplicationUpdateDTO {
    @NotNull(message = "ID不能为空")
    private Integer id;

    @NotNull(message = "归属列表不能为空")
    private Integer listId;

    @NotBlank(message = "软件名称不能为空")
    @Size(max = 100, message = "软件名称长度不能超过100")
    private String label;

    @Size(max = 1000, message = "介绍长度不能超过1000")
    private String introduce;

    @NotBlank(message = "软件内容不能为空")
    private String content;

    @NotBlank(message = "下载链接不能为空")
    @Size(max = 1000, message = "下载链接长度不能超过1000")
    private String link;

    private Status status;

    @Size(max = 1000, message = "备注长度不能超过1000")
    private String remarks;
}
