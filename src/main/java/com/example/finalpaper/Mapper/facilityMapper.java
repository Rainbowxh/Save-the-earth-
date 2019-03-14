package com.example.finalpaper.Mapper;

import com.example.finalpaper.Entity.facility;
import org.apache.ibatis.annotations.*;
import org.springframework.dao.DataAccessException;

import java.util.List;

@Mapper
public interface facilityMapper {
    //查找数据
    @Select("select * from facility where facility_id=#{id}")
    @Results({
            @Result(column = "facility_id",property = "facilityId"),
            @Result(column = "facility_name",property = "facilityName"),
            @Result(column = "facility_type",property = "facilityType"),
            @Result(column = "facility_describtion",property = "facilityDescribtion"),
            @Result(column = "status",property = "facilityStatus"),
            @Result(column = "facility_start",property = "startTime"),
            @Result(column = "facility_end",property = "endTime"),
            @Result(column = "latitude",property = "latitude"),
            @Result(column = "longitude",property = "longitude")
    })
    facility selectbyid(String id);

    @Select("select * from facility")
    @Results({
            @Result(column = "facility_id",property = "facilityId"),
            @Result(column = "facility_name",property = "facilityName"),
            @Result(column = "facility_type",property = "facilityType"),
            @Result(column = "facility_describtion",property = "facilityDescribtion"),
            @Result(column = "status",property = "facilityStatus"),
            @Result(column = "facility_start",property = "startTime" ,javaType=java.sql.Date.class),
            @Result(column = "facility_end",property = "endTime",javaType=java.sql.Date.class   ),
            @Result(column = "latitude",property = "latitude"),
            @Result(column = "longitude",property = "longitude")
    })
    List<facility> selectAll();

    @Select("select * from facility where facility_type = #{type}")
    @Results({
            @Result(column = "facility_id",property = "facilityId"),
            @Result(column = "facility_name",property = "facilityName"),
            @Result(column = "facility_type",property = "facilityType"),
            @Result(column = "facility_describtion",property = "facilityDescribtion"),
            @Result(column = "status",property = "facilityStatus"),
            @Result(column = "facility_start",property = "startTime"),
            @Result(column = "facility_end",property = "endTime"),
            @Result(column = "latitude",property = "latitude"),
            @Result(column = "longitude",property = "longitude")
    })
    List<facility> selectByFacilityType(String type);

    //增加数据
    @Insert("INSERT INTO facility (" +
            "facility_name, " +
            "facility_ID, " +
            "facility_type, " +
            "facility_describtion, " +
            "status, " +
            "facility_end, " +
            "latitude, " +
            "longitude) " +
            "VALUES (" +
            "#{facilityName}, " +
            "#{facilityId}, " +
            "#{facilityType}, " +
            "#{facilityDescribtion}, " +
            "#{facilityStatus}, " +
            "#{endTime} ," +
            "#{latitude} ," +
            "#{longitude});")
    int insertFacilityById(facility facilityInsert) throws DataAccessException;

    //删除数据
    @Delete("delete from facility where facility_id=#{id}")
    int deleteFacilityById(String id) throws DataAccessException;

    //修改数据
    @Update("UPDATE facility SET " +
            "facility_name=#{facilityName}, " +
            "facility_type=#{facilityType}, " +
            "facility_describtion=#{facilityDescribtion}, " +
            "status=#{facilityStatus}, " +
            "facility_start=#{startTime} ," +
            "facility_end=#{endTime} ," +
            "latitude=#{latitude} ," +
            "longitude=#{longitude};")
    int updateFacilityById(facility facilityUpdate) throws DataAccessException;


}
