package org.huantian.huan_software_park_manage.mapper;

import org.apache.ibatis.annotations.*;
import org.huantian.huan_software_park_manage.pojo.Status;
import org.huantian.huan_software_park_manage.pojo.dto.ClassifyCreateDTO;
import org.huantian.huan_software_park_manage.pojo.dto.ClassifyUpdateDTO;
import org.huantian.huan_software_park_manage.pojo.po.ClassifyPO;
import org.huantian.huan_software_park_manage.pojo.vo.ClassifyMsgVO;
import org.huantian.huan_software_park_manage.pojo.vo.ClassifyVO;

import java.util.List;

@Mapper
public interface ClassifyMapper {
    // 根据分类名查询分类
    @Select("select * from huan_software_park_manage.category_classify where label = #{label}")
    ClassifyPO findByLabel(String label);
    // 根据id查询分类
    @Select("select * from huan_software_park_manage.category_classify where id = #{id}")
    ClassifyPO findById(Integer id);
    // 新增分类
    @Insert("insert into huan_software_park_manage.category_classify(label, img, remarks) values (#{label},#{img},#{remarks})")
    void add(ClassifyCreateDTO data);
    // 删除分类
    @Update("update huan_software_park_manage.category_classify set status=#{ban} where id=#{id}")
    void del(Integer id, Status ban);
    // 修改分类
    @Update("update huan_software_park_manage.category_classify set label=#{label},img=#{img},status=#{status},remarks=#{remarks} where id=#{id}")
    void update(ClassifyUpdateDTO data);
    // 查询分类
    List<ClassifyVO> list(@Param("status") Status status,
                          @Param("keyWord") String keyWord);
    // 省流查询
    @Select("select id,label,img from huan_software_park_manage.category_classify")
    List<ClassifyMsgVO> msg();
}
