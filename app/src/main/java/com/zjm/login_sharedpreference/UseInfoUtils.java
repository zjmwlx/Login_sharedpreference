package com.zjm.login_sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

/**
 * Created by zjm on 2017/7/22.
 */

class UseInfoUtils {
    public static boolean saveUser(Context context, String username, String password, boolean isrember) {
        //通过context获取sharedpreference
        SharedPreferences spf = context.getSharedPreferences("user", Context.MODE_PRIVATE);
        //获取editor对象
        SharedPreferences.Editor editor = spf.edit();
        if (isrember) {
            //往editor中添加数据
            editor.putString("username", username);
            editor.putString("password", password);
            //提交
            editor.commit();
        } else {
            editor.clear().commit();
        }
        return true;
    }

    public static HashMap<String, String> getUser(Context context) {
        //通过context获取sharedpreference
        SharedPreferences spf = context.getSharedPreferences("user", Context.MODE_PRIVATE);
        //获取数据
        String username = spf.getString("username", "");
        String password = spf.getString("password", "");
        HashMap<String, String> hashmap = new HashMap<>();
        hashmap.put("username", username);
        hashmap.put("password", password);
        return hashmap;
    }
}
