package yb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yb.pojo.StudentInfo;
import yb.service.IStudentInfoService;

import java.util.List;

@Controller
public class StudentInfoController {
    @Autowired
    private IStudentInfoService studentInfoService;

    @RequestMapping("toStudentList")
    public String toStudentList(){return "studentList";}

    @RequestMapping(value = "queryAll",method = RequestMethod.GET)
    @ResponseBody
    public List<StudentInfo> queryAll(){
        return studentInfoService.queryAll();
    }

    @RequestMapping("toUpdateById")
    public String toUpdateById(){return "updateStu";}


    @RequestMapping("deleteById")
    @ResponseBody
    public String deleteById(@RequestParam("id") Integer id){return studentInfoService.deleteById(id)>0?"success":"fail";}

    @RequestMapping(value = "queryById",method = RequestMethod.GET)
    @ResponseBody
    public StudentInfo queryById(@RequestParam("id") Integer id){
        return studentInfoService.queryById(id);
    }

    @RequestMapping("updateById")
    @ResponseBody
    public String updateById(@RequestBody StudentInfo studentInfo){
        System.out.println("aa"+studentInfo);
        return studentInfoService.updateById(studentInfo)>0?"success":"fail";
    }



}
