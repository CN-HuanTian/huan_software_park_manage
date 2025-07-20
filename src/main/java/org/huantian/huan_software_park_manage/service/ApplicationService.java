package org.huantian.huan_software_park_manage.service;

import org.huantian.huan_software_park_manage.pojo.po.ApplicationPO;

public interface ApplicationService {
    ApplicationPO findById(Integer id);
    ApplicationPO findByLabel(String label);
}
