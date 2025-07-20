package org.huantian.huan_software_park_manage.pojo.po;

import lombok.Data;
import org.huantian.huan_software_park_manage.pojo.Status;

import java.time.LocalDateTime;

@Data
public class ApplicationPO {
    private Integer id;
    private Integer classifyId;
    private Integer groupId;
    private Integer listId;
    private String label;
    private String introduce;
    private String content;
    private String link;
    private Status status;  // 使用枚举类型
    private String remarks;
    private Integer reading;
    private String author;
    private LocalDateTime updateTime;
    private LocalDateTime createTime;
}
