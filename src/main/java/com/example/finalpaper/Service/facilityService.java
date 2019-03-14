package com.example.finalpaper.Service;

import com.example.finalpaper.Entity.facility;
import com.example.finalpaper.Mapper.facilityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class facilityService extends baseService {
    @Autowired
    private facilityMapper facilityMapper;


    //通过房间id查询
    public String getById(String facilityId) {
        facility facilityResult = facilityMapper.selectbyid(facilityId);
        return formatBody(facilityResult);
    }

    //查询所有房间
    public String getAll() {
        List<facility> facilityAll = facilityMapper.selectAll();
        return  transferBody(facilityAll) ;
    }

    //通过用户id来查询
    public String getByUserId(String facilityType) {
        List<facility> facilityByUserId = facilityMapper.selectByFacilityType(facilityType);
        return transferBody(facilityByUserId);
    }

    //删除数据
    public int deleteById(String facilityId){
        return facilityMapper.deleteFacilityById(facilityId);
    }

    //增加数据
    public int insertById(facility facilityEntity){
        return facilityMapper.insertFacilityById(facilityEntity);
    }

    //修改数据
    public int updateById(facility facilityEntity){
        return facilityMapper.updateFacilityById(facilityEntity);
    }
}
