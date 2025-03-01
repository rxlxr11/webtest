package yb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yb.mapper.StudentInfoMapper;
import yb.pojo.StudentInfo;
import yb.service.IStudentInfoService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StudentInfoServiceImpl implements IStudentInfoService {

    @Autowired
    private StudentInfoMapper studentInfoMapper;
    @Override
    public List<StudentInfo> queryAll() {
        return studentInfoMapper.queryAll();
    }

    @Override
    public StudentInfo queryById(Integer id) {
        return studentInfoMapper.queryById(id);
    }

    @Override
    public int deleteById(Integer id) {
        return studentInfoMapper.deleteById(id);
    }

    @Override
    public int updateById(StudentInfo studentInfo) {
        return studentInfoMapper.updateById(studentInfo);
    }
}
