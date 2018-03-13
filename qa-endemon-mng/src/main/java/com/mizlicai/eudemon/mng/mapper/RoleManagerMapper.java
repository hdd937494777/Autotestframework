package com.mizlicai.eudemon.mng.mapper;

import com.mizlicai.eudemon.mng.entity.Member;
import com.mizlicai.eudemon.mng.entity.RoleManager;
import com.mizlicai.eudemon.mng.entity.RoleManagerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface RoleManagerMapper {
    long countByExample(RoleManagerExample example);

    int deleteByExample(RoleManagerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoleManager record);

    int insertSelective(RoleManager record);

    List<RoleManager> selectByExampleWithBLOBs(RoleManagerExample example);

    List<RoleManager> selectByExample(RoleManagerExample example);

    RoleManager selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoleManager record, @Param("example") RoleManagerExample example);

    int updateByExampleWithBLOBs(@Param("record") RoleManager record, @Param("example") RoleManagerExample example);

    int updateByExample(@Param("record") RoleManager record, @Param("example") RoleManagerExample example);

    int updateByPrimaryKeySelective(RoleManager record);

    int updateByPrimaryKeyWithBLOBs(RoleManager record);

    int updateByPrimaryKey(RoleManager record);

    /**
     * 根据成员id查询角色
     */
    @Select("select r.* from role_manager r, member_role m where r.id = m.role_id and member_id = #{0}")
    List<RoleManager> selectRoleByMemberId(Integer memberId);

    @Select("SELECT group_concat(m.chinese_name) FROM member m left join member_role mr on m.id = mr.member_id where mr.name like #{0}")
    String selectMemberAccordingOfRole(String name);


    @Select("SELECT m.* FROM member m left join member_role mr on m.id = mr.member_id where mr.name like #{0}")
    List<Member> selectMemberLikeRoleName(String name);


}