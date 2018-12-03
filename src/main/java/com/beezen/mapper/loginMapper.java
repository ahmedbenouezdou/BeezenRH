package com.beezen.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import com.beezen.domain.Utilisateurs;
/**
 * @author Eddú Meléndez
 */
@Mapper
public interface LoginMapper {

    @Select("select * from city where state = #{state}")
    Utilisateurs findByState(@Param("state") String state);

}