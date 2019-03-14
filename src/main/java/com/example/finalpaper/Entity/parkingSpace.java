package com.example.finalpaper.Entity;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class parkingSpace {
    @NonNull
    @NotBlank(message = "车位的parkingSpaceId不能为空")
    public String parkingSpaceId;
    public String useruuid;
    public String parkingSpaceType;
    public String parkingSpaceDescribtion;
    public boolean parkingSpaceBelong;
    public float latitude;
    public float longitude;

    @Override
    public String toString(){
        return "{"
                + "\"parkingSpaceId\":\"" + parkingSpaceId + "\""
                + ", \"useruuid\":\"" + useruuid + "\""
                + ", \"parkingSpaceType\":\"" + parkingSpaceType + "\""
                + ", \"parkingSpaceDescribtion\":\"" + parkingSpaceDescribtion + "\""
                + ", \"parkingSpaceBelong\":\"" + parkingSpaceBelong + "\""
                + "}";
    }

}
