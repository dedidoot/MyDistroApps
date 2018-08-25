package com.mydistroapps.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Dedi Dot on 8/25/2018.
 * Happy Coding!
 */

public class DetailPojo {

    @SerializedName("id")
    @Expose
    public int id;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("brand")
    @Expose
    public String brand;

    @SerializedName("image_url")
    @Expose
    public String imageUrl;

    @SerializedName("description")
    @Expose
    public String description;

    @SerializedName("price")
    @Expose
    public String price;

}
