package com.techxora.retrofitsample;

import com.google.gson.annotations.SerializedName;

public class ResponseModelClass {

    @SerializedName("status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
