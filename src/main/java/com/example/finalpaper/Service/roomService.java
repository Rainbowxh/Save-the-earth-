package com.example.finalpaper.Service;


import com.example.finalpaper.Entity.room;
import com.example.finalpaper.Mapper.roomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class roomService extends baseService {
    @Autowired
    private roomMapper roomMapper;


    //通过房间id查询
    public String getById(String roomId) {
        room roomResult = roomMapper.selectbyid(roomId);
        return formatBody(roomResult);
    }

    //查询所有房间
    public String getAll() {
        List<room> roomAll = roomMapper.selectAll();
        return  transferBody(roomAll) ;
    }

    //通过用户id来查询
    public String getByUserId(String userId) {
        List<room> roomByUserId = roomMapper.selectByUserId(userId);
        return transferBody(roomByUserId);
    }

    //删除数据
    public int deleteById(String userId){
        return roomMapper.deleteRoomById(userId);
    }

    //增加数据
    public int insertById(room roomEntity){
        if(StringUtils.isNotBlank(roomEntity.getUseruuid())){
            roomEntity.setBelong(true);
        }
       return roomMapper.insertRoom(roomEntity);
    }

    //修改数据
    public int updateById(room roomEntity){
        return roomMapper.updateRoomById(roomEntity);
    }


}
