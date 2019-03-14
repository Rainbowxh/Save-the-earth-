package com.example.finalpaper.Mapper.builder;

import com.example.finalpaper.Entity.parkingSpace;
import org.apache.ibatis.jdbc.SQL;

public class UpdateBuilder {
    public static String updateParkingSpaceById(final parkingSpace parkingSpace){
        return new SQL(){{
            UPDATE("parkingSpace");
            if(parkingSpace.useruuid != null)
                SET("user_uuid = #{useruuid}");
            if(parkingSpace.parkingSpaceDescribtion != null);
                SET("parking_describtion = #{parkingSpaceDescribtion}");
            if(parkingSpace.parkingSpaceType != null);
                SET("parking_type = #{parkingSpaceType}");
            if(parkingSpace.parkingSpaceBelong != false);
                SET("parking_belong = #{parkingSpaceBelong}");
            WHERE("parking_id = #{parkingSpaceId}");
        }}.toString();
    }
}
