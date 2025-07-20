package org.huantian.huan_software_park_manage.pojo.vo;

import lombok.Data;
import org.huantian.huan_software_park_manage.pojo.Status;

import java.time.LocalDateTime;


@Data
public class GroupVO {
    private Integer id;
    private Integer classifyId;
    private String label;
    private Status status;  // 使用枚举类型
    private String remarks;
    private LocalDateTime updateTime;
    private LocalDateTime createTime;
}
