package com.service.impl;

import com.dao.EmployeeDao;
import com.entity.Employee;
import com.service.EmployeeService;

import java.util.List;

/**
 * @author cj
 * @date 2019/10/24
 */
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao dao;

    public void setDao(EmployeeDao dao) {
        this.dao = dao;
    }


    @Override
    public List<Employee> getAll(int pageNum, int pageSize) {
        return dao.getAll(pageNum, pageSize);
    }
}
