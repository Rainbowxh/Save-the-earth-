package com.example.finalpaper.Service;

import com.example.finalpaper.Entity.room;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


public class baseService {
    protected String serviceName;

    public String getServiceName() {
        return this.serviceName;
    }

    public void setServiceName(String serviceName){
        this.serviceName = serviceName;
    }

    //反射的方式定义是否需要data
    public String getName(){
        Class clazz = this.getClass();
        try {
            Field field = clazz.getDeclaredField("serviceName");
            String result = field.get(this).toString();
            return result == null ? "data" : result;
        }catch (Exception e){
            return "data";
        }

    }

    protected <T> String transferBody(List<T> roomTmp){
        String roomBody = roomTmp.stream()
                .map(T::toString)
                .collect(Collectors.joining(","));
        return "{\""+this.getName()+"\":[" + roomBody + "]}";
    }
    //todo: 通过反射的方式获取变量名称,java中的反编译
    protected <T> List<T> transferParams(String funcName){
        Class getClass = this.getClass();
        LocalVariableTableParameterNameDiscoverer names =  new LocalVariableTableParameterNameDiscoverer();
        Method[] methods = getClass.getDeclaredMethods();
        for(Method method: methods){
            System.out.println(method.getName());
            if(funcName.equals(method.getName())){
                String[] params = names.getParameterNames(method);
            }
        }
       return null;
    }

    protected <T> String formatBody(T t){
        String body = t.toString();
        return "{\"data\":[" + body + "]    }";
    }



}
