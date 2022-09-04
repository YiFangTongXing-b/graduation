package com.czf.graduation.controller;

import com.czf.graduation.domain.School;
import com.czf.graduation.service.SchoolService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/colleges")
public class SchoolController {
    @Resource
    private SchoolService schoolService;

    @RequestMapping("/getColleges/{pid}")
    public List<School> getColleges(@PathVariable("pid") Integer pid){
        return schoolService.getCollegesByPid(pid);
    }

    @RequestMapping("/getCollegeId")
    public int getCollegeId(String name){
        return schoolService.getIdBySchoolName(name);
    }
}
