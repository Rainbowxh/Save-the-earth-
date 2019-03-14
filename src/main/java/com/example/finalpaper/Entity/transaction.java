package com.example.finalpaper.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class transaction {
    @NonNull
    @NotBlank(message = "交易的id不能为空")
    public String transactionId;
    @NonNull
    @NotBlank(message = "交易的发起者不能为空")
    public String transactionFrom;
    @NonNull
    @NotBlank(message = "交易的收款者不能为空")
    public String transactionTo;
    @NonNull
    @NotBlank(message = "交易的数目不能为空")
    public int transactionAmount;
    public String transactionDescribtion;
    public Date startTime;
    public Date endTime;


    @Override
    public String toString(){
        return "{"
                + "\"transactionId\":\"" + transactionId + "\""
                + ", \"transactionFrom\":\"" + transactionFrom + "\""
                + ", \"transactionTo\":\"" + transactionTo + "\""
                + ", \"transactionAmount\":\"" + transactionAmount + "\""
                + ", \"transactionDescribtion\":\"" + transactionDescribtion + "\""
                + ", \"startTime\":\"" + startTime + "\""
                + ", \"endTime\":\"" + endTime + "\""
                + "}";
    }

}
