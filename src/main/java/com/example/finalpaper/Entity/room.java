package com.example.finalpaper.Entity;

import lombok.*;

import javax.validation.constraints.NotBlank;


@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class room  {
    @NotBlank(message = "房间的id不能为空")
    @NonNull
    public String roomuuid;
    public String useruuid;
    public String buildingid;
    public String describtion;
    public Boolean belong = false;
    public Float latitude;
    public Float longitude;


    @Override
    public String toString(){
        return "{"
                + "\"roomuuid\":\"" + roomuuid + "\""
                + ", \"useruuid\":\"" + useruuid + "\""
                + ", \"buildingid\":\"" + buildingid + "\""
                + ", \"describtion\":\"" + describtion + "\""
                + ", \"belong\":\"" + belong + "\""
                + "}";
    }
}
