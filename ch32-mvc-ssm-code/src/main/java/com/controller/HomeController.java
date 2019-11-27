package com.controller;

import com.entity.EmployeeEntity;
import com.service.EmployeeService;
import com.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author cj
 * @date 2019/11/25
 */

@Controller
public class HomeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/index")

    public String index(){
        return "index";
    }
    @RequestMapping(value = "/list")
    @ResponseBody
    public ResponseVO list(
            @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,

            @RequestParam(value = "pageSize",defaultValue = "1",required = false)int pageSize){
        List<EmployeeEntity> result= employeeService.getAll(pageNum,pageSize);

        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode("200");
        responseVO.setMsg("success");
        responseVO.setData(result);
        return  responseVO;
    }
}
