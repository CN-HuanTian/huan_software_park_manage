package org.huantian.huan_software_park_manage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.huantian.huan_software_park_manage.pojo.po.ApplicationPO;

@Mapper
public interface ApplicationMapper {
    @Select("select * from huan_software_park_manage.application_msg where id=#{id}")
    ApplicationPO findById(Integer id);
    @Select("select * from huan_software_park_manage.application_msg where label=#{label}")
    ApplicationPO findByLabel(String label);
}
