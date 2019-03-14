package com.example.finalpaper.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class worker {
    @NonNull
    @NotBlank(message = "工作者的id不能为空")
    public String workerId;
    @NonNull
    @NotBlank(message="工作者Name不能为空")
    public String workerName;
    public String workerType;
    public String workerEmail;
    public String workerTelephone;
    public String workerDescribtion;
    public Boolean workerOn;

    @Override
    public String toString(){
        return "{"
                + "\"workerId\":\"" + workerId + "\""
                + ", \"workerName\":\"" + workerName + "\""
                + ", \"workerType\":\"" + workerType + "\""
                + ", \"workerEmail\":\"" + workerEmail + "\""
                + ", \"workerTelephone\":\"" + workerTelephone + "\""
                + ", \"workerDescribtion\":\"" + workerDescribtion + "\""
                + "}";
    }
}
