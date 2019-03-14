package com.example.finalpaper.Service;

import com.example.finalpaper.Entity.worker;
import com.example.finalpaper.Mapper.workerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class workerService extends  baseService {
    @Autowired
    private com.example.finalpaper.Mapper.workerMapper workerMapper;


    //通过记录id查询
    public String getById(String workerId) {
        worker workerResult = workerMapper.selectbyid(workerId);
        return formatBody(workerResult);
    }

    //查询所有记录
    public String getAll() {
        List<worker> workerAll = workerMapper.selectAll();
        return  transferBody(workerAll) ;
    }

    //通过用户id来查询
    public String getByUserId(String workerType) {
        List<worker> workerByUserId = workerMapper.selectByworkerType(workerType);
        return transferBody(workerByUserId);
    }

    //删除数据
    public int deleteById(String workerId){
        return workerMapper.deleteWorkerById(workerId);
    }

    //增加数据
    public int insertById(worker workerEntity){
        return workerMapper.insertRecordById(workerEntity);
    }

    //修改数据
    public int updateById(worker workerEntity){
        return workerMapper.updateRecordById(workerEntity);
    }
}
