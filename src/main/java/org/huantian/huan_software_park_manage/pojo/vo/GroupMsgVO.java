package org.huantian.huan_software_park_manage.pojo.vo;

import lombok.Data;
import org.huantian.huan_software_park_manage.pojo.Status;

import java.time.LocalDateTime;


@Data
public class GroupMsgVO {
    private Integer id;
    private Integer classifyId;
    private String label;
}
