package com.example.finalpaper.Mapper;

import com.example.finalpaper.Entity.building;
import org.apache.ibatis.annotations.*;
import org.springframework.dao.DataAccessException;

import java.util.List;

@Mapper
public interface buildingMapper {
    //查找数据
    @Select("select * from building where building_id=#{id}")
    @Results({
            @Result(column = "building_id",property = "buildingId"),
            @Result(column = "building_name",property = "buildingName"),
            @Result(column = "building_description",property = "buildingDescription"),
            @Result(column = "latitude",property = "latitude"),
            @Result(column = "longitude",property = "longitude")
    })
    building selectbyid(String id);

    @Select("select * from building")
    @Results({
            @Result(column = "building_id",property = "buildingId"),
            @Result(column = "building_name",property = "buildingName"),
            @Result(column = "building_description",property = "buildingDescription"),
            @Result(column = "latitude",property = "latitude"),
            @Result(column = "longitude",property = "longitude")
    })
    List<building> selectAll();

    @Select("select * from building where user_uuid = #{userId}")
    @Results({
            @Result(column = "building_id",property = "buildingId"),
            @Result(column = "building_name",property = "buildingName"),
            @Result(column = "building_description",property = "buildingDescription"),
            @Result(column = "latitude",property = "latitude"),
            @Result(column = "longitude",property = "longitude")
    })
    List<building> selectByUserId(String userId);


    //增加数据
    @Insert("INSERT INTO building (" +
            "building_id, " +
            "building_name, " +
            "building_description, " +
            "latitude, " +
            "longitude) " +
            "VALUES (" +
            "#{buildingId}, " +
            "#{buildingName}, " +
            "#{buildingDescription}, " +
            "#{latitude}, " +
            "#{longitude}); ")
    int insertbuilding(building buildingInsert) throws DataAccessException;

    //删除数据
    @Delete("delete from building where building_id=#{buildingId}")
    int deleteBuildingById(String id) throws DataAccessException;

    //修改数据
    @Update("UPDATE building SET building_name=#{buildingName},building_description=#{buildingDescription} WHERE building.building_id = #{buildingId};")
    int updateBuildingById(building buildingUpdate) throws DataAccessException;
}
