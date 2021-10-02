package com.example.email.hutool;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.TypeReference;
import com.alibaba.fastjson.JSONObject;
import com.example.email.model.User;

import java.util.Date;

public class ConvertTest {

    public static void test1() {
        int a = 1;
        //aStr为"1"
        String aStr = Convert.toStr(a);
        System.out.println(aStr);

        long[] b = {1, 2, 3, 4, 5};
        //bStr为："[1, 2, 3, 4, 5]"
        String bStr = Convert.toStr(b);
        System.out.println(bStr);

        String c = "3.33";
        System.out.println(Convert.toDouble(c,0D));
        String d = null;
        System.out.println(Convert.toDouble(d,0D));
    }

    public static void test2() {
        String[] b = { "1", "2", "3", "4" };
        //结果为Integer数组
        Integer[] intArray = Convert.toIntArray(b);
        System.out.println(intArray);

        long[] c = {1,2,3,4,5};
        //结果为Integer数组
        Integer[] intArray2 = Convert.toIntArray(c);
        System.out.println(intArray2);

        User user = new User();
        user.setUserId(1L);
        user.setUserName("sfds");
        String userJson = JSONObject.toJSONString(user);
        User convert = Convert.convert(User.class, user);
        User convert2 = Convert.convert(new TypeReference<User>() {
        }, user);
        System.out.println(convert.getUserId() + "--" + convert.getUserName());
        System.out.println(convert2.getUserId() + "--" + convert2.getUserName());
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test3() {
        String a = "2017-05-06";
        Date value = Convert.toDate(a);
        System.out.println(value);

        String b = "2017-05-06 13:44:33";
        Date value2 = Convert.toDate(a);
        System.out.println(value2);
    }

}
