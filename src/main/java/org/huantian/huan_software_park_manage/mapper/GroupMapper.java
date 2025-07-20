package org.huantian.huan_software_park_manage.mapper;

import org.apache.ibatis.annotations.*;
import org.huantian.huan_software_park_manage.pojo.PageBean;
import org.huantian.huan_software_park_manage.pojo.Status;
import org.huantian.huan_software_park_manage.pojo.dto.GroupCreateDTO;
import org.huantian.huan_software_park_manage.pojo.dto.GroupUpdateDTO;
import org.huantian.huan_software_park_manage.pojo.po.GroupPO;
import org.huantian.huan_software_park_manage.pojo.vo.GroupMsgVO;
import org.huantian.huan_software_park_manage.pojo.vo.GroupVO;

import java.util.List;

@Mapper
public interface GroupMapper {

    // 根据组名查询组
    @Select("select * from huan_software_park_manage.category_group where label =#{label}")
    GroupPO findByLabel(String label);

    // 根据id查询组
    @Select("select * from huan_software_park_manage.category_group where id =#{id}")
    GroupPO findById(Integer id);

    // 新增组
    @Insert("insert into huan_software_park_manage.category_group(classify_id,label, remarks) values (#{classifyId},#{label},#{remarks})")
    void add(GroupCreateDTO data);

    // 删除组
    @Update("update huan_software_park_manage.category_group set status=#{ban} where id=#{id}")
    void del(Integer id, Status ban);

    // 修改组
    @Update("update huan_software_park_manage.category_group set classify_id=#{classifyId},label=#{label},status=#{status},remarks=#{remarks} where id=#{id}")
    void updata(GroupUpdateDTO data);

    // 查询组
    List<GroupVO> list(@Param("status") Status status,
                       @Param("keyWord") String keyWord,
                       @Param("classifyId") List<Integer> classifyId);

    // 省流查询
    @Select("select id,classify_id,label from huan_software_park_manage.category_group")
    List<GroupMsgVO> msg();
}
