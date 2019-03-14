package com.example.finalpaper.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import static com.example.finalpaper.util.TransferList.transDate;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class facility {
    @NonNull
    @NotBlank(message = "设备的id不能为空")
    public String facilityId;
    @NonNull
    @NotBlank(message = "设备的Name不能为空")
    public String facilityName;
    @NonNull
    @NotBlank(message = "设备的Type不能为空")
    public String facilityType;
    public String facilityDescribtion;
    public String facilityStatus;
    public Date startTime;
    public Date endTime;
    public float latitude;
    public float longitude;


    @Override
    public String toString(){
        return "{"
                + "\"facilityId\":\"" + facilityId + "\""
                + ", \"facilityName\":\"" + facilityName + "\""
                + ", \"facilityType\":\"" + facilityType + "\""
                + ", \"facilityDescribtion\":\"" + facilityDescribtion + "\""
                + ", \"facilityStatus\":\"" + facilityStatus + "\""
                + ", \"startTime\":\"" + transDate(startTime) + "\""
                + ", \"endTime\":\"" + transDate(endTime) + "\""
                + "}";
    }
}
