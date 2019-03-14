package com.example.finalpaper.Service;

import com.example.finalpaper.Entity.user;
import com.example.finalpaper.Entity.user;
import com.example.finalpaper.Mapper.userMapper;
import com.example.finalpaper.Mapper.userMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService extends baseService{
    @Autowired
    private com.example.finalpaper.Mapper.userMapper userMapper;


    //通过记录id查询
    public String getById(String userId) {
        user userResult = userMapper.selectbyid(userId);
        return formatBody(userResult);
    }

    //查询所有记录
    public String getAll() {
        List<user> userAll = userMapper.selectAll();
        return  transferBody(userAll) ;
    }

    //通过用户id来查询
    public String getByUserId(String userType) {
        List<user> userByUserId = userMapper.selectByUserType(userType);
        return transferBody(userByUserId);
    }

    //删除数据
    public int deleteById(String userId){
        return userMapper.deleteUserById(userId);
    }

    //增加数据
    public int insertById(user userEntity){
        return userMapper.insertRecordById(userEntity);
    }

    //修改数据
    public int updateById(user userEntity){
        return userMapper.updateRecordById(userEntity);
    }

}
