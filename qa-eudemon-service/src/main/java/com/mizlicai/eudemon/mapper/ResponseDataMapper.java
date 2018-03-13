package com.mizlicai.eudemon.mapper;

import com.mizlicai.eudemon.entity.ResponseData;
import com.mizlicai.eudemon.entity.ResponseDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResponseDataMapper {
    long countByExample(ResponseDataExample example);

    int deleteByExample(ResponseDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ResponseData record);

    int insertSelective(ResponseData record);

    List<ResponseData> selectByExample(ResponseDataExample example);

    ResponseData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ResponseData record, @Param("example") ResponseDataExample example);

    int updateByExample(@Param("record") ResponseData record, @Param("example") ResponseDataExample example);

    int updateByPrimaryKeySelective(ResponseData record);

    int updateByPrimaryKey(ResponseData record);
}