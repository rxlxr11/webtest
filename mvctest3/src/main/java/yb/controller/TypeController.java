package yb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yb.pojo.Type;
import yb.service.ITypeService;

import java.util.List;

@RestController
@RequestMapping("type")
public class TypeController {

    @Autowired
    private ITypeService typeService;

    @RequestMapping("queryAll")
    public List<Type> queryAll(){
        return typeService.queryAll();
    }

    @RequestMapping("queryByName")
    public String queryByName(String name){
        if (name==null||name=="")
            return "no";
        return typeService.queryByName(name).isEmpty()?"yes":"no";
    }

    @RequestMapping("addType")
    public String addType(@RequestBody Type type){
        if (type==null)
            return "数据错误";
        return typeService.addType(type)>0?"success":"fail";
    }


}
