package yb.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

}
