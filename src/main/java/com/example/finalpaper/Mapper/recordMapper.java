package com.example.finalpaper.Mapper;

import com.example.finalpaper.Entity.record;
import org.apache.ibatis.annotations.*;
import org.springframework.dao.DataAccessException;

import java.util.List;


@Mapper
public interface recordMapper {

    //查找数据
    @Select("select * from record where record_id=#{id}")
    @Results({
            @Result(column = "record_id",property = "recordId"),
            @Result(column = "user_uuid",property = "useruuid"),
            @Result(column = "facility_id",property = "facilityId"),
            @Result(column = "record_type",property = "recordType"),
            @Result(column = "record_describtion",property = "recordDescribtion"),
            @Result(column = "record_start",property = "startTime"),
            @Result(column = "record_end",property = "endTime"),
            @Result(column = "record_finish",property = "recordFinish"),
            @Result(column = "worker_id",property = "workerId")
    })
    record selectbyid(String id);

    @Select("select * from record")
    @Results({
            @Result(column = "record_id",property = "recordId"),
            @Result(column = "user_uuid",property = "useruuid"),
            @Result(column = "facility_id",property = "facilityId"),
            @Result(column = "record_type",property = "recordType"),
            @Result(column = "record_describtion",property = "recordDescribtion"),
            @Result(column = "record_start",property = "startTime"),
            @Result(column = "record_end",property = "endTime"),
            @Result(column = "record_finish",property = "recordFinish"),
            @Result(column = "worker_id",property = "workerId")

    })
    List<record> selectAll();

    @Select("select * from record where user_uuid = #{userId}")
    @Results({
            @Result(column = "record_id",property = "recordId"),
            @Result(column = "user_uuid",property = "useruuid"),
            @Result(column = "facility_id",property = "facilityId"),
            @Result(column = "record_type",property = "recordType"),
            @Result(column = "record_describtion",property = "recordDescribtion"),
            @Result(column = "record_start",property = "startTime"),
            @Result(column = "record_end",property = "endTime"),
            @Result(column = "record_finish",property = "recordFinish"),
            @Result(column = "worker_id",property = "workerId")

    })
    List<record> selectByUserId(String userId);

    //增加数据
    @Insert("INSERT INTO record (" +
            "record_id," +
            "user_uuid, " +
            "facility_id, " +
            "record_type, " +
            "record_describtion," +
            "record_start, " +
            "record_end, " +
            "record_finish," +
            "worker_id) " +
            "VALUES (" +
            "#{recordId}, " +
            "#{useruuid}, " +
            "#{facilityId}, " +
            "#{recordType}, " +
            "#{recordDescribtion} ," +
            "#{startTime}," +
            "#{endTime}, " +
            "#{recordFinish}," +
            "#{workerId});")
    int insertRecordById(record recordIJIdnsert) throws DataAccessException;

    //删除数据
    @Delete("delete from record where record_id=#{id}")
    int deleteRecordById(String id) throws DataAccessException;

    //修改数据
    @Update("UPDATE record SET record_id=#{recordId}," +
            "user_uuid=#{useruuid}, " +
            "facility_id=#{facilityId}, " +
            "record_type=#{recordType}, " +
            "record_describtion=#{recordDescribtion} ," +
            "record_start=#{startTime}," +
            "record_end=#{endTime}, " +
            "record_finish=#{recordFinish} ," +
            "worker_id=#{workerId} " +
            "WHERE record.record_id = #{recordId};")
    int updateRecordById(record recordUpdate) throws DataAccessException;
}
