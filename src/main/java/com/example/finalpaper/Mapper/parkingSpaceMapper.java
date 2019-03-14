package com.example.finalpaper.Mapper;

import com.example.finalpaper.Entity.parkingSpace;
import com.example.finalpaper.Entity.room;
import com.example.finalpaper.Mapper.builder.UpdateBuilder;
import org.apache.ibatis.annotations.*;
import org.springframework.dao.DataAccessException;

import java.util.List;

@Mapper
public interface parkingSpaceMapper {

    //查找数据
    @Select("select * from parkingSpace where parking_id=#{id}")
    @Results({
            @Result(column = "parking_id",property = "parkingSpaceId"),
            @Result(column = "user_uuid",property = "useruuid"),
            @Result(column = "parking_type",property = "parkingSpaceType"),
            @Result(column = "parking_describtion",property = "parkingSpaceDescribtion"),
            @Result(column = "parking_belong",property = "parkingSpaceBelong"),
    })
    parkingSpace selectbyid(String id);

    @Select("select * from parkingSpace")
    @Results({
            @Result(column = "parking_id",property = "parkingSpaceId"),
            @Result(column = "user_uuid",property = "useruuid"),
            @Result(column = "parking_type",property = "parkingSpaceType"),
            @Result(column = "parking_describtion",property = "parkingSpaceDescribtion"),
            @Result(column = "parking_belong",property = "parkingSpaceBelong"),
    })
    List<parkingSpace> selectAll();

    @Select("select * from parkingSpace where parking_type = #{type}")
    @Results({
            @Result(column = "parking_id",property = "parkingSpaceId"),
            @Result(column = "user_uuid",property = "useruuid"),
            @Result(column = "parking_type",property = "parkingSpaceType"),
            @Result(column = "parking_describtion",property = "parkingSpaceDescribtion"),
            @Result(column = "parking_belong",property = "parkingSpaceBelong"),
    })
    List<parkingSpace> selectByUserType(String type);

    //查找没有分配用户的数据
    @Select("select * from parkingSpace where user_uuid = NULL")
    @Results({
            @Result(column = "parking_id",property = "parkingSpaceId"),
            @Result(column = "user_uuid",property = "useruuid"),
            @Result(column = "parking_type",property = "parkingSpaceType"),
            @Result(column = "parking_decribtion",property = "parkingSpaceDescribtion"),
            @Result(column = "parking_belong",property = "parkingSpaceBelong"),
    })
    List<parkingSpace> selectUseruuidNone();


    //增加数据
    @Insert("INSERT INTO parkingSpace (" +
            "parking_id," +
            "user_uuid, " +
            "parking_type, " +
            "parking_describtion, " +
            "parking_belong) " +
            "VALUES (" +
            "#{parkingSpaceId}, " +
            "#{useruuid}, " +
            "#{parkingSpaceType}, " +
            "#{parkingSpaceDescribtion}, " +
            "#{parkingSpaceBelong});")
    int insertParkingSpaceById(parkingSpace parkingInsert) throws DataAccessException;





    //删除数据
    @Delete("delete from parkingSpace where user_uuid=#{id}")
    int deleteParkingSpaceById(String id) throws DataAccessException;

    //修改数据
//    @Update("UPDATE parkingSpace SET " +
//            "user_uuid=#{useruuid}, " +
//            "parking_type=#{parkingSpaceType}, " +
//            "parking_describtion=#{parkingSpaceDescribtion}, " +
//            "parking_belong=#{parkingSpaceBelong} ," +
//            "latitude=#{latitude}," +
//            "longitude=#{longitude};")
    @UpdateProvider(type= UpdateBuilder.class,method = "updateParkingSpaceById")
    int updateParkingSpaceById(parkingSpace parkingUpdate) throws DataAccessException;
}
