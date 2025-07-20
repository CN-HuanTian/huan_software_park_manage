package org.huantian.huan_software_park_manage.service;

import org.huantian.huan_software_park_manage.pojo.dto.ListCreateDTO;
import org.huantian.huan_software_park_manage.pojo.dto.ListUpdateDTO;
import org.huantian.huan_software_park_manage.pojo.po.ListPO;
import org.huantian.huan_software_park_manage.pojo.vo.ListMsgVO;

import java.util.List;

public interface ListService {
    // 根据id查询
    ListPO findById(int id);
    // 根据列表名查询
    ListPO findByLabel(String label);
    // 增
    void add(ListCreateDTO data);
    // 删
    void del(Integer id);
    // 改
    void update(ListUpdateDTO data);
    // 省流查询
    List<ListMsgVO> msg();
}
