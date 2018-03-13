package com.mizlicai.eudemon.service;

import com.mizlicai.eudemon.entity.Project;
import com.mizlicai.eudemon.entity.ProjectExample;

import java.util.List;

/**
 * Created by huangyt on 2017/7/24.
 */
public interface ProjectService {

    int deleteByExample(ProjectExample example);

    int delete(Integer id);

    int insert(Project record);

    int update(Project record);

    Project getProjectById(Integer id);

    List<Project> getProjectByExample(ProjectExample example);

    List<Project> getProjectByName(String name);
}
