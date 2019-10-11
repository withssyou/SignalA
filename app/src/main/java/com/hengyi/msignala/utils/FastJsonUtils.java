package com.hengyi.msignala.utils;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONLibDataFormatSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * fastjson工具类
 *
 * @version:1.0.0
 */
public class FastJsonUtils {

    private static final SerializeConfig config;
    private static SerializeConfig mapping = new SerializeConfig();
    private static String dateFormat;

    static {
        dateFormat = "yyyy-MM-dd HH:mm:ss";
        config = new SerializeConfig();
        config.put(Date.class, new JSONLibDataFormatSerializer()); // 使用和json-lib兼容的日期输出格式
        config.put(java.sql.Date.class, new JSONLibDataFormatSerializer()); // 使用和json-lib兼容的日期输出格式
    }

    public static String toJSONString(Object object) {
        try {
            return JSON.toJSONString(object, SerializerFeature.WriteDateUseDateFormat);
//            return JSON.toJSONString(object, config, features);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 自定义时间格式
     *
     * @param jsonText
     * @return
     */
    public static String toJSON(Object jsonText) {
        mapping.put(Date.class, new SimpleDateFormatSerializer(dateFormat));
        return JSON.toJSONString(jsonText, mapping);
    }


    public static <T> T toBean(String jsonStr, Class<T> clazz) {
        if (TextUtils.isEmpty(jsonStr)) {
            return null;
        }
        try {
            return JSON.parseObject(jsonStr, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    /**
     * json 转换成 数组
     *
     * @param jsonStr
     * @param <T>
     * @return
     */
    public static <T> Object[] toArray(String jsonStr) {
        if (TextUtils.isEmpty(jsonStr)) {
            return null;
        }
        try {
            return toArray(jsonStr, null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    // 转换为数组
    public static <T> Object[] toArray(String jsonStr, Class<T> clazz) {
        if (TextUtils.isEmpty(jsonStr)) {
            return null;
        }
        try {
            return JSON.parseArray(jsonStr, clazz).toArray();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * json 转 List
     *
     * @param jsonStr
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> toList(String jsonStr, Class<T> clazz) {
        if (TextUtils.isEmpty(jsonStr)) {
            return null;
        }
        try {
            return JSON.parseArray(jsonStr, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    /**
     * 将string转化为序列化的json字符串
     *
     * @param jsonStr
     * @return
     */
    public static Object json2json(String jsonStr) {
        if (TextUtils.isEmpty(jsonStr)) {
            return null;
        }
        try {
            return JSON.parse(jsonStr);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * json字符串转化为map
     *
     * @param jsonStr
     * @return
     */
    public static Map json2map(String jsonStr) {
        if (TextUtils.isEmpty(jsonStr)) {
            return null;
        }
        try {
            return JSONObject.parseObject(jsonStr);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 将map转化为string
     *
     * @param m
     * @return
     */
    public static String map2Json(Map m) {
        try {
            return JSONObject.toJSONString(m);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    /**
     * list集合转json格式字符串
     */
    public static String list2Json(List list) {
        try {
            return JSON.toJSONString(list, true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Bean转json格式字符串
     */
    public static String bean2Json(Object obj) {
        try {
            return JSON.toJSONString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}