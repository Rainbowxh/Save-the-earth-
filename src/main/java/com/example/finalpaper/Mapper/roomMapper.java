package com.example.finalpaper.Mapper;

import  com.example.finalpaper.Entity.room;
import org.apache.ibatis.annotations.*;
import org.springframework.dao.DataAccessException;

import java.util.List;

@Mapper
public interface roomMapper {
    //查找数据
    @Select("select * from room where room_uuid=#{id}")
    @Results({
        @Result(column = "room_uuid",property = "roomuuid"),
        @Result(column = "user_uuid",property = "useruuid"),
        @Result(column = "building_id",property = "buildingid"),
        @Result(column = "room_describition",property = "describtion"),
        @Result(column = "room_belong",property = "belong")
    })
    room selectbyid(String id);

    @Select("select * from room")
    @Results({
            @Result(column = "room_uuid",property = "roomuuid"),
            @Result(column = "user_uuid",property = "useruuid"),
            @Result(column = "building_id",property = "buildingid"),
            @Result(column = "room_describition",property = "describtion"),
            @Result(column = "room_belong",property = "belong")
    })
    List<room> selectAll();

    @Select("select * from room where user_uuid = #{userId}")
    @Results({
            @Result(column = "room_uuid",property = "roomuuid"),
            @Result(column = "user_uuid",property = "useruuid"),
            @Result(column = "building_id",property = "buildingid"),
            @Result(column = "room_describition",property = "describtion"),
            @Result(column = "room_belong",property = "belong")
    })
    List<room> selectByUserId(String userId);

    //增加数据
    @Insert("INSERT INTO room (" +
            "room_uuid, " +
            "user_uuid, " +
            "building_id, " +
            "room_describtion, " +
            "room_belong, " +
            "longitude, " +
            "latitude) " +
            "VALUES (" +
            "#{roomuuid}, " +
            "#{useruuid}, " +
            "#{buildingid}, " +
            "#{describtion}, " +
            "#{belong}, " +
            "#{latitude}, " +
            "#{longitude});")
    int insertRoom(room roomInsert) throws DataAccessException;


    //删除数据
    @Delete("delete from room where room_uuid=#{roomuuid}")
    int deleteRoomById(String id) throws DataAccessException;

    //修改数据
    @Update("UPDATE room SET " +
            "user_uuid = #{useruuid}," +
            "building_id=#{buildingid}," +
            "room_describtion=#{describtion}," +
            "room_belong = #{belong} " +
            "WHERE room.room_uuid = #{roomuuid};")
    int updateRoomById(room roomUpdate) throws DataAccessException;

    //修改所属大楼
    int updateRoomBuildingId(String id) throws DataAccessException;
}
