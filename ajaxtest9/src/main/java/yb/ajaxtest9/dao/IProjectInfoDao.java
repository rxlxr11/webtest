package yb.ajaxtest9.dao;

import yb.ajaxtest9.pojo.ProjectInfo;

import java.util.ArrayList;

public interface IProjectInfoDao extends IBaseDao {

    ArrayList<ProjectInfo> queryPage(Integer curPage);
    ArrayList<ProjectInfo> queryByStatus(Integer status, Integer curPage);
    Integer updateById(ProjectInfo projectInfo);
    ProjectInfo queryById(Integer id);
    Integer queryProjectCount(Integer status);
}
