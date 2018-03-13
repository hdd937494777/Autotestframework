package com.mizlicai.eudemon.mapper;

import com.mizlicai.eudemon.entity.ErrorRequest;
import com.mizlicai.eudemon.entity.ErrorRequestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErrorRequestMapper {
    long countByExample(ErrorRequestExample example);

    int deleteByExample(ErrorRequestExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ErrorRequest record);

    int insertSelective(ErrorRequest record);

    List<ErrorRequest> selectByExample(ErrorRequestExample example);

    ErrorRequest selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ErrorRequest record, @Param("example") ErrorRequestExample example);

    int updateByExample(@Param("record") ErrorRequest record, @Param("example") ErrorRequestExample example);

    int updateByPrimaryKeySelective(ErrorRequest record);

    int updateByPrimaryKey(ErrorRequest record);
}