package com.mizlicai.eudemon.mng.mapper;

import com.mizlicai.eudemon.mng.entity.ResourceUrl;
import com.mizlicai.eudemon.mng.entity.ResourceUrlExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ResourceUrlMapper {
    int countByExample(ResourceUrlExample example);

    int deleteByExample(ResourceUrlExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ResourceUrl record);

    int insertSelective(ResourceUrl record);

    List<ResourceUrl> selectByExample(ResourceUrlExample example);

    ResourceUrl selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ResourceUrl record, @Param("example") ResourceUrlExample example);

    int updateByExample(@Param("record") ResourceUrl record, @Param("example") ResourceUrlExample example);

    int updateByPrimaryKeySelective(ResourceUrl record);

    int updateByPrimaryKey(ResourceUrl record);

    /**
     * 根据角色id 列出资源路径
     */
    @Select("select r.* FROM resource r, resource_role rr where rr.role_id = #{id} and rr.resource_url_id= r.id")
    @ResultMap("com.mizlicai.eudemon.mng.mapper.ResourceUrlMapper.BaseResultMap")
    List<ResourceUrl> listResourceUrlByRoleId(Integer id);
}