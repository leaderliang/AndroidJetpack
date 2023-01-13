package com.android.jetpack.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 * JsonUtil
 * <p>
 * Note:
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2022/8/29 11:19
 */
public final class JsonUtil {

    public static <T> T parseJson(String jsonPath, Class<T> c) {
        String mContentJson = getJson(jsonPath);
        Gson gson = new Gson();
        try {
            T t = gson.fromJson(mContentJson, c);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Type typeOfT = new TypeToken<List<Class<T>>>() {}.getType();
     *
     * @param jsonPath
     * @param type
     * @param <T>
     * @return
     */
    public static <T> List<T> parseArrayJson(String jsonPath, Type type) {
        String mContentJson = getJson(jsonPath);
        Gson gson = new Gson();
        try {
            List<T> t = gson.fromJson(mContentJson, type);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * String path = "/storage/emulated/0/66nao_game/content.json";
     * List<GameVersionInfo> info = JsonUtil.parseArrayJson(path, GameVersionInfo.class);
     *
     * @param path
     * @param c
     * @param <T>
     * @return
     */
    public static <T> List<T> parseArrayJson(String path, Class<T> c) {
        String contentJson = getJson(path);
        TypeToken<?> array = TypeToken.getArray(c);
        Gson gson = new Gson();
        T[] object = gson.fromJson(contentJson, array.getType());
        try {
            List<T> t = (List<T>) Arrays.asList(object);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String getJson(String jsonPath) {
        File myFile = new File(jsonPath);
        if (!myFile.exists()) {
            throw new NullPointerException("Can't Find " + jsonPath);
        }
        StringBuilder sb = new StringBuilder();
        try {
            FileInputStream is = new FileInputStream(jsonPath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            is.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public static void writeJsonToFile(String path, String newJsonString) {
        try {
            FileWriter fw = new FileWriter(path);
            PrintWriter out = new PrintWriter(fw);
            out.write(newJsonString);
            out.println();
            fw.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
