package org.huantian.huan_software_park_manage.service;


import org.huantian.huan_software_park_manage.pojo.PageBean;
import org.huantian.huan_software_park_manage.pojo.Status;
import org.huantian.huan_software_park_manage.pojo.dto.GroupCreateDTO;
import org.huantian.huan_software_park_manage.pojo.dto.GroupUpdateDTO;
import org.huantian.huan_software_park_manage.pojo.po.GroupPO;
import org.huantian.huan_software_park_manage.pojo.vo.GroupMsgVO;
import org.huantian.huan_software_park_manage.pojo.vo.GroupVO;

import java.util.List;

public interface GroupService {
    // 根据组名查询组
    GroupPO findByLabel(String label);
    // 根据id查询组
    GroupPO findById(Integer id);
    // 新增组
    void add(GroupCreateDTO data);
    // 删除组
    void del(Integer id);
    // 修改组
    void update(GroupUpdateDTO data);
    // 查询组
    PageBean<GroupVO> list(Integer pageNum, Integer pageSize, Status status, List<Integer> classifyId, String keyWord);
    // 省流查询
    List<GroupMsgVO> msg();
}
