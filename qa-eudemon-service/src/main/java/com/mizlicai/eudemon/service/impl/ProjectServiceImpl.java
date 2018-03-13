package com.mizlicai.eudemon.service.impl;

import com.mizlicai.eudemon.entity.Project;
import com.mizlicai.eudemon.entity.ProjectExample;
import com.mizlicai.eudemon.mapper.ProjectMapper;
import com.mizlicai.eudemon.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huangyt on 2017/7/24.
 */
@Service
public class ProjectServiceImpl implements ProjectService{
    
    @Autowired
    private ProjectMapper ProjectMapper;

    @Override
    public int deleteByExample(ProjectExample example) {
        return ProjectMapper.deleteByExample(example);
    }

    @Override
    public int delete(Integer id) {
        return ProjectMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Project record) {
        return ProjectMapper.insertSelective(record);
    }

    @Override
    public int update(Project record) {

        return ProjectMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Project getProjectById(Integer id) {
        return ProjectMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Project> getProjectByExample(ProjectExample example) {
        return ProjectMapper.selectByExample(example);
    }

    @Override
    public List<Project> getProjectByName(String name) {
        ProjectExample example = new ProjectExample();
        example.createCriteria().andProjectNameEqualTo(name);
        return ProjectMapper.selectByExample(example);
    }

}
