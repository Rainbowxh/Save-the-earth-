package com.example.finalpaper.Service;

import com.example.finalpaper.Entity.record;
import com.example.finalpaper.Mapper.recordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class recordService extends  baseService{
    @Autowired
    private recordMapper recordMapper;

    //通过记录id查询
    public String getById(String recordId) {
        record recordResult = recordMapper.selectbyid(recordId);
        return formatBody(recordResult);
    }

    //查询所有记录
    public String getAll() {
        List<record> recordAll = recordMapper.selectAll();
        return  transferBody(recordAll) ;
    }

    //通过用户id来查询
    public String getByUserId(String userId) {
        List<record> recordByUserId = recordMapper.selectByUserId(userId);
        return transferBody(recordByUserId);
    }

    //删除数据
    public int deleteById(String recordId){
        return recordMapper.deleteRecordById(recordId);
    }

    //增加数据
    public int insertById(record recordEntity){
        return recordMapper.insertRecordById(recordEntity);
    }

    //修改数据
    public int updateById(record recordEntity){
        return recordMapper.updateRecordById(recordEntity);
    }

    public static void main(String[] args) {
        recordService a = new recordService();
        System.out.println(a.getName());
    }

}
