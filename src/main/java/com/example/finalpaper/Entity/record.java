package com.example.finalpaper.Entity;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.Date;

import static com.example.finalpaper.util.TransferList.transDate;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class record {
    @NonNull
    @NotBlank(message = "历史记录的id不能为空")
    public String recordId;
    public String useruuid;
    public String facilityId;
    public String recordType;
    public String recordDescribtion;
    public Date startTime;
    public Date endTime;
    public Boolean recordFinish;
    public String workerId;

    @Override
    public String toString(){
        return "{"
                + "\"recordId\":\"" + recordId + "\""
                + ", \"useruuid\":\"" + useruuid + "\""
                + ", \"facilityId\":\"" + facilityId + "\""
                + ", \"recordType\":\"" + recordType + "\""
                + ", \"recordDescribtion\":\"" + recordDescribtion + "\""
                + ", \"startTime\":\"" + transDate(startTime) + "\""
                + ", \"endTime\":\"" + transDate(endTime) + "\""
                + ", \"recordFinish\":\"" + recordFinish + "\""
                + ", \"workerId\":\"" + workerId + "\""
                + "}";
    }
}
