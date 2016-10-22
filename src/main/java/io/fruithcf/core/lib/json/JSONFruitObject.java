package io.fruithcf.core.lib.json;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Copyright © 2016 Matthew E Development - All Rights Reserved
 * You may NOT use, distribute and modify this code.
 * <p>
 * Created by Matthew E on 10/22/2016 at 8:37 AM.
 */
public class JSONFruitObject {

    private Map<String, Object> objectMap;

    public JSONFruitObject() {
        objectMap = Maps.newHashMap();
    }

    public Object get(String key) {
        return objectMap.get(key);
    }

    public String getString(String key) {
        return (String) get(key);
    }

    public JSONFruitObject getObject(String key) {
        return null;
    }

    public void put(String key, Object value) {
        objectMap.put(key, value);
    }
}
