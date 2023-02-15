package com.tulingxueyuan.controller;

import com.tulingxueyuan.mapper.DeptMapper;
import com.tulingxueyuan.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:gaojinjun
 * @date: 2023022023/2/15下午9:04
 **/
@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    DeptMapper  deptMapper;

    @RequestMapping("/all")
    public Dept getAll(){
        System.out.println("selectByPrimaryId!!!!");
        return deptMapper.selectByPrimaryKey(1);
    }

}
