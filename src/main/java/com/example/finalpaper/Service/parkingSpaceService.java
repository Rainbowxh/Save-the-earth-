package com.example.finalpaper.Service;

import com.example.finalpaper.Entity.parkingSpace;
import com.example.finalpaper.Mapper.parkingSpaceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class parkingSpaceService extends baseService{
    @Autowired
    private com.example.finalpaper.Mapper.parkingSpaceMapper parkingSpaceMapper;


    //通过房间id查询
    public String getById(String parkingSpaceId) {
        parkingSpace parkingSpaceResult = parkingSpaceMapper.selectbyid(parkingSpaceId);
        return formatBody(parkingSpaceResult);
    }

    //查询所有房间
    public String getAll() {
        List<parkingSpace> parkingSpaceAll = parkingSpaceMapper.selectAll();
        return  transferBody(parkingSpaceAll) ;
    }

    //删除数据
    public int deleteById(String userId){
        return parkingSpaceMapper.deleteParkingSpaceById(userId);
    }

    //增加数据
    public int insertById(parkingSpace parkingSpaceEntity){
        return parkingSpaceMapper.insertParkingSpaceById(parkingSpaceEntity);
    }

    //修改数据
    public int updateById(parkingSpace parkingSpaceEntity){
        return parkingSpaceMapper.updateParkingSpaceById(parkingSpaceEntity);
    }

    //没有分配的停车位
    public String getUseruuidNone(){
        List<parkingSpace> spaces = parkingSpaceMapper.selectUseruuidNone();
        return transferBody(spaces);
    }
}
