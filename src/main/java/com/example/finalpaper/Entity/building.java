package com.example.finalpaper.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class building {
    @NotBlank(message = "大楼的id不能为空")
    @NonNull
    private String buildingId;
    @NotBlank(message = "大楼的名字不能为空")
    @NonNull
    private String buildingName;
    private String buildingDescribtion;
    private String latitude;
    private String longitude;

    @Override
    public String toString(){
        return "{"
                + "\"buildingId\":\"" + buildingId + "\""
                + ", \"buildingName\":\"" + buildingName + "\""
                + ", \"buildingDescribtion\":\"" + buildingDescribtion + "\""
                + ", \"latitude\":\"" + latitude + "\""
                + ", \"longitude\":\"" + longitude + "\""
                + "}";
    }
}
