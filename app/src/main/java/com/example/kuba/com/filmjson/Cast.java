package com.example.kuba.com.filmjson;

/**
 * Created by RENT on 2017-07-07.
 *
 *
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Cast {

    @SerializedName("name")
    @Expose
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}


