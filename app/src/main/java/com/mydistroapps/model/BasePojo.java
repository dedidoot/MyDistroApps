package com.mydistroapps.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dedi Dot on 8/25/2018.
 * Happy Coding!
 */

public class BasePojo {

    @SerializedName("status")
    @Expose
    public boolean status;

    @SerializedName("list")
    @Expose
    public List<DetailPojo> detailPojos = new ArrayList<>();

}
