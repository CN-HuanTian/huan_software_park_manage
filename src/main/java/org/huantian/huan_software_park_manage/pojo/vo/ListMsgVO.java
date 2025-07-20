package org.huantian.huan_software_park_manage.pojo.vo;

import lombok.Data;
import org.huantian.huan_software_park_manage.pojo.Status;

import java.time.LocalDateTime;


@Data
public class ListMsgVO {
    private Integer id;
    private Integer groupId;
    private String label;
    private String img;
}
