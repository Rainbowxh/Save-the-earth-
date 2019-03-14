package com.example.finalpaper.Mapper;

import com.example.finalpaper.Entity.worker;
import org.apache.ibatis.annotations.*;
import org.springframework.dao.DataAccessException;

import java.util.List;

@Mapper
public interface workerMapper {
    //查找数据
    @Select("select *  from worker where worker_id=#{id}")
    @Results({
            @Result(column = "worker_id",property = "workerId"),
            @Result(column = "worker_name",property = "workerName"),
            @Result(column = "worker_type",property = "workerType"),
            @Result(column = "worker_email",property = "workerEmail"),
            @Result(column = "worker_telephone",property = "workerTelephone"),
            @Result(column = "worker_describtion",property = "workerDescribtion"),
            @Result(column = "worker_on",property = "workerOn")
    })
    worker selectbyid(String id);

    @Select("select * from worker")
    @Results({
            @Result(column = "worker_id",property = "workerId"),
            @Result(column = "worker_name",property = "workerName"),
            @Result(column = "worker_type",property = "workerType"),
            @Result(column = "worker_email",property = "workerEmail"),
            @Result(column = "worker_telephone",property = "workerTelephone"),
            @Result(column = "worker_describtion",property = "workerDescribtion"),
            @Result(column = "worker_on",property = "workerOn")
    })
    List<worker> selectAll();

    @Select("select * from worker where worker_type = #{type}")
    @Results({
            @Result(column = "worker_id",property = "workerId"),
            @Result(column = "worker_name",property = "workerName"),
            @Result(column = "worker_type",property = "workerType"),
            @Result(column = "worker_email",property = "workerEmail"),
            @Result(column = "worker_telephone",property = "workerTelephone"),
            @Result(column = "worker_describtion",property = "workerDescribtion"),
            @Result(column = "worker_on",property = "workerOn")
    })
    List<worker> selectByworkerType(String type);

    //增加数据
    @Insert("INSERT INTO worker (" +
            "worker_id," +
            "worker_name, " +
            "worker_type, " +
            "worker_email, " +
            "worker_telephone," +
            "worker_describtion) " +
            "VALUES (" +
            "#{workerId}, " +
            "#{workerName}, " +
            "#{workerType}, " +
            "#{workerTelephone}, " +
            "#{workerTelephone} ," +
            "#{workerDescribtion});")
    int insertRecordById(worker Insert) throws DataAccessException;

    //删除数据
    @Delete("delete from user where worker_id=#{id}")
    int deleteWorkerById(String id) throws DataAccessException;

    //修改数据
    @Update("UPDATE worker SET " +
            "worker_id=#{workerId}, " +
            "worker_name=#{workerName}, " +
            "worker_type=#{workerType}, " +
            "worker_telephone=#{workerTelephone}, " +
            "worker_email=#{workerEmail} ," +
            "worker_describtion=#{workerDescribtion}" +
            "where worker.worker_id=#{workerId};")
    int updateRecordById(worker userUpdate) throws DataAccessException;
}
