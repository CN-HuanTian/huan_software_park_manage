package org.huantian.huan_software_park_manage.pojo.vo;

import lombok.Data;
import org.huantian.huan_software_park_manage.pojo.Status;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class ClassifyVO {
    private Integer id;
    private String label;
    private String img;
    private Status status;          // 返回字符串形式
    private String remarks;
    private Date updateTime;
    private LocalDateTime createTime;
}
