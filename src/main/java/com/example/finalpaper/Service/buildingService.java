package com.example.finalpaper.Service;

import com.example.finalpaper.Entity.building;
import com.example.finalpaper.Mapper.buildingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class buildingService extends baseService{
    @Autowired
    private buildingMapper buildingMapper;


    //通过房间id查询
    public String getById(String buildingId) {
        building buildingResult = buildingMapper.selectbyid(buildingId);
        return formatBody(buildingResult);
    }

    //查询所有房间
    public String getAll() {
        List<building> buildingAll = buildingMapper.selectAll();
        return  transferBody(buildingAll) ;
    }

    //删除数据
    public int deleteById(String userId){
        return buildingMapper.deleteBuildingById(userId);
    }

    //增加数据
    public int insertById(building buildingEntity){
        return buildingMapper.insertbuilding(buildingEntity);
    }

    //修改数据
    public int updateById(building buildingEntity){
        return buildingMapper.updateBuildingById(buildingEntity);
    }
}
