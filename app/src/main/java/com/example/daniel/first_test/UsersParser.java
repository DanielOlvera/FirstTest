package com.example.daniel.first_test;

import com.example.daniel.first_test.entities.UsersPJ;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel on 11/1/16.
 */

public class UsersParser {

    public ArrayList<UsersPJ> parserMagic (String json){
        Gson gson = new Gson();
        Type listType = new TypeToken<List<UsersPJ>>(){}.getType();

        return gson.fromJson(json, listType);
    }
}
