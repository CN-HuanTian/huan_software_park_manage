package org.huantian.huan_software_park_manage.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//分页返回结果对象
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean<T>{
    private Long counts;//总条数
    private int page;//当前页数
    private int pages;//总页数
    private int pageSize;//每页条数
    private List<T> items;//当前页数据集合
}
