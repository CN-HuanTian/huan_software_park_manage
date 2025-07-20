package org.huantian.huan_software_park_manage.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.huantian.huan_software_park_manage.pojo.Status;
import org.huantian.huan_software_park_manage.pojo.dto.ListCreateDTO;
import org.huantian.huan_software_park_manage.pojo.dto.ListUpdateDTO;
import org.huantian.huan_software_park_manage.pojo.po.ListPO;
import org.huantian.huan_software_park_manage.pojo.vo.ListMsgVO;

import java.util.List;

@Mapper
public interface ListMapper {

    // 根据id查询
    @Select("select * from huan_software_park_manage.application_list where id=#{id}")
    ListPO findById(int id);

    // 根据列表名查询
    @Select("select * from huan_software_park_manage.application_list where label=#{label}")
    ListPO findByLabel(String label);

    // 增
    @Insert("insert into huan_software_park_manage.application_list (classify_id, group_id, label, img, introduce, remarks) values (#{classifyId}, #{groupId}, #{label}, #{img}, #{introduce}, #{remarks})")
    void add(ListCreateDTO data);

    // 删
    @Update("update huan_software_park_manage.application_list set status=#{status} where id=#{id}")
    void del(Integer id, Status status);

    // 改
    @Update("update huan_software_park_manage.application_list set classify_id=#{classifyId},group_id=#{groupId},label=#{label},img=#{img},status=#{status},introduce=#{introduce},remarks=#{remarks} where id=#{id}")
    void update(ListUpdateDTO data);
    // 省流查询
    @Select("select id,group_id,label,img from huan_software_park_manage.application_list")
    List<ListMsgVO> msg();
}
