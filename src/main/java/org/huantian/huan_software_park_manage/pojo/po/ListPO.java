package org.huantian.huan_software_park_manage.pojo.po;

import lombok.Data;
import org.huantian.huan_software_park_manage.pojo.Status;

import java.time.LocalDateTime;


@Data
public class ListPO {
    private Integer id;
    private Integer groupId;
    private String label;
    private String img;
    private String introduce;
    private Status status;  // 使用枚举类型
    private String remarks;
    private LocalDateTime updateTime;
    private LocalDateTime createTime;
}
