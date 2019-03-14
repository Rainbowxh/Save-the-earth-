package com.example.finalpaper.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class user {
    @NotBlank(message = "用户的id不能为空")
    @NonNull
    private String useruuid;
    @NonNull
    @NotBlank(message = "用户姓名不能为空")
    private String userName;
    private String userType;
    @NonNull
    @NotBlank(message = "用户手机不能为空")
    private String userTelephone;
    private String roomuuid;
    private String userEmail;
    private String userDescribtion;
    private BigDecimal property;

    @Override
    public String toString(){
        return "{"
                + "\"useruuid\":\"" + useruuid + "\""
                + ", \"userName\":\"" + userName + "\""
                + ", \"userType\":\"" + userType + "\""
                + ", \"userTelephone\":\"" + userTelephone + "\""
                + ", \"userEmail\":\"" + userEmail + "\""
                + ", \"userDescribtion\":\"" + userDescribtion + "\""
                + ", \"roomuuid\":\"" + roomuuid + "\""
                + ", \"property\":\"" + property + "\""
                + "}";
    }
}
