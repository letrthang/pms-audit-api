package com.pms.audit.utils;

import com.app.hackathon.lib.utils.LocalDateTimeTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;

@UtilityClass
public class JsonUtils {

    private final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
            .setPrettyPrinting().create();

    public static <T> T fromJson(String json, Class<T> tClass){
        return gson.fromJson(json, tClass);
    }
}
