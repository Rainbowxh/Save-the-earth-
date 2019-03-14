package com.example.finalpaper.Mapper;

import com.example.finalpaper.Entity.user;
import org.apache.ibatis.annotations.*;
import org.springframework.dao.DataAccessException;
import java.util.List;

@Mapper
public interface userMapper {

    //查找数据
    @Select("select * from user where user_uuid=#{id}")
    @Results({
            @Result(column = "user_uuid",property = "useruuid"),
            @Result(column = "user_name",property = "userName"),
            @Result(column = "user_type",property = "userType"),
            @Result(column = "user_telephone",property = "userTelephone"),
            @Result(column = "user_email",property = "userEmail"),
            @Result(column = "room_uuid",property = "roomuuid"),
            @Result(column = "user_describtion",property = "userDescribtion"),
            @Result(column = "property",property = "property")
    })
    user selectbyid(String id);

    @Select("select * from user")
    @Results({
            @Result(column = "user_uuid",property = "useruuid"),
            @Result(column = "user_name",property = "userName"),
            @Result(column = "user_type",property = "userType"),
            @Result(column = "user_telephone",property = "userTelephone"),
            @Result(column = "user_email",property = "userEmail"),
            @Result(column = "room_uuid",property = "roomuuid"),
            @Result(column = "user_describtion",property = "userDescribtion"),
            @Result(column = "property",property = "property")
    })
    List<user> selectAll();

    @Select("select * from user where user_uuid = #{type}")
    @Results({
            @Result(column = "user_uuid",property = "useruuid"),
            @Result(column = "user_name",property = "userName"),
            @Result(column = "user_type",property = "userType"),
            @Result(column = "user_telephone",property = "userTelephone"),
            @Result(column = "user_email",property = "userEmail"),
            @Result(column = "room_uuid",property = "roomuuid"),
            @Result(column = "user_describtion",property = "userDescribtion"),
            @Result(column = "property",property = "property")
    })
    List<user> selectByUserType(String type);

    //增加数据
    @Insert("INSERT INTO user (" +
            "user_uuid, " +
            "user_name, " +
            "user_type, " +
            "user_telephone, " +
            "user_email," +
            "user_describtion, " +
            "property) " +
            "VALUES (" +
            "#{useruuid}, " +
            "#{userName}, " +
            "#{userType}, " +
            "#{userTelephone}, " +
            "#{userEmail} ," +
            "#{userDescribtion}," +
            "#{property});")
    int insertRecordById(user userInsert) throws DataAccessException;

    //删除数据
    @Delete("delete from user where user_uuid=#{id}")
    int deleteUserById(String id) throws DataAccessException;

    //修改数据
    @Update("UPDATE user SET " +
            "user_name=#{userName}," +
            "user_type=#{userType}," +
            "user_describtion=#{userDescribtion}," +
            "user_email=#{userEmail}," +
            "room_uuid=#{roomuuid}," +
            "property=#{property}," +
            "user_telephone=#{userTelephone}" +
            "WHERE user.user_uuid = #{useruuid};")
    int updateRecordById(user userUpdate) throws DataAccessException;
}
